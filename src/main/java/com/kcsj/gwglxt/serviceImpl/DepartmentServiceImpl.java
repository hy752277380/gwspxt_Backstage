package com.kcsj.gwglxt.serviceImpl;

import com.kcsj.gwglxt.entity.Department;
import com.kcsj.gwglxt.entity.DepartmentExample;
import com.kcsj.gwglxt.service.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Override
    public int countByExample(DepartmentExample example) {
        return 0;
    }

    @Override
    public int deleteByExample(DepartmentExample example) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(String departmentId) {
        return 0;
    }

    @Override
    public int insert(Department record) {
        return 0;
    }

    @Override
    public int insertSelective(Department record) {
        return 0;
    }

    @Override
    public List<Department> selectByExample(DepartmentExample example) {
        return null;
    }

    @Override
    public Department selectByPrimaryKey(String departmentId) {
        return null;
    }

    @Override
    public int updateByExampleSelective(Department record, DepartmentExample example) {
        return 0;
    }

    @Override
    public int updateByExample(Department record, DepartmentExample example) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(Department record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Department record) {
        return 0;
    }
}
