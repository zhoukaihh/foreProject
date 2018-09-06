package com.qf.shopping.mapper;

import com.qf.shopping.pojo.UserAddressExample;
import com.qf.shopping.pojo.UserAddressKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserAddressMapper {
    int countByExample(UserAddressExample example);

    int deleteByExample(UserAddressExample example);

    int deleteByPrimaryKey(UserAddressKey key);

    int insert(UserAddressKey record);

    int insertSelective(UserAddressKey record);

    List<UserAddressKey> selectByExample(UserAddressExample example);

    int updateByExampleSelective(@Param("record") UserAddressKey record, @Param("example") UserAddressExample example);

    int updateByExample(@Param("record") UserAddressKey record, @Param("example") UserAddressExample example);
}