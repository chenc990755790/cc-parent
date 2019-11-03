package com.example.beijing.dao;

import com.example.beijing.domain.Param;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ParamDao {

    @Select("select distinct param_key from param")
    List<String> getParamKey();

    List<Param> getParamByParamKey(String paramKey);

}
