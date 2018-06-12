package com.kcsj.gwglxt.mapper;

import com.kcsj.gwglxt.entity.Document;
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
    int updateDocumentState(@Param("documentState") Integer documentState,@Param("documentId") String documentId);

    String getDocumentName(String documentId);
}