package com.qhj.cart.mapper;

import com.qhj.cart.domain.Sign;
import org.springframework.stereotype.Repository;

/**
 * @Author lenovo
 * @date 2019/8/18 15:05
 */
@Repository
public interface SignMapper {

    Integer addSign(Sign sign);

    Sign getSignById(Long id);
}
