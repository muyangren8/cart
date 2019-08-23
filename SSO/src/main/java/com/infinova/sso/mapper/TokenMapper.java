package com.infinova.sso.mapper;

import com.infinova.sso.entity.Token;
import org.springframework.stereotype.Repository;

/**
 * @Author lenovo
 * @date 2019/8/13 10:54
 */
@Repository
public interface TokenMapper {
    Token getToken(String name);

    int insertToken(String name, String sign);

    int updateToken(String name, String sign);

    int deleteToken(String token);

    Token getTokenBySign(String sign);

}
