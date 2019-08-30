package com.market.service;

import com.market.domain.Cust;
import com.market.mapper.CustMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author lenovo
 * @date 2019/8/13 11:04
 */
@Service
@Transactional
public class CustService {
    private CustMapper custMapper;
    @Autowired
    public CustService(CustMapper custMapper) {
        this.custMapper = custMapper;
    }

    public List<Cust> getCustList(Long gid) {
        return custMapper.getCustList(gid);
    }

    public Cust getCustById(Long id) {
        return custMapper.getCustById(id);
    }
}
