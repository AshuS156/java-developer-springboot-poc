package com.javatechie.caching.config;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

@Service
public class CacheInspectionManager{

    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(CacheInspectionManager.class);
    @Autowired
    CacheManager cacheManager;

    public void printCacheContent(String cacheName) {
        final Cache cache = cacheManager.getCache(cacheName);
        if(cache != null) {
            logger.info("Cache Name: {}", cacheName);
            logger.info("Cache Details: {}" ,  cache.getNativeCache().toString());
        } else {
            logger.info("Cache with name : {}" , cacheName + "' does not exist.");
        }
        //cacheManager.getCacheNames().forEach(System.out::println);
    }
}
