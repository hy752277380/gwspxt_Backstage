package com.kcsj.gwglxt.mapper;

import com.kcsj.gwglxt.DTO.PositionPermission;
import com.kcsj.gwglxt.entity.Position;
import com.kcsj.gwglxt.entity.PositionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PositionMapper {
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

    List<Position> getDptManager(String documentDept);

    List<Position> getPositionByDpt(String department);

    List<PositionPermission> getPoPeByDpt(String department);
}