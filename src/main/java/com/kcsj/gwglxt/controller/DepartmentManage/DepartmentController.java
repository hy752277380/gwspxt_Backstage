package com.kcsj.gwglxt.controller.DepartmentManage;

import com.kcsj.gwglxt.entity.Department;
import com.kcsj.gwglxt.service.departmentManage.DepartmentService;
import com.kcsj.gwglxt.vo.QueryForPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
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
    public QueryForPage getAllDepartment(@PathVariable("currentPage") int currentPage, @PathVariable("searchInfo") String searchInfo){
        QueryForPage queryForPage = departmentService.getAllDepartment(currentPage,searchInfo);
        return queryForPage;
    }
}
