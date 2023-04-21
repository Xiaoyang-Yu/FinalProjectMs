package com.management;

import com.management.sys.entity.User;
import com.management.sys.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class MsApplicationTests {

    @Resource
    private UserMapper userMapper;

    @Test
    void testMapper() {
        List<User> user = userMapper.selectList(null);
        user.forEach(System.out::println);
    }

}
