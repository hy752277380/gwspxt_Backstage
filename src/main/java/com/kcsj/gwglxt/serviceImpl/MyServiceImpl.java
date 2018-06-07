package com.kcsj.gwglxt.serviceImpl;

import com.kcsj.gwglxt.entity.manage;
import com.kcsj.gwglxt.mapper.MyMapper;
import com.kcsj.gwglxt.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyServiceImpl implements MyService {

    @Autowired
    private MyMapper MyMapper;

    @Override
    public List<manage> myTest(){
        return MyMapper.getAll();
    }
}
