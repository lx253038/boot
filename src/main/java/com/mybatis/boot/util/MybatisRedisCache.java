package com.mybatis.boot.util;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.cache.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.CollectionUtils;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

/**
 * @Author LX
 * @Date 2019/12/4 14:26
 * @Description TODO
 */
@Slf4j
@Data
public class MybatisRedisCache implements Cache {

    @Autowired
    private RedisTemplate redisTemplate;


    // 读写锁
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock(true);


    private String id;

    public MybatisRedisCache(final String id) {
        if (id == null) {
            throw new IllegalArgumentException("Cache instances require an ID");
        }
        log.info("Redis Cache id " + id);
        this.id = id;
    }


    @Override
    public void putObject(Object key, Object value) {
        if (value != null) {
            key = formatKey(key.toString());
            log.info("Redis缓存添加数据(MyBatis缓存)：key=" + key);
            try {
                redisTemplate.opsForValue().set(key, value, 2, TimeUnit.DAYS);
            } catch (Exception e) {
//                e.printStackTrace();
                log.error("===================================发生异常===================================");
                log.error(e.getMessage());
                log.error("==============================================================================");
            }
        }
    }


    @Override
    public Object getObject(Object key) {
        if (key != null) {
            key = formatKey(key.toString());
            try {
                Object o = redisTemplate.opsForValue().get(key);
                if (o != null) {
                    log.info("Redis缓存获取到数据：value=" + o);
                    return o;
                }
            } catch (Exception e) {
//                e.printStackTrace();
                log.error("===================================发生异常===================================");
                log.error(e.getMessage());
                log.error("==============================================================================");
            }

        }
        return null;
    }

    @Override
    public Object removeObject(Object key) {
        if (key != null) {
            key = formatKey(key.toString());
            redisTemplate.delete(key);
            log.info("Redis缓存删除数据：key=" + key);
        }
        return null;
    }

    @Override
    public void clear() {
        log.debug("《=================清空缓存============》");
        try {
            Set<String> keys = redisTemplate.keys("*:" + this.id + "*");
            if (!CollectionUtils.isEmpty(keys)) {
                Long number = redisTemplate.delete(keys);
                log.info("《=================删除\t" + number + "\t条记录============》");
            }
        } catch (Exception e) {
            log.error("Redis发生未知异常");
        }
    }

    @Override
    public int getSize() {
        Long size = (Long) redisTemplate.execute((RedisCallback<Long>) connection -> connection.dbSize());
        return size.intValue();

    }

    private RedisTemplate getRedisTemplate() {
        if (redisTemplate == null) {
            redisTemplate = (RedisTemplate) SpringContextUtil.getBean("redisTemplate");
        }
        return redisTemplate;
    }


    private String formatKey(String key) {
        Pattern p = compile("\\s*|\t|\r|\n");
        Matcher m = p.matcher(key);
        String result = m.replaceAll("");
        return result;
    }
}

