package com.qf.shopping.mapper;

import com.qf.shopping.pojo.FirstType;
import com.qf.shopping.pojo.FirstTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FirstTypeMapper {
    int countByExample(FirstTypeExample example);

    int deleteByExample(FirstTypeExample example);

    int deleteByPrimaryKey(Integer firstTypeId);

    int insert(FirstType record);

    int insertSelective(FirstType record);

    List<FirstType> selectByExample(FirstTypeExample example);

    FirstType selectByPrimaryKey(Integer firstTypeId);

    int updateByExampleSelective(@Param("record") FirstType record, @Param("example") FirstTypeExample example);

    int updateByExample(@Param("record") FirstType record, @Param("example") FirstTypeExample example);

    int updateByPrimaryKeySelective(FirstType record);

    int updateByPrimaryKey(FirstType record);
}