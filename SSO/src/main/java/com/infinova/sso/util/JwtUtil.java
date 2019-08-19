package com.infinova.sso.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.infinova.sso.exception.CustomException;

import java.util.Date;
import java.util.Map;

public class JwtUtil {

    /**
     * Description: 生成一个jwt字符串
     *
     * @param name    用户名
     * @param secret  秘钥
     * @param timeOut 超时时间（单位s）
     *
     */
    public static String encode(String name, String secret, long timeOut) {
        Algorithm algorithm = Algorithm.HMAC256(secret);
        String token = JWT.create()
                //设置过期时间为一个小时
                .withExpiresAt(new Date(System.currentTimeMillis() + timeOut))
                //设置负载
                .withClaim("name", name).sign(algorithm);
        return token;
    }

    /**
     * Description: 解密jwt
     */
    public static Map<String, Claim> decode(String token, String secret) {
        if (token == null || token.length() == 0) {
            throw new CustomException("token为空:" + token);
        }
        Algorithm algorithm = Algorithm.HMAC256(secret);
        JWTVerifier jwtVerifier = JWT.require(algorithm).build();
        DecodedJWT decodedJWT = jwtVerifier.verify(token);
        return decodedJWT.getClaims();
    }
}
