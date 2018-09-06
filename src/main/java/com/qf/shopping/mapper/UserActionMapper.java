package com.qf.shopping.mapper;

import com.qf.shopping.pojo.UserAction;
import com.qf.shopping.pojo.UserActionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserActionMapper {
    int countByExample(UserActionExample example);

    int deleteByExample(UserActionExample example);

    int deleteByPrimaryKey(Integer behaviorId);

    int insert(UserAction record);

    int insertSelective(UserAction record);

    List<UserAction> selectByExample(UserActionExample example);

    UserAction selectByPrimaryKey(Integer behaviorId);

    int updateByExampleSelective(@Param("record") UserAction record, @Param("example") UserActionExample example);

    int updateByExample(@Param("record") UserAction record, @Param("example") UserActionExample example);

    int updateByPrimaryKeySelective(UserAction record);

    int updateByPrimaryKey(UserAction record);
}