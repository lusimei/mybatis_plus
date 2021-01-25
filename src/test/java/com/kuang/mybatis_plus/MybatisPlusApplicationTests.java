package com.kuang.mybatis_plus;

import com.kuang.mapper.UserMapper;
import com.kuang.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MybatisPlusApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    @Test
    void testAdd(){
        User user = new User();
        user.setAge(12);
        user.setEmail("AAA@163.com");
        user.setName("BBB");
        int insert = userMapper.insert(user);
        System.out.println(insert);
        System.out.println(user);
    }

    @Test
    void testUpdate(){
        User user = new User();
        user.setId(1353586686646546443l);
        user.setEmail("CCC@163.com");
        user.setName("TIDY");
        int insert = userMapper.updateById(user);
        System.out.println(insert);
        System.out.println(user);
    }

}
