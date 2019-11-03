package com.example.beijing.config;

import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


@Configuration
public class EhCacheConfig {
    @Bean
    public EhCacheManagerFactoryBean ehcacheManagerFactory() {
        Resource resource = new ClassPathResource("ehcache.xml");
        EhCacheManagerFactoryBean ehCacheManagerFactoryBean = new EhCacheManagerFactoryBean();
        ehCacheManagerFactoryBean.setConfigLocation(resource);
        return ehCacheManagerFactoryBean;
    }

    @Bean
    public EhCacheCacheManager initcache(EhCacheManagerFactoryBean ehcacheManagerFactory) {
        EhCacheCacheManager ehCacheCacheManager = new EhCacheCacheManager();
        ehCacheCacheManager.setCacheManager(ehcacheManagerFactory.getObject());
        return ehCacheCacheManager;
    }
}
