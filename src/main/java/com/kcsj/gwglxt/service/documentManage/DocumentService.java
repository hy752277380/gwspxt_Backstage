package com.kcsj.gwglxt.service.documentManage;

import com.kcsj.gwglxt.entity.Document;
import com.kcsj.gwglxt.entity.Log;
import org.apache.ibatis.annotations.Param;

public interface DocumentService {

    int insert(Document record);
    //根据id更改文档状态
    int updateDocumentState(@Param("documentState") Integer documentState, @Param("documentId") String documentId);
    //添加日志
    int insertLog(Log log);
    //根据文档id获取文档名称
    String getDocumentName(String documentId);
}
