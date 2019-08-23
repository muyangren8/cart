package com.qhj.cart.mapper;

import com.qhj.cart.domain.Cust;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author lenovo
 * @date 2019/8/13 10:54
 */
@Repository
public interface CustMapper {
    List<Cust> getCustList(Long gid);

    Cust getCustById(Long id);

    int updateStatus(Long cid, Integer status);
}
