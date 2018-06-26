package com.kcsj.gwglxt.mapper;

import com.kcsj.gwglxt.DTO.CountByMouth;
import com.kcsj.gwglxt.DTO.LoginCustom;
import com.kcsj.gwglxt.entity.Borrowing;
import com.kcsj.gwglxt.entity.Document;
import com.kcsj.gwglxt.DTO.DocumentCustom;
import com.kcsj.gwglxt.entity.DocumentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DocumentMapper {
    int countByExample(DocumentExample example);

    int deleteByExample(DocumentExample example);

    int deleteByPrimaryKey(String documentId);

    int insert(Document record);

    int insertSelective(Document record);

    List<Document> selectByExample(DocumentExample example);

    Document selectByPrimaryKey(String documentId);

    int updateByExampleSelective(@Param("record") Document record, @Param("example") DocumentExample example);

    int updateByExample(@Param("record") Document record, @Param("example") DocumentExample example);

    int updateByPrimaryKeySelective(Document record);

    int updateByPrimaryKey(Document record);
    //根据id更改文档状态
    int updateDocumentState(@Param("documentState") Integer documentState,@Param("documentProcessBegin")String documentProcessBegin,@Param("documentProcessFinish")String documentProcessFinish,@Param("documentId") String documentId);
    //根据id查询文档名称
    String getDocumentName(String documentId);
    //根据id修改流程子节点位置
    int updateDocumentLocation(@Param("documentLocation")Integer documentLocation,@Param("documentId")String documentId);
    //根据id查询该文档当前流程子节点位置
    int getDocumentLocation(String documentId);

    List<DocumentCustom> getDocumentByState(@Param("documentType") String documentType,@Param("documentConfidential") Integer documentConfidential,@Param("documentState") Integer documentState,@Param("documentUser") String documentUser,@Param("documentNo") String documentNo,@Param("documentTitle")String documentTitle);
    //查询所有文档
    List<DocumentCustom> getAllDocument(@Param("documentType")String documentType,@Param("documentConfidential")Integer documentConfidential,@Param("documentDept")String documentDept,@Param("documentNo") String documentNo,@Param("documentTitle")String documentTitle,@Param("userName")String userName);
    //联合查询文档信息
    DocumentCustom documentBaseInfo(String documentId);

    List<DocumentCustom> findCheckingDoc(@Param("documentType")String documentType,@Param("documentConfidential")Integer documentConfidential,@Param("documentProcess") String documentProcess,@Param("documentLocation") Integer documentLocation,@Param("documentNo") String documentNo,@Param("documentTitle")String documentTitle,@Param("userName")String userName);

    List<DocumentCustom> getDocumentByDpt(@Param("documentType")String documentType,@Param("documentConfidential")Integer documentConfidential,@Param("documentDept") String documentDept);

    int countAllDocument(@Param("documentDept") String department,@Param("documentUser") String user);

    CountByMouth countDocumentByMouth(@Param("year") String year,@Param("department") String department,@Param("userId") String userId);

}