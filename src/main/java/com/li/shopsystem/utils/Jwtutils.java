package com.li.shopsystem.utils;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @ClassName Jwtutils
 * @Author ：Li
 * @Date ：2022/5/6 14:55
 * @Description：
 * @Version: 1.0
 * Jwt工具类
 */

@Component
public class Jwtutils {

    private JwtBuilder jwtBuilder = Jwts.builder();

    @Value("${jwt.time}")
    private int time ;

    @Value("${jwt.secret}")
    private String sign ;

    @Value("${jwt.header}")
    private String tokenHeader;

    /**
     * 生成token
     * @param userName 用户名
     * @param role 角色
     * @return token
     */
    public String getJwtToken(String userName,String role) {
        return jwtBuilder.
                setHeaderParam("typ","JWT").
                setHeaderParam("alg","HS256").
                claim("username",userName).
                claim("role",role).
                setExpiration(new Date(System.currentTimeMillis()+time)).
                signWith(SignatureAlgorithm.HS256,sign).
                compact();
    }

    /**
     * 从token中获取负载
     * @param token token
     * @return claims
     */
    public Claims getClaimsFromToken(String token)
    {
        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(sign)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            throw new RuntimeException("JWT格式验证失败:{}");
        }
        return claims;
    }

    /**
     * 从token中获取登录用户名
     * @param token
     * @return
     */
    public String getUsernameFromToken(String token)
    {
        String username;
        try {
            Claims claims = getClaimsFromToken(token);
            username = claims.getSubject();
        } catch (Exception e) {
            username = null;
        }
        return username;
    }
    /**
     * 生成过期时间
     * @return expiration
     */
    public Date generateExpirationDate() {
        return new Date(System.currentTimeMillis()+time);
    }

    /**
     * 验证Token是否还有效
     * @param token
     * @param userName
     * @return
     */
    public boolean validateToken(String token, String userName)
    {
        String username = getUsernameFromToken(token);
        return username.equals(userName) && !isTokenExpired(token);
    }

    /**
     * 判断token是否已经失效
     */
    public boolean isTokenExpired(String token) {
        Date expiredDate = getExpiredDateFromToken(token);
        return expiredDate.before(new Date());
    }

    /**
     * 从token中获取过期时间
     */
    public Date getExpiredDateFromToken(String token) {
        return getClaimsFromToken(token).getExpiration();
    }

}
