package com.example.beijing.cache;

import com.alibaba.fastjson.JSONObject;
import com.example.beijing.domain.Param;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oracle.tools.packager.Log;
import lombok.extern.slf4j.Slf4j;
import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;

@Service
@Slf4j
public abstract class CacheService implements InitializingBean{

//    private final static Logger logger = LoggerFactory.getLogger(ParamCacheService.class);

    @Autowired
    private EhCacheCacheManager cacheCacheManager;

    private Cache cache;
    @Autowired
    ObjectMapper objectMapper;

//    @Value("${aopcache.redis.enabled}")
    private Boolean enabled;

    protected abstract Collection<Element> getCacheData();

    protected abstract String getCacheName();

    @Override
    public void afterPropertiesSet() throws Exception {
        if (cache == null) {
            cache = cacheCacheManager.getCacheManager().getCache(getCacheName());
        }
        cache.putAll(getCacheData());
    }

//    public Cache getCache() {
//        if (cache == null) {
//            cache = cacheCacheManager.getCacheManager().getCache("param");
//        }
//        return this.cache;
//    }
//
//    public <T> T get(Object key, Class<T> clazz) {
//        if (!enabled) {
//            return null;
//        }
//        Cache ksCache = getCache();
//        Element e = ksCache.get(key);
//        String rest = null;
//        if (e == null) {
//            return null;
//        } else {
//            rest = (String) e.getObjectValue();
//            return JSONObject.parseObject(rest,clazz);
//            //return JsonMapper.getInstance().fromJson(rest, clazz);
//        }
//    }
//
//    public <T> T get(Object key, Class<?> parametrized, Class<?>... parameterClasses) {
//        if (!enabled) {
//            return null;
//        }
//        Cache ksCache = getCache();
//        Element e = ksCache.get(key);
//        String rest = null;
//        if (e == null) {
//            return null;
//        } else {
//            rest = (String) e.getObjectValue();
//            JavaType javaType = objectMapper.getTypeFactory().constructParametricType(parametrized, parameterClasses);
//            return JSONObject.parseObject(rest,javaType);
//            //return JsonMapper.getInstance().fromJson(rest, javaType);
//        }
//    }
//
//
//    public void put(Object key, Object value, int expire) {
//        try {
//            String json = objectMapper.writeValueAsString(value);
//            Element e = new Element(key, json);
//            e.setTimeToLive(expire);
//            Cache ksCache = getCache();
//            ksCache.put(e);
//        } catch (Exception e) {
//        }
//
//    }
//    public void remove(Object key) {
//        cache.remove(key);
//    }


//    public void mPut(String key, Object k, Object v) {
//        HashMap map = this.get(key, HashMap.class);
//        if (map == null) {
//            map = new HashMap();
//        }
//        map.put(k, v);
//        this.put(k, map, 0);
//    }
//
//    public void mRemove(String key, Object k) {
//        HashMap map = this.get(key, HashMap.class);
//        if (map != null) {
//            map.remove(k);
//            this.put(k, map, 0);
//        }
//    }
//
//    public Object mGet(String key, Object k, Class<?> parameterClasses) {
//        HashMap map = this.get(key, HashMap.class, parameterClasses);
//        if (map == null || !map.containsKey(k)) {
//            return null;
//        }
//        return map.get(k);
//    }


}
