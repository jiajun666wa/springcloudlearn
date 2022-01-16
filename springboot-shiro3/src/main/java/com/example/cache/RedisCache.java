package com.example.cache;

import com.example.utils.ApplicationContextUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.Collection;
import java.util.Set;

/**
 * @description: 设置描述信息
 * @author: whj
 * @createTime: 2021-12-25 20:38
 * @version: 1.0
 */
//自定义redis缓存实现
@Slf4j
public class RedisCache<k,v> implements Cache<k,v> {
    private String cacheName;
    public RedisCache(String cacheName){
        this.cacheName = cacheName;
    }

    public v get(k k) throws CacheException {
        System.out.println("get key"+k);
        return  (v)getRedisTemplate().opsForHash().get(this.cacheName,k.toString());
    }

    public v put(k k, v v) throws CacheException {
        System.out.println("put key"+k);
        System.out.println("put value"+v);

        getRedisTemplate().opsForHash().put(this.cacheName,k.toString(),v);
        return null;
    }

    public v remove(k k) throws CacheException {
        System.out.println("delete value"+keys().iterator().next().toString());
        System.out.println("delete value"+k.toString());
        return (v) getRedisTemplate().opsForHash().delete(this.cacheName,k.toString());
    }

    public void clear() throws CacheException {
        getRedisTemplate().opsForHash().delete(this.cacheName);
    }

    public int size() {
        return getRedisTemplate().opsForHash().size(this.cacheName).intValue();
    }

    public Set<k> keys() {
        return getRedisTemplate().opsForHash().keys(this.cacheName);
    }

    public Collection<v> values() {
        return getRedisTemplate().opsForHash().values(this.cacheName);
    }

    public RedisTemplate getRedisTemplate(){
        RedisTemplate  redisTemplate  = (RedisTemplate) ApplicationContextUtils.getBean("redisTemplate");

        //建议设置一下 key 和 hash key 的序列化器为String序列化器
         final StringRedisSerializer serializer = new StringRedisSerializer();

        redisTemplate.setKeySerializer(serializer);
        redisTemplate.setHashKeySerializer(serializer);

        return  redisTemplate;
    }
}
