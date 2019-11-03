package com.example.beijing.cache;

import com.example.beijing.dao.ParamDao;
import com.example.beijing.domain.Param;
import net.sf.ehcache.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class ParamCache extends CacheService {

    @Autowired
    private ParamDao paramDao;

    private final Collection<Element> elements = new CopyOnWriteArrayList<>();

    @Override
    public String getCacheName() {
        return CacheConst.PARAM_KEY;
    }

    @Override
    protected Collection<Element> getCacheData() {
        List<String> keys = paramDao.getParamKey();
        for (String key :keys) {
            List<Param> params = paramDao.getParamByParamKey(key);
            elements.add(new Element(key,params));
        }
        return elements;
    }

    //@Cacheable(value = CacheConst.PARAM_KEY)
    public List<Param> getParamBykey(String key){
        return paramDao.getParamByParamKey(key);
    }

}
