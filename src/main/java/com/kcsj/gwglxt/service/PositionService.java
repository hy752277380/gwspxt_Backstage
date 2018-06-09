package com.kcsj.gwglxt.service;

import com.kcsj.gwglxt.entity.Position;
import com.kcsj.gwglxt.entity.PositionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PositionService {
    int countByExample(PositionExample example);

    int deleteByExample(PositionExample example);

    int deleteByPrimaryKey(String positionId);

    int insert(Position record);

    int insertSelective(Position record);

    List<Position> selectByExample(PositionExample example);

    Position selectByPrimaryKey(String positionId);

    int updateByExampleSelective(@Param("record") Position record, @Param("example") PositionExample example);

    int updateByExample(@Param("record") Position record, @Param("example") PositionExample example);

    int updateByPrimaryKeySelective(Position record);

    int updateByPrimaryKey(Position record);
}
