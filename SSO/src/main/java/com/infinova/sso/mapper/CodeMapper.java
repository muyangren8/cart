package com.infinova.sso.mapper;

import org.springframework.stereotype.Repository;

/**
 * @Author lenovo
 * @date 2019/8/13 10:54
 */
@Repository
public interface CodeMapper {


    String getCode(String phone);

    void insertCode(String phone, String code);

    void updateCode(String phone, String code);

    void deleteCode(String phone);
}
