package com.example.beijing.controller;

import com.example.beijing.cache.CacheService;
import com.example.beijing.cache.ParamCache;
import com.example.beijing.domain.Param;
import com.example.beijing.util.WebResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private ParamCache cacheService;

    @RequestMapping(value = "/hello",method = RequestMethod.POST)
    @ResponseBody
    public WebResult sayHello(){

        return new WebResult();
    }

    @RequestMapping(value = "/getParam/{key}",method = RequestMethod.GET)
    @ResponseBody
    public WebResult getParam(@PathVariable(value = "key") String key){
        Long start = System.currentTimeMillis();
        List<Param> params = cacheService.getParamBykey(key);
        return new WebResult(params,String.valueOf(System.currentTimeMillis()-start));
    }

}
