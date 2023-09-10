package org.sdsds222.testtlias;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@SpringBootTest
class TestTliasApplicationTests {
    /*
     * 生成UUID
     * */
    @Test
    public void testUuid() {
        for (int i = 0; i < 1000; i++) {
            String uuid = UUID.randomUUID().toString();
            System.out.println(uuid);
        }
    }

    /*
     * 生成Jwt令牌
     * */
    @Test
    public void testCreateJwt() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 1);
        claims.put("name", "test");
        String jwt = Jwts.builder().
                signWith(SignatureAlgorithm.HS256, "sdsds222")//签名算法
                .setClaims(claims)//设置自定义内容
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000))//设置有效期，超出期限令牌失效（此处为当前时间开始一小时）
                .compact();//生成Jwt令牌
        System.out.println(jwt);
    }

    /*
     * 解析Jwt令牌
     * */
    @Test
    public void testParseJwt(){
        Claims claims = Jwts.parser()
                .setSigningKey("sdsds222")//设置签名密钥
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoidGVzdCIsImlkIjoxLCJleHAiOjE2OTMyMjU4MzF9.-9IxulBbDo7EDfUyfKvKPK6RvEh_TCaRU33p_ALi2RA")//设置需要解析的Jwt令牌
                .getBody();
        System.out.println(claims);

    }

    @Test
    void contextLoads() {
    }

}
