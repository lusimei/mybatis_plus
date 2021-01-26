package com.kuang.mybatis_plus;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kuang.mapper.UserMapper;
import com.kuang.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        userMapper.insert(user);
        System.out.println(user);
    }

    @Test
    void testUpdate(){
        User user = new User();
        user.setId(1353586686646546443l);
        user.setEmail("CCC@163.com");
        user.setName("TIDY");
        userMapper.updateById(user);
        System.out.println(user);
    }

    @Test
    void testOptimisticLocker(){
        User user = userMapper.selectById(1l);
        user.setEmail("777@163.com");
        user.setName("name");

        //模拟另外一个线执行了插队操作
        User user1 = userMapper.selectById(1l);
        user1.setEmail("888@163.com");
        user1.setName("name");
        user1.setVersion(10);

        userMapper.updateById(user);

        //自旋锁来多次尝试提交
        userMapper.updateById(user1);//如果没有乐观锁就会覆盖插队线程的值

    }

    @Test
    public void testSelectById(){
        User user = userMapper.selectById(1l);
        System.out.println(user);
    }

    @Test
    public void testBatchSelect(){
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        users.forEach(System.out::println);
    }

    @Test
    public void testSelectByMap(){
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("name","Jack");
        hashMap.put("age",20);
        List<User> users = userMapper.selectByMap(hashMap);
        users.forEach(System.out::println);
    }

    @Test
    public void testPage(){
        IPage<User> userIPage = userMapper.selectPage(new Page(2,5),null);
        userIPage.getRecords().forEach(System.out::println);
        System.out.println(userIPage.getTotal());
    }
}
