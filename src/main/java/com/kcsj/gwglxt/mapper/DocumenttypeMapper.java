package com.kcsj.gwglxt.mapper;

import com.kcsj.gwglxt.entity.Documenttype;
import com.kcsj.gwglxt.entity.DocumenttypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DocumenttypeMapper {
    int countByExample(DocumenttypeExample example);

    int deleteByExample(DocumenttypeExample example);

    int deleteByPrimaryKey(String documenttypeId);

    int insert(Documenttype record);

    int insertSelective(Documenttype record);

    List<Documenttype> selectByExample(DocumenttypeExample example);

    Documenttype selectByPrimaryKey(String documenttypeId);

    int updateByExampleSelective(@Param("record") Documenttype record, @Param("example") DocumenttypeExample example);

    int updateByExample(@Param("record") Documenttype record, @Param("example") DocumenttypeExample example);

    int updateByPrimaryKeySelective(Documenttype record);

    int updateByPrimaryKey(Documenttype record);

    List<Documenttype> getAllDocType();
}