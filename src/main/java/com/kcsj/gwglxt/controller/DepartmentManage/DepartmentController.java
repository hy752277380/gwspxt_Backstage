package com.kcsj.gwglxt.controller.DepartmentManage;

import com.kcsj.gwglxt.DTO.LoginCustom;
import com.kcsj.gwglxt.DTO.PositionPermission;
import com.kcsj.gwglxt.entity.Department;
import com.kcsj.gwglxt.entity.Permission;
import com.kcsj.gwglxt.entity.Position;
import com.kcsj.gwglxt.service.departmentManage.DepartmentService;
import com.kcsj.gwglxt.vo.QueryForPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    /****************************************8部门管理**************************/
    //添加部门
    @RequestMapping("/addDepartment")
    public String addDepartment(@RequestBody Department department,HttpSession httpSession){
        LoginCustom loginCustom = (LoginCustom) httpSession.getAttribute("LoginInformation");
        String result;
        int addResult = departmentService.insert(department,loginCustom);
        //判断执行文档添加操作返回的结果，返回结果为数据库中受影响行数
        if (addResult == 0) {
            result = "addFailed";
        }else{
            result = "addSuccess";
        }
        return "{\"msg\":\"" + result + "\"}";
    }
    //获得所有部门
    @RequestMapping("/getAllDepartment/{currentPage}")
    public QueryForPage getAllDepartment(@PathVariable("currentPage") int currentPage, String searchInfo){
        QueryForPage queryForPage = departmentService.getAllDepartment(currentPage,searchInfo);
        return queryForPage;
    }
    //获得所有部门（不分页）
    @RequestMapping("/getAllDepartmentNoPage")
    public List<Department> getAllDepartmentNoPage(){
        List<Department> departments = departmentService.getAllDepartmentNoPage();
        return departments;
    }
    //按部门查询职位权限
    @RequestMapping("/getPoPeByDpt")
    public List<PositionPermission> getPoPeByDpt(String department){
        List<PositionPermission> positionPermissions = departmentService.getPoPeByDpt(department);
        return positionPermissions;
    }
    //查询所有权限
    @RequestMapping("/getAllPermission")
    public List<Permission> getAllPermission(){
        List<Permission> permissions = departmentService.getAllPermission();
        return permissions;
    }
    //添加职位
    @RequestMapping("/addPosition")
    public String addPosition(@RequestBody Position position,HttpSession httpSession){
        LoginCustom loginCustom = (LoginCustom) httpSession.getAttribute("LoginInformation");
        String result;
        int addResult = departmentService.insertPosition(position,loginCustom);
        //判断执行文档添加操作返回的结果，返回结果为数据库中受影响行数
        if (addResult == 0) {
            result = "addFailed";
        }else{
            result = "addSuccess";
        }
        return "{\"msg\":\"" + result + "\"}";
    }
    //修改职位权限
    @RequestMapping("/updatePermission")
    public String updatePermission(@RequestBody Position position,HttpSession httpSession){
        LoginCustom loginCustom = (LoginCustom) httpSession.getAttribute("LoginInformation");
        String result;
        int updateResult = departmentService.updatePermission(position,loginCustom);
        //判断执行文档添加操作返回的结果，返回结果为数据库中受影响行数
        if (updateResult == 0) {
            result = "addFailed";
        }else{
            result = "addSuccess";
        }
        return "{\"msg\":\"" + result + "\"}";
    }
    //修改部门信息
    @RequestMapping("/updateDptInfo")
    public String updateDptInfo(@RequestBody Department department,HttpSession httpSession){
        LoginCustom loginCustom = (LoginCustom) httpSession.getAttribute("LoginInformation");
        String result;
        int updateResult = departmentService.updateDptInfo(department,loginCustom);
        //判断执行文档添加操作返回的结果，返回结果为数据库中受影响行数
        if (updateResult == 0) {
            result = "addFailed";
        }else{
            result = "addSuccess";
        }
        return "{\"msg\":\"" + result + "\"}";
    }
}
