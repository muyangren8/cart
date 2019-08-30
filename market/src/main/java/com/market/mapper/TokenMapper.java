package com.market.mapper;

import com.market.domain.Token;
import org.springframework.stereotype.Repository;

/**
 * @Author lenovo
 * @date 2019/8/27 15:28
 */
@Repository
public interface TokenMapper {
    Token getToken(String name);

    int insertToken(String name, String sign);

    int updateToken(String name, String sign);

    int deleteToken(String token);

    Token getTokenBySign(String sign);

}