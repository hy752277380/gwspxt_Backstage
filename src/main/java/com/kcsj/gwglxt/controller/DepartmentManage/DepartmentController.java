package com.kcsj.gwglxt.controller.DepartmentManage;

import com.kcsj.gwglxt.entity.Department;
import com.kcsj.gwglxt.service.departmentManage.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    //获得所有部门
    @RequestMapping("/getAllDepartment")
    public List<Department> getAllDepartment(){
        List<Department> list = departmentService.getAllDepartment();
        return list;
    }
}
