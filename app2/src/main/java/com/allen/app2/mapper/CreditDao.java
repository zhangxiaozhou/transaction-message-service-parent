package com.allen.app2.mapper;

import com.allen.app2.domain.Credit;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CreditDao {
    int deleteByPrimaryKey(Long id);

    int insert(Credit record);

    int insertSelective(Credit record);

    Credit selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Credit record);

    int updateByPrimaryKey(Credit record);

    List<Credit> query(Credit credit);

}