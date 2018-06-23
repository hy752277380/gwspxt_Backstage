package com.kcsj.gwglxt.service;

import com.kcsj.gwglxt.DTO.CountByMouth;
import com.kcsj.gwglxt.entity.Guser;
import com.kcsj.gwglxt.entity.GuserExample;
import com.kcsj.gwglxt.DTO.LoginCustom;
import com.kcsj.gwglxt.entity.Log;
import com.kcsj.gwglxt.entity.Position;
import com.kcsj.gwglxt.vo.QueryForPage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GuserService {
    int countByExample(GuserExample example);

    int deleteByExample(GuserExample example);

    int deleteByPrimaryKey(String userId);

    int insertUser(Guser record,LoginCustom loginCustom);

    int insertSelective(Guser record);

    List<Guser> selectByExample(GuserExample example);

    Guser selectByPrimaryKey(String userId);

    int updateByExampleSelective(@Param("record") Guser record, @Param("example") GuserExample example);

    int updateByExample(@Param("record") Guser record, @Param("example") GuserExample example);

    int updateByPrimaryKeySelective(Guser record,LoginCustom loginCustom);

    int updateByPrimaryKey(Guser record,LoginCustom loginCustom);

    LoginCustom loginInfo(String userId);
    LoginCustom loginFunction(String userAccount);
    //查询个人信息
    LoginCustom getPersonalInfo(String userId);

    CountByMouth countUserByMouth();

    int countAllUser();

    int countAllDocument(String department,String user);

    CountByMouth countDocumentByMouth();

    CountByMouth countDptDocumentByMouth(String department);

    CountByMouth countPersonalDocumentByMouth(String userId);

    QueryForPage getAllUser(int currentPage);

    List<Position> getPositionByDpt(String department);

    int resetPassword(String userId,LoginCustom loginCustom);

    int batchDelete(String[] userIds,LoginCustom loginCustom);

    QueryForPage getUserByDpt(String userDepartment,int currentPage);

    LoginCustom getUserById(String userId);
}
