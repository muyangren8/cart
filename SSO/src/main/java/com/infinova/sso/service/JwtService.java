package com.infinova.sso.service;

import com.demo.wxwgbt.DownMsg;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infinova.sso.entity.Manager;
import com.infinova.sso.entity.Token;
import com.infinova.sso.exception.CustomException;
import com.infinova.sso.mapper.CodeMapper;
import com.infinova.sso.mapper.CustMapper;
import com.infinova.sso.mapper.ManagerMapper;
import com.infinova.sso.mapper.TokenMapper;
import com.infinova.sso.util.JwtUtil;
import com.infinova.sso.util.SendMsgUtil;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.Objects;


@Service
@Transactional
public class JwtService {
    private Logger logger = LoggerFactory.getLogger(JwtService.class);

    private CustMapper custMapper;
    private ManagerMapper managerMapper;
    private TokenMapper tokenMapper;
    private CodeMapper codeMapper;
    private static int expireTime;
    private static final String SECRET = "CHINAMOBILEZHICHENG";

    @Autowired
    public JwtService(ManagerMapper managerMapper, CustMapper custMapper, TokenMapper tokenMapper, CodeMapper codeMapper) {
        this.managerMapper = managerMapper;
        this.custMapper = custMapper;
        this.tokenMapper = tokenMapper;
        this.codeMapper = codeMapper;
    }

    /**
     * jwt token超时时间，单位ms
     */
    @Value("${jwt_expire_time}")
    public void setExpireTime(int jwt_expire_time) {
        JwtService.expireTime = jwt_expire_time * 60 * 1000;
    }

    public String login(Manager manager) {
        //进行登录校验
        try {
            Manager existManager = managerMapper.getManagerByUsername(manager.getUsername());
            System.out.println(existManager);
            if (Objects.equals(existManager.getPassword(), manager.getPassword())) {
                return this.generateNewJwt(existManager.getUsername());
            } else {
                logger.info("账号密码错误:{}{}", manager.getUsername(), manager.getPassword());
                throw new CustomException("账号密码错误");
            }
        } catch (Exception e) {
            logger.info("账号密码错误:{},{}", manager.getUsername(), manager.getPassword());
            throw new CustomException(e, "账号密码错误");
        }
    }


    private String generateNewJwt(String name) {
        System.out.println(SECRET);

        String token = JwtUtil.encode(name, SECRET, expireTime);
        System.out.println("token" + token);
        String sign = token.split("\\.")[2];
        System.out.println(sign);
        Token existToken = tokenMapper.getToken(name);
        if (existToken == null) {
            tokenMapper.insertToken(name, sign);
        } else {
            tokenMapper.updateToken(name, sign);
        }
        //RedisUtil.set(token, secret, expireTime);

        return token;
    }


    public Boolean checkJwt(String token) {
        String sign = null;
        try {
            System.out.println("token校验：" + token);
            //获得签名
            sign = token.split("\\.")[2];
            System.out.println(sign);

            //是否已注销
            if (tokenMapper.getTokenBySign(sign) == null) {
                return false;
            }

            //获得载荷
            Map<String, Object> jwtClams = Jwts.parser().setSigningKey(JwtUtil.getKey(SECRET)).parseClaimsJws(token).getBody();
            ObjectMapper mapper = new ObjectMapper();
            //将载荷转化成字符串
            String payLoad = mapper.writeValueAsString(jwtClams);
            //重新生成签名
            JwtBuilder builder = Jwts.builder().setHeaderParam("typ", "JWT").setPayload(payLoad).signWith(SignatureAlgorithm.HS256, JwtUtil.getKey(SECRET));
            String newsign = builder.compact().split("\\.")[2];

            //新签名和旧签名对比
            if (!sign.equals(newsign)) {
                return false;
            }

        } catch (ExpiredJwtException e) {
            e.printStackTrace();
            System.out.println("token过期");
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        System.out.println("token校验正确");
        return true;
    }


    public boolean inValid(String token) {
        //获得签名
        String sign = token.split("\\.")[2];
        int i = 0;
        try {
            i = tokenMapper.deleteToken(sign);
        } catch (Exception e) {
            e.printStackTrace();
            i = -1;
        }
        return i == 1;
    }

    public Boolean getCode(Long cid) {
        String phone = getPhoneByCid(cid);
        String code = String.valueOf((int) ((Math.random() * 9 + 1) * 100000));

        //RedisUtil.set(phone, code, 1000 * 40);
        try {
            DownMsg downMsg = new DownMsg(phone, "【甬移微入口】您的验证码为" + code + ",请使用验证码进行登陆,半小时内有效。");
            SendMsgUtil.send(downMsg.toString());

            String existCode = codeMapper.getCode(phone);
            if (existCode == null) {
                codeMapper.insertCode(phone, code);
            } else {
                codeMapper.updateCode(phone, code);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    private String getPhoneByCid(Long cid) {
        return custMapper.getPhoneByCid(cid);
    }


    public Boolean checkCode(String phone, String code) {
        //String str = RedisUtil.redisTemplate.opsForValue().get(phone);
        String existCode = codeMapper.getCode(phone);
        if (Objects.equals(existCode, code)) {
            codeMapper.deleteCode(phone);
            return true;
        }
        return false;
    }
}
