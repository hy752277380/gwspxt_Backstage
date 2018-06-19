package com.kcsj.gwglxt.mapper;


import java.util.List;

import com.kcsj.gwglxt.entity.Borrowing;
import com.kcsj.gwglxt.entity.BorrowingExample;
import org.apache.ibatis.annotations.Param;

public interface BorrowingMapper {
    int countByExample(BorrowingExample example);

    int deleteByExample(BorrowingExample example);

    int deleteByPrimaryKey(String borrowingId);

    int insert(Borrowing record);

    int insertSelective(Borrowing record);

    List<Borrowing> selectByExample(BorrowingExample example);

    Borrowing selectByPrimaryKey(String borrowingId);

    int updateByExampleSelective(@Param("record") Borrowing record, @Param("example") BorrowingExample example);

    int updateByExample(@Param("record") Borrowing record, @Param("example") BorrowingExample example);

    int updateByPrimaryKeySelective(Borrowing record);

    int updateByPrimaryKey(Borrowing record);

    Borrowing borrowingState(@Param("borrowingDocument") String documentId,@Param("borrowingBorrowUser") String userId);
}