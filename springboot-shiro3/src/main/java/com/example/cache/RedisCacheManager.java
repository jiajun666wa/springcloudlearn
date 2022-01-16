package com.example.cache;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;

/**
 * @description: 设置描述信息
 * @author: whj
 * @createTime: 2021-12-25 20:25
 * @version: 1.0
 */
@Slf4j
public class RedisCacheManager implements CacheManager {
    //授权缓存
    public <K, V> Cache<K, V> getCache(String cacheName) throws CacheException {
        log.info("==》"+cacheName);
        return new RedisCache<K, V>(cacheName);
    }
}
