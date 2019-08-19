package com.qhj.cart.mapper;

import com.qhj.cart.domain.Manager;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author lenovo
 * @date 2019/8/13 10:54
 */
@Repository
public interface ManagerMapper {
    List<Manager> getManagerList();

    Manager getManagerById(Long id);

    Long getMidByUsername(String username);
}
