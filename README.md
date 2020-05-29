## SpringBoot+Mybatis+Redis+RabbitMQ秒杀系统
### 应用到的技术点:
- springboot整合mybatis/mybatis-plus实现数据的增、删、改、查等基础功能
- springboot整合redis，配置redisTemplate 使用fastjson实现key、value的序列化以及自定义key的生成规则等功能
- springboot整合rabbitmq实现消息的发送和接收等基本功能
- springboot整合fastDfs文件服务器实现了对文件的上传和下载等功能
- 使用redis实现了mybatis的自定义二级缓存功能
- 使用自定义注解和AOP的思想实现了系统日志信息的记录
- 分布式Session问题解决，将用户信息存储到redis中
- 添加线程池的配置以及在提交任务之前显示线程池线程数量、队列大小、已完成任务数等详细信息

### 相关知识点
#### 自定义注解使用AOP思想实现系统日志的记录
- 自定义注解
```
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SysLog {
    String value() default "";
}
```
- AOP五种通知类型
  > - 前置通知（Before）：在方法调用前执行
  > - 后置通知（After）：在方法正常调用后执行
  > - 环绕通知（Around） ：在方法调用前后，都分别可以执行的通知(环绕通知有控制目标方法是否执行、有控制是否返回值、有改变返回值的能力)
  > - 异常通知（AfterThrowing）：在方法抛出异常之后执行
  > - 返回通知（AfterReturning）： 在方法返回结果之后执行

- 定义一个普通的切面   
```
/**
 * 切面表达式：
 * execution 代表所要执行的表达式主体
 * 第一处 * 代表方法返回类型 *代表所有类型
 * 第二处 包名代表aop监控的类所在的包
 * 第三处 ..* 代表该包以及子包的所有类
 * 第四处 *(..) *代表类中的所有方法，(..)表示方法中的任何参数
*/
@Around("execution(* com.mybatis.boot.service.impl..*.*(..))")
public Object recordTimeLog(ProceedingJoinPoint joinPoint) throws Throwable {
    // TODO: 切面逻辑处理代码
}
```
- 定义一个注解类型的切面
```
@Aspect 
public class SysLogAspect {
    // 注解形式切点
    @Pointcut("@annotation(com.mybatis.boot.annotation.SysLog)")
    private void pointCut() {
    }
    @Around("pointCut()&&@annotation(sysLog)")
    public Object around(ProceedingJoinPoint joinPoint,SysLog sysLog) {
        try {
            result = joinPoint.proceed(); //调用目标方法
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return result;
    }
}

```
#### @Transactional 注解详解
- value/transactionManager：当在配置文件中有多个 TransactionManager , 可以用该属性指定选择哪个事务管理器(默认)
- propagation：事务的传播行为，默认REQUIRED
- isolation：事务的隔离度
- timeout：事务的超时时间，默认值为-1。如果超过该时间限制但事务还没有完成，则自动回滚事务。
- readOnly：指定事务是否为只读事务，默认值为 false；为了忽略那些不需要事务的方法，比如读取数据，可以设置 read-only 为 true。
- rollbackFor：用于指定能够触发事务回滚的异常类型，如果有多个异常类型需要指定，各类型之间可以通过逗号分隔。
- noRollbackFor：抛出 noRollbackFor 指定的异常类型，不回滚事务。

#### 事务传播行为
- REQUIRED: （默认）如果当前存在事务，则加入这个事务，如果当前没有事务，则自己新建一个事务。适用于增、删、改。
- REQUIRES_NEW: 如果当前有事务，则挂起该事务，并且创建新事务。如果当前没有事务，相当于REQUIRED直接创建新事务。 
- SUPPORTS: 如果当前有事务，则使用事务。如果当前没有事务，则不使用事务。适用于查询。
- NOT_SUPPORTED: 如果当前有事务，则挂起该事务。如果当前没有事务，则不使用事务。
- MANDATORY: 强制调用方必须有事务，如果不存在，则抛出异常。
- NEVER: 强制调用方必须没有事务，如果存在，则抛出异常。
- NESTED: 如果当前有事务，并且开启子事务(嵌套事务)，嵌套事务是对立提交或者回滚，但是如果主事务提交，则会携带子事务一起提交，如果主事务回滚，则子事务会一起回滚，相反，子事务异常，则父事务可以回滚或不回滚。如果当前没有事务，相当于REQUIRED。
 
#### Mybatis知识点
- springboot启动类添加@MapperScan()注解，扫描Mapper接口
```
@MapperScan("com.mybatis.boot.**.mapper")
@SpringBootApplication
public class BootApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootApplication.class, args);
    }
}
 ```
- application.yml配置文件添加mybatis相关配置  
```
mybatis-plus:
  mapper-locations: classpath:mapper/**/*.xml
  type-aliases-package: com.mybatis.boot.model
  configuration:
    cache-enabled: true
 ```
- 编写Mapper接口定义相关方法
```
public interface UserMapper {
    int insert(User record);
    User selectByPrimaryKey(Integer id);
    int updateByPrimaryKey(User record);
    int deleteByPrimaryKey(Integer id);
}
 ```
- 根据接口方法编写Mapper.xml文件以及相关方法的SQL语句
```
<mapper namespace="com.mybatis.boot.mapper.UserMapper">
    <resultMap id="BaseResultMap" type="com.mybatis.boot.model.User">
        <id column="id" jdbcType="INTEGER" property="id"/>
        <result column="name" jdbcType="VARCHAR" property="name"/>
        <result column="age" jdbcType="INTEGER" property="age"/>
    </resultMap>
    <sql id="Base_Column_List">
        id, name, age
    </sql>
    <insert id="insert" parameterType="com.mybatis.boot.model.User">
        insert into users (id, name, age
        )
        values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, #{age,jdbcType=INTEGER}
        )
    </insert>
    <select id="selectByPrimaryKey" parameterType="java.lang.Integer" resultMap="BaseResultMap">
        select
        <include refid="Base_Column_List"/>
        from users
        where id = #{id,jdbcType=INTEGER}
    </select>
    <update id="updateByPrimaryKey" parameterType="com.mybatis.boot.model.User">
        update users
        set name = #{name,jdbcType=VARCHAR},
        age = #{age,jdbcType=INTEGER}
        where id = #{id,jdbcType=INTEGER}
    </update>
    <delete id="deleteByPrimaryKey" parameterType="java.lang.Integer">
        delete from users
        where id = #{id,jdbcType=INTEGER}
    </delete>
</mapper>
 ```


#### Cookie 和 Session
- Cookie
    > - 以键值对的形式存储信息在浏览器
    > - cookie不能跨域，当前及父级域名可以取值
    > - cookie的大小不能超过4KB
    > - cookie可以设置有效期和path
- Session
    > - 基于服务器内存的缓存(非持久化), 可保存请求会话。
    > - 每个session通过sessionid来区分不同请求
    > - session可以设置过期时间
    > - 以键值对的形式存储信息


