package com.market.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.market.exception.CustomException;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.util.Date;
import java.util.Map;

public class JwtUtil {


    /**
     * Description: 生成一个jwt字符串
     *
     * @param name    用户名
     * @param secret  秘钥
     * @param timeOut 超时时间（单位s）
     */
    public static String encode(String name, String secret, long timeOut) {
        JwtBuilder builder = Jwts.builder().setHeaderParam("typ", "JWT")
                .claim("name", name)
                .signWith(SignatureAlgorithm.HS256, getKey(secret));
        //设置过期时间
        if (timeOut>=0){
            Long now = System.currentTimeMillis();
            Long expMills = now + timeOut;
            System.out.println("到期时间:" + new Date(expMills));
            builder.setExpiration(new Date(expMills)).setNotBefore(new Date());
        }

        return builder.compact();
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

    public static SecretKeySpec getKey(String secret){
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        byte[] parseBase64Binary = DatatypeConverter.parseBase64Binary(secret);
        return new SecretKeySpec(parseBase64Binary, signatureAlgorithm.getJcaName());
    }
}
