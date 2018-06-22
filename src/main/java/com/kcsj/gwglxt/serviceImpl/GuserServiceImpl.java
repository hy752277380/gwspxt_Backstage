package com.kcsj.gwglxt.serviceImpl;

import com.kcsj.gwglxt.DTO.CountByMouth;
import com.kcsj.gwglxt.entity.Guser;
import com.kcsj.gwglxt.entity.GuserExample;
import com.kcsj.gwglxt.DTO.LoginCustom;
import com.kcsj.gwglxt.mapper.DocumentMapper;
import com.kcsj.gwglxt.mapper.GuserMapper;
import com.kcsj.gwglxt.service.GuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class GuserServiceImpl implements GuserService {

    @Autowired
    private GuserMapper guserMapper;
    @Autowired
    private DocumentMapper documentMapper;
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
    public LoginCustom loginInfo(String userId) {
        return guserMapper.loginInfo(userId);
    }

    @Override
    public LoginCustom loginFunction(String userAccount) {

        LoginCustom ll = guserMapper.loginFunction(userAccount);
        System.out.println(userAccount);
        System.out.println(ll);
        return ll;
}

    @Override
    public LoginCustom getPersonalInfo(String userId) {
        return guserMapper.getPersonalInfo(userId);
    }
    //首页月份人数统计
    @Override
    public CountByMouth countUserByMouth() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy");//设置日期格式
        System.out.println(guserMapper.countUserByMouth(df.format(new Date())));
        return guserMapper.countUserByMouth(df.format(new Date()));
    }
    //计算总人数
    @Override
    public int countAllUser() {
        return guserMapper.countAllUser();
    }
    //计算总文档数
    @Override
    public int countAllDocument(String department,String user) {
        return documentMapper.countAllDocument(department,user);
    }

    @Override
    public CountByMouth countDocumentByMouth() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy");//设置日期格式
        System.out.println(guserMapper.countUserByMouth(df.format(new Date())));
        return documentMapper.countDocumentByMouth(df.format(new Date()));
    }
}
