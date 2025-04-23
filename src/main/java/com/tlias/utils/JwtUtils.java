package com.tlias.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtils {
    private final static String KEY = "fnkall";
    public String getJwt(){
        Map<String, Object> map = new HashMap<>();
        map.put("name","张三");
        map.put("id", 1);
        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256,KEY)
                .addClaims(map)
                .setExpiration(new Date(System.currentTimeMillis() + 12*3600*1000))
                .compact();
        System.out.println(jwt);
        return jwt;
    }
    // 解析jwt
    public void parseJwt(String jwt){
        Map<String, Object> map = Jwts.parser()
                .setSigningKey(KEY)
                .parseClaimsJws(jwt)
                .getBody();
        System.out.println(map);
    }
}
