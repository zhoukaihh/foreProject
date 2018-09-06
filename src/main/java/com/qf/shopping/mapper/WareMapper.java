package com.qf.shopping.mapper;

import com.qf.shopping.pojo.Ware;
import com.qf.shopping.pojo.WareExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WareMapper {
    int countByExample(WareExample example);

    int deleteByExample(WareExample example);

    int deleteByPrimaryKey(Integer goodId);

    int insert(Ware record);

    int insertSelective(Ware record);

    List<Ware> selectByExample(WareExample example);

    Ware selectByPrimaryKey(Integer goodId);

    int updateByExampleSelective(@Param("record") Ware record, @Param("example") WareExample example);

    int updateByExample(@Param("record") Ware record, @Param("example") WareExample example);

    int updateByPrimaryKeySelective(Ware record);

    int updateByPrimaryKey(Ware record);
}