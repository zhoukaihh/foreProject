package com.qf.shopping.mapper;

import com.qf.shopping.pojo.Advertisment;
import com.qf.shopping.pojo.AdvertismentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdvertismentMapper {
    int countByExample(AdvertismentExample example);

    int deleteByExample(AdvertismentExample example);

    int deleteByPrimaryKey(Integer adId);

    int insert(Advertisment record);

    int insertSelective(Advertisment record);

    List<Advertisment> selectByExample(AdvertismentExample example);

    Advertisment selectByPrimaryKey(Integer adId);

    int updateByExampleSelective(@Param("record") Advertisment record, @Param("example") AdvertismentExample example);

    int updateByExample(@Param("record") Advertisment record, @Param("example") AdvertismentExample example);

    int updateByPrimaryKeySelective(Advertisment record);

    int updateByPrimaryKey(Advertisment record);
}