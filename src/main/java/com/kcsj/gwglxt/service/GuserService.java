package com.kcsj.gwglxt.service;

import com.kcsj.gwglxt.entity.Guser;
import com.kcsj.gwglxt.entity.GuserExample;
import com.kcsj.gwglxt.entity.loginCustom;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GuserService {
    int countByExample(GuserExample example);

    int deleteByExample(GuserExample example);

    int deleteByPrimaryKey(String userId);

    int insert(Guser record);

    int insertSelective(Guser record);

    List<Guser> selectByExample(GuserExample example);

    Guser selectByPrimaryKey(String userId);

    int updateByExampleSelective(@Param("record") Guser record, @Param("example") GuserExample example);

    int updateByExample(@Param("record") Guser record, @Param("example") GuserExample example);

    int updateByPrimaryKeySelective(Guser record);

    int updateByPrimaryKey(Guser record);

    loginCustom loginInfo(String userId);
}
