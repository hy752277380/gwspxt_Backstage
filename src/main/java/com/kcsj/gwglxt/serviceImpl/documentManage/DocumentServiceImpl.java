package com.kcsj.gwglxt.serviceImpl.documentManage;

import com.kcsj.gwglxt.entity.Document;
import com.kcsj.gwglxt.mapper.DocumentMapper;
import com.kcsj.gwglxt.service.documentManage.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentServiceImpl implements DocumentService {
    @Autowired
    private DocumentMapper documentMapper;
    @Override
    public int insert(Document record) {
        return documentMapper.insert(record);
    }
}
