package com.social.mapper;

import com.social.pojo.NewThings;
import com.social.pojo.NewThingsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NewThingsMapper {
    int countByExample(NewThingsExample example);

    int deleteByExample(NewThingsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(NewThings record);

    int insertSelective(NewThings record);

    List<NewThings> selectByExample(NewThingsExample example);

    NewThings selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") NewThings record, @Param("example") NewThingsExample example);

    int updateByExample(@Param("record") NewThings record, @Param("example") NewThingsExample example);

    int updateByPrimaryKeySelective(NewThings record);

    int updateByPrimaryKey(NewThings record);
}