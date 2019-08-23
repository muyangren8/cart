package com.qhj.cart.service;

import com.qhj.cart.domain.Manager;
import com.qhj.cart.mapper.ManagerMapper;
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
public class ManagerService {
    private ManagerMapper managerMapper;
    @Autowired
    public ManagerService(ManagerMapper managerMapper) {
        this.managerMapper = managerMapper;
    }

    public List<Manager> getManagerList() {
        return managerMapper.getManagerList();
    }

    public Long getMidByUsername(String username) {
        return managerMapper.getMidByUsername(username);
    }
}
