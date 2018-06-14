package com.kcsj.gwglxt.mapper;

import com.kcsj.gwglxt.entity.Mobject;
import com.kcsj.gwglxt.entity.MobjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MobjectMapper {
    int countByExample(MobjectExample example);

    int deleteByExample(MobjectExample example);

    int deleteByPrimaryKey(String mobjectId);

    int insert(Mobject record);

    int insertSelective(Mobject record);

    List<Mobject> selectByExample(MobjectExample example);

    Mobject selectByPrimaryKey(String mobjectId);

    int updateByExampleSelective(@Param("record") Mobject record, @Param("example") MobjectExample example);

    int updateByExample(@Param("record") Mobject record, @Param("example") MobjectExample example);

    int updateByPrimaryKeySelective(Mobject record);

    int updateByPrimaryKey(Mobject record);

    int insertMbj(Mobject mobject);
}