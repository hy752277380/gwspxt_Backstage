package com.kcsj.gwglxt.serviceImpl.documentManage;

import com.kcsj.gwglxt.entity.Document;
import com.kcsj.gwglxt.entity.Log;
import com.kcsj.gwglxt.mapper.DocumentMapper;
import com.kcsj.gwglxt.mapper.LogMapper;
import com.kcsj.gwglxt.service.documentManage.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentServiceImpl implements DocumentService {
    @Autowired
    private DocumentMapper documentMapper;
    @Autowired
    private LogMapper logMapper;

    @Override
    public int insert(Document record) {
        return documentMapper.insert(record);
    }

    @Override
    public int updateDocumentState(Integer documentState, String documentId) {
        return documentMapper.updateDocumentState(documentState,documentId);
    }

    @Override
    public int insertLog(Log log) {
        return logMapper.insert(log);
    }

    @Override
    public String getDocumentName(String documentId) {
        return documentMapper.getDocumentName(documentId);
    }


}
