package com.management;

import com.management.common.utils.JwtUtil;
import com.management.sys.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author: Xiaoyang Yu
 * @create_at: 2023/4/26 18:51
 * @version: 1.0
 */
@SpringBootTest
public class JwtUtilTest {

    @Autowired
    private JwtUtil jwtUtil;

    @Test
    public void testCreatJwt(){
        User user = new User();
        user.setUsername("zhangsan");
        user.setPhone("12345678910");
        String token = jwtUtil.createToken(user);
        System.out.println(token);
    }
}
