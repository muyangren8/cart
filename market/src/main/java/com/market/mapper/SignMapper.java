package com.market.mapper;

import com.market.domain.Sign;
import org.springframework.stereotype.Repository;

/**
 * @Author lenovo
 * @date 2019/8/18 15:05
 */
@Repository
public interface SignMapper {

    Integer addSign(Sign sign);

    Sign getSignById(Long id);

    Sign getSignByCid(Long cid);
}
