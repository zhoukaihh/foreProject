package com.qf.shopping.mapper;

import com.qf.shopping.pojo.SecondType;
import com.qf.shopping.pojo.SecondTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SecondTypeMapper {
    int countByExample(SecondTypeExample example);

    int deleteByExample(SecondTypeExample example);

    int deleteByPrimaryKey(Integer secondTypeId);

    int insert(SecondType record);

    int insertSelective(SecondType record);

    List<SecondType> selectByExample(SecondTypeExample example);

    SecondType selectByPrimaryKey(Integer secondTypeId);

    int updateByExampleSelective(@Param("record") SecondType record, @Param("example") SecondTypeExample example);

    int updateByExample(@Param("record") SecondType record, @Param("example") SecondTypeExample example);

    int updateByPrimaryKeySelective(SecondType record);

    int updateByPrimaryKey(SecondType record);
}