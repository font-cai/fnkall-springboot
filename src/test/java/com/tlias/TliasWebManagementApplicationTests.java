package com.tlias;

import com.tlias.controller.DeptController;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class TliasWebManagementApplicationTests {
    @Test
    void contextLoads() {

    }
    @Test
    void getJJWD(){
        Map<String, Object> map = new HashMap<>();
        map.put("name","张三");
        map.put("id", 1);
        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256,"sdfsdffsdf")
                .addClaims(map)
                .setExpiration(new Date(System.currentTimeMillis() + 12*3600*1000))
                .compact();
        System.out.println(jwt);
    }

}
