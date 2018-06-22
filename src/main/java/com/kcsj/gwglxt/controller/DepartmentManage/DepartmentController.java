package com.kcsj.gwglxt.controller.DepartmentManage;

import com.kcsj.gwglxt.DTO.PositionPermission;
import com.kcsj.gwglxt.entity.Department;
import com.kcsj.gwglxt.entity.Position;
import com.kcsj.gwglxt.service.departmentManage.DepartmentService;
import com.kcsj.gwglxt.vo.QueryForPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    /****************************************8部门管理**************************/
    //添加部门
    @RequestMapping("/addDepartment")
    public String addDepartment(@RequestBody Department department){
        String result;
        int addResult = departmentService.insert(department);
        //判断执行文档添加操作返回的结果，返回结果为数据库中受影响行数
        if (addResult == 0) {
            result = "addFailed";
        }else{
            result = "addSuccess";
        }
        return result;
    }
    //获得所有部门
    @RequestMapping("/getAllDepartment")
    public QueryForPage getAllDepartment(int currentPage, String searchInfo){
        QueryForPage queryForPage = departmentService.getAllDepartment(currentPage,searchInfo);
        return queryForPage;
    }
    //添加职位
    //按部门查询职位权限
    @RequestMapping("/getPoPeByDpr")
    public void getPoPeByDpr(String department){
        List<PositionPermission> positionPermissions = departmentService.getPoPeByDpr(department);
    }
}
