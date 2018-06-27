package com.kcsj.gwglxt.service.departmentManage;

import com.kcsj.gwglxt.DTO.LoginCustom;
import com.kcsj.gwglxt.DTO.PositionPermission;
import com.kcsj.gwglxt.entity.Department;
import com.kcsj.gwglxt.entity.DepartmentExample;
import com.kcsj.gwglxt.entity.Permission;
import com.kcsj.gwglxt.entity.Position;
import com.kcsj.gwglxt.vo.QueryForPage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepartmentService {
    int countByExample(DepartmentExample example);

    int deleteByExample(DepartmentExample example);

    int deleteByPrimaryKey(String departmentId);

    int insert(Department record, LoginCustom loginCustom);

    int insertSelective(Department record);

    List<Department> selectByExample(DepartmentExample example);

    Department selectByPrimaryKey(String departmentId);

    int updateByExampleSelective(@Param("record") Department record, @Param("example") DepartmentExample example);

    int updateByExample(@Param("record") Department record, @Param("example") DepartmentExample example);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

    QueryForPage getAllDepartment(int currentPage,String fuzzySearch);

    List<PositionPermission> getPoPeByDpt(String department);

    List<Permission> getAllPermission();

    int insertPosition(Position position,LoginCustom loginCustom);

    int updatePermission(Position position,LoginCustom loginCustom);

    int updateDptInfo(Department department,LoginCustom loginCustom);

    List<Department> getAllDepartmentNoPage();

    boolean getPosotionName(String positionName);

    boolean getDptByName(String departmentName);
}
