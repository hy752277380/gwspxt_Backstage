package com.kcsj.gwglxt.mapper;


import java.util.List;

import com.kcsj.gwglxt.entity.Guser;
import com.kcsj.gwglxt.entity.GuserExample;
import com.kcsj.gwglxt.DTO.LoginCustom;
import org.apache.ibatis.annotations.Param;

public interface GuserMapper {
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

    LoginCustom loginInfo(String userId);
    LoginCustom loginFunction(String userAccount);
    //根据职位查询人员
    Guser getUserByPosition(@Param("userPosition") String userPosition,@Param("userDepartment") String userDepartment);
}