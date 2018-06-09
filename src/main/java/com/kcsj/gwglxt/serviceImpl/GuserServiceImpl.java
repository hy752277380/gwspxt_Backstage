package com.kcsj.gwglxt.serviceImpl;

import com.kcsj.gwglxt.entity.Guser;
import com.kcsj.gwglxt.entity.GuserExample;
import com.kcsj.gwglxt.entity.loginCustom;
import com.kcsj.gwglxt.mapper.GuserMapper;
import com.kcsj.gwglxt.service.GuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuserServiceImpl implements GuserService {

    @Autowired
    private GuserMapper guserMapper;
    @Override
    public int countByExample(GuserExample example) {
        return 0;
    }

    @Override
    public int deleteByExample(GuserExample example) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(String userId) {
        return 0;
    }

    @Override
    public int insert(Guser record) {
        return 0;
    }

    @Override
    public int insertSelective(Guser record) {
        return 0;
    }

    @Override
    public List<Guser> selectByExample(GuserExample example) {
        return null;
    }

    @Override
    public Guser selectByPrimaryKey(String userId) {
        return guserMapper.selectByPrimaryKey(userId);
    }

    @Override
    public int updateByExampleSelective(Guser record, GuserExample example) {
        return 0;
    }

    @Override
    public int updateByExample(Guser record, GuserExample example) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(Guser record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Guser record) {
        return 0;
    }

    @Override
    public loginCustom loginInfo(String userId) {
        return guserMapper.loginInfo(userId);
    }
}
