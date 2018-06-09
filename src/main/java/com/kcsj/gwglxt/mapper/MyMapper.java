package com.kcsj.gwglxt.mapper;

import com.kcsj.gwglxt.entity.manage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MyMapper {

    List<manage> getAll();
    manage getOne();
}
