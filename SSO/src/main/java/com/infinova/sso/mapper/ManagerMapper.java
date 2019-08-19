package com.infinova.sso.mapper;

import com.infinova.sso.entity.Manager;
import org.springframework.stereotype.Repository;

/**
 * @Author lenovo
 * @date 2019/8/13 10:54
 */
@Repository
public interface ManagerMapper {

    Manager getManagerById(Long id);

    Manager getManagerByUsername(String name);
}
