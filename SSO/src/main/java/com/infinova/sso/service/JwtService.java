package com.infinova.sso.service;

import com.infinova.sso.entity.Manager;
import com.infinova.sso.exception.CustomException;
import com.infinova.sso.mapper.ManagerMapper;
import com.infinova.sso.util.JwtUtil;
import com.infinova.sso.util.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;


@Service
@EnableScheduling
public class JwtService {

    private ManagerMapper managerMapper;
    @Autowired
    public JwtService(ManagerMapper managerMapper) {
        this.managerMapper = managerMapper;
    }

    private Logger logger = LoggerFactory.getLogger(JwtService.class);

    /**
     * jwt token超时时间，单位ms
     */
    private static int expireTime;
    @Value("${jwt_expire_time}")
    public void setExpireTime(int jwt_expire_time) {
        JwtService.expireTime = jwt_expire_time * 60 * 1000;
    }

    public String login(Manager manager) {
        //进行登录校验
        try {
            Manager existManager = managerMapper.getManagerByUsername(manager.getUsername());
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
        String secret = UUID.randomUUID().toString().replaceAll("-", "");
        String token = JwtUtil.encode(name, secret, expireTime);
        RedisUtil.set(token, secret, expireTime);
        return token;
    }


    public Boolean checkJwt(String jwt) {
        try {
            String secret = RedisUtil.redisTemplate.opsForValue().get(jwt);
            JwtUtil.decode(jwt, secret);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    /**
     * @param jwt
     */
    public Boolean inValid(String jwt) {
        return RedisUtil.delete(jwt);
    }

}
