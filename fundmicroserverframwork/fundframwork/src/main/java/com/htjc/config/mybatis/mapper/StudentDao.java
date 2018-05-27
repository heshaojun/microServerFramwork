package com.htjc.config.mybatis.mapper;

import com.htjc.config.mybatis.entity.StudentEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
//@Repository
public interface StudentDao {
    @Insert("insert into students(id_no,name,sex,age,guarder_id) values(#{idNo},#{name},#{sex},#{age},#{guarderId})")
    public void insert( StudentEntity studentEntity);
}
