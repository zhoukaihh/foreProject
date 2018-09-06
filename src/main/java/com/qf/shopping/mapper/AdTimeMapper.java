package com.qf.shopping.mapper;

import com.qf.shopping.pojo.AdTime;
import com.qf.shopping.pojo.AdTimeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdTimeMapper {
    int countByExample(AdTimeExample example);

    int deleteByExample(AdTimeExample example);

    int deleteByPrimaryKey(Integer adId);

    int insert(AdTime record);

    int insertSelective(AdTime record);

    List<AdTime> selectByExample(AdTimeExample example);

    AdTime selectByPrimaryKey(Integer adId);

    int updateByExampleSelective(@Param("record") AdTime record, @Param("example") AdTimeExample example);

    int updateByExample(@Param("record") AdTime record, @Param("example") AdTimeExample example);

    int updateByPrimaryKeySelective(AdTime record);

    int updateByPrimaryKey(AdTime record);
}