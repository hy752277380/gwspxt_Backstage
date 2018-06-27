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
        String result;
        if(departmentService.getDptByName(department.getDepartmentName())){
            int addResult = 0;
            try {
                LoginCustom loginCustom = (LoginCustom) httpSession.getAttribute("LoginInformation");
                addResult = departmentService.insert(department,loginCustom);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //判断执行文档添加操作返回的结果，返回结果为数据库中受影响行数
            if (addResult == 0) {
                result = "addFailed";
            }else{
                result = "addSuccess";
            }
            return "{\"msg\":\"" + result + "\"}";
        }else {
            result = "departmenntExist";
            return "{\"msg\":\"" + result + "\"}";
        }

    }
    //获得所有部门
    @RequestMapping("/getAllDepartment")
    public QueryForPage getAllDepartment(int currentPage, String fuzzySearch){
        QueryForPage queryForPage = null;
        try {
            queryForPage = departmentService.getAllDepartment(currentPage,fuzzySearch);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return queryForPage;
    }
    //获得所有部门（不分页）
    @RequestMapping("/getAllDepartmentNoPage")
    public List<Department> getAllDepartmentNoPage(){
        List<Department> departments = null;
        try {
            departments = departmentService.getAllDepartmentNoPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return departments;
    }
    //按部门查询职位权限
    @RequestMapping("/getPoPeByDpt")
    public List<PositionPermission> getPoPeByDpt(String department){
        List<PositionPermission> positionPermissions = null;
        try {
            positionPermissions = departmentService.getPoPeByDpt(department);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return positionPermissions;
    }
    //查询所有权限
    @RequestMapping("/getAllPermission")
    public List<Permission> getAllPermission(){
        List<Permission> permissions = null;
        try {
            permissions = departmentService.getAllPermission();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return permissions;
    }
    //添加职位
    @RequestMapping("/addPosition")
    public String addPosition(@RequestBody Position position,HttpSession httpSession){
        String result;
        if(departmentService.getPosotionName(position.getPositionName())){
            int addResult = 0;
            try {
                LoginCustom loginCustom = (LoginCustom) httpSession.getAttribute("LoginInformation");
                addResult = departmentService.insertPosition(position,loginCustom);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //判断执行文档添加操作返回的结果，返回结果为数据库中受影响行数
            if (addResult == 0) {
                result = "addFailed";
            }else{
                result = "addSuccess";
            }
            return "{\"msg\":\"" + result + "\"}";
        }else {
            result = "positionExist";
            return "{\"msg\":\"" + result + "\"}";
        }

    }
    //修改职位权限
    @RequestMapping("/updatePermission")
    public String updatePermission(@RequestBody Position position,HttpSession httpSession){
        String result;
        int updateResult = 0;
        try {
            LoginCustom loginCustom = (LoginCustom) httpSession.getAttribute("LoginInformation");
            updateResult = departmentService.updatePermission(position,loginCustom);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        String result;
        int updateResult = 0;
        try {
            LoginCustom loginCustom = (LoginCustom) httpSession.getAttribute("LoginInformation");
            updateResult = departmentService.updateDptInfo(department,loginCustom);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //判断执行文档添加操作返回的结果，返回结果为数据库中受影响行数
        if (updateResult == 0) {
            result = "addFailed";
        }else{
            result = "addSuccess";
        }
        return "{\"msg\":\"" + result + "\"}";
    }
}
