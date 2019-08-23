package com.infinova.sso.mapper;

import org.springframework.stereotype.Repository;

/**
 * @Author lenovo
 * @date 2019/8/13 10:54
 */
@Repository
public interface CustMapper {


    String getPhoneByCid(Long cid);
}
