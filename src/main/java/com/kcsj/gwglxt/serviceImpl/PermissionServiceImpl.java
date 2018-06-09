package com.kcsj.gwglxt.serviceImpl;

import com.kcsj.gwglxt.entity.Permission;
import com.kcsj.gwglxt.entity.PermissionExample;
import com.kcsj.gwglxt.service.PermissionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Override
    public int countByExample(PermissionExample example) {
        return 0;
    }

    @Override
    public int deleteByExample(PermissionExample example) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(String permissionId) {
        return 0;
    }

    @Override
    public int insert(Permission record) {
        return 0;
    }

    @Override
    public int insertSelective(Permission record) {
        return 0;
    }

    @Override
    public List<Permission> selectByExample(PermissionExample example) {
        return null;
    }

    @Override
    public Permission selectByPrimaryKey(String permissionId) {
        return null;
    }

    @Override
    public int updateByExampleSelective(Permission record, PermissionExample example) {
        return 0;
    }

    @Override
    public int updateByExample(Permission record, PermissionExample example) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(Permission record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Permission record) {
        return 0;
    }
}
