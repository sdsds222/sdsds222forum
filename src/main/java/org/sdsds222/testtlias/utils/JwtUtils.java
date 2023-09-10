package org.sdsds222.testtlias.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

public class JwtUtils {
    /*
     * 生成Jwt令牌
     * */
    public static String createJwt(String name, Map<String, Object> claims) {
        String jwt = Jwts.builder().
                signWith(SignatureAlgorithm.HS256, name)//签名算法
                .setClaims(claims)//设置自定义内容
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000))//设置有效期，超出期限令牌失效（此处为当前时间开始一小时）
                .compact();//生成Jwt令牌
        return jwt;
    }

    /*
     * 解析Jwt令牌
     * */
    public static Claims parseJwt(String jwt,String name) {
        Claims claims = Jwts.parser()
                .setSigningKey(name)//设置签名密钥
                .parseClaimsJws(jwt)//设置需要解析的Jwt令牌
                .getBody();
        return claims;

    }
}
