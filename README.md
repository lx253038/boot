## SpringBoot+Mybatis+Redis+RabbitMQ秒杀系统
####应用到的技术点:
- springboot整合mybatis/mybatis-plus实现数据的增、删、改、查等基础功能
- springboot整合redis，配置redisTemplate 使用fastjson实现key、value的序列化以及自定义key的生成规则等功能
- springboot整合rabbitmq实现消息的发送和接收等基本功能
- springboot整合fastDfs文件服务器实现了对文件的上传和下载等功能
- 使用redis实现了mybatis的自定义二级缓存功能
#####Mybatis知识点
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














































#### 事务传播
- REQUIRED: 使用当前的事务，如果当前没有事务，则自己新建一个事务，子方法是必须运行在一个事务中的；如果当前存在事务，则加入这个事务，成为一个整体。适用于增、删、改。
- SUPPORTS: 如果当前有事务，则使用事务。如果当前没有事务，则不使用事务。适用于查询。
- MANDATORY: 强制调用方必须有事务，如果不存在，则抛出异常。
- REQUIRES_NEW: 如果当前有事务，则挂起该事务，并且创建新事务。如果当前没有事务，相当于REQUIRED。 
- NOT_SUPPORTED: 如果当前有事务，则挂起该事务。如果当前没有事务，则不使用事务。
- NEVER: 强制调用方必须没有事务，如果存在，则抛出异常。
- NESTED: 如果当前有事务，，并且开启子事务(嵌套事务)，嵌套事务是对立提交或者回滚，但是如果主事务提交，则会携带子事务一起提交，如果主事务回滚，则子事务会一起回滚，相反，子事务异常，则父事务可以回滚或不回滚。如果当前没有事务，相当于REQUIRED。
 
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

#### AOP 通知
- 前置通知：在方法调用前执行
- 后置通知：在方法正常调用后执行
- 环绕通知：在方法调用前后，都分别可以执行的通知
- 异常通知：如果在方法调用过程中发生异常，则通知
- 最终通知：在方法调用之后调用

```
/**
 * 切面表达式：
 * execution 代表所要执行的表达式主体
 * 第一处 * 代表方法返回类型 *代表所有类型
 * 第二处 包名代表aop监控的类所在的包
 * 第三处 .. 代表该包以及其子包下的所有类方法
 * 第四处 * 代表类名，*代表所有类
 * 第五处 *(..) *代表类中的方法名，(..)表示方法中的任何参数
*/
@Around("execution(* com.imooc.service.impl..*.*(..))")
public Object recordTimeLog(ProceedingJoinPoint joinPoint) throws Throwable {
    // TODO: 切面逻辑处理代码
}
```
