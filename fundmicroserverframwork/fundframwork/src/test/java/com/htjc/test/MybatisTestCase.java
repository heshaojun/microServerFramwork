package com.htjc.test;

import com.htjc.config.mybatis.entity.StudentEntity;
import com.htjc.config.mybatis.mapper.StudentDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class MybatisTestCase {
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private DataSource dataSource;
    @Test
    public void test(){
        StudentEntity entity = new StudentEntity();
        entity.setIdNo("1232er4");
        entity.setName("hehe");
        entity.setAge((float)100);
        entity.setGuarderId("234334");
        studentDao.insert(entity);
/*        try {
           Connection connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    }

    //@Test
    public void test1(){

    }
}
