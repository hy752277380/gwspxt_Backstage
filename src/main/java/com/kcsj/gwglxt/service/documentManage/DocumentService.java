package com.kcsj.gwglxt.service.documentManage;

import com.kcsj.gwglxt.entity.Document;
import com.kcsj.gwglxt.entity.Log;
import com.kcsj.gwglxt.entity.ProcessNode;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DocumentService {

    int insert(Document record);
    //根据id更改文档状态
    int updateDocumentState(@Param("documentState") Integer documentState, @Param("documentId") String documentId);
    //添加日志
    int insertLog(Log log);
    //根据文档id获取文档名称
    String getDocumentName(String documentId);
    //根据文档id该文档全部信息
    Document selectByPrimaryKey(String documentId);
    //根据id修改流程子节点位置
    int updateDocumentLocation(@Param("documentLocation")Integer documentLocation,@Param("documentId")String documentId);
    //根据id查询该文档当前流程子节点位置
    int getDocumentLocation(String documentId);
    //更新用户信息
    int updateByPrimaryKey(Document record);
    //根据id获取当前流程最后一步
    int getMaxStep(String processNodeProcess);
    //生成信息
    int insertMessage(Document doc);

    List<Document> getDocumentByState(Integer documentState);

    //查询该文档所走流程的每一个流程节点
    List<ProcessNode> getAllProcessNode(String processNodeProcess);
}
