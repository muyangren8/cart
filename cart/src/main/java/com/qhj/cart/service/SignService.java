package com.qhj.cart.service;

import com.qhj.cart.domain.ChartResult;
import com.qhj.cart.domain.Manager;
import com.qhj.cart.domain.Sign;
import com.qhj.cart.mapper.ManagerMapper;
import com.qhj.cart.mapper.SignMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author lenovo
 * @date 2019/8/18 15:01
 */
@Service
public class SignService {
    private final ManagerMapper managerMapper;
    private final SignMapper signMapper;
    @Autowired
    public SignService(ManagerMapper managerMapper, SignMapper signMapper) {
        this.managerMapper = managerMapper;
        this.signMapper = signMapper;
    }

    public ChartResult doSign(Sign sign) {
        Manager manager = managerMapper.getManagerById(sign.getMid());
        sign.setMname(manager.getUsername());
        Integer integer = signMapper.addSign(sign);
        if (integer > 0) {
            return ChartResult.ok();
        }
        return ChartResult.build(400,"插入Sign失败");
    }

    public Sign getSignById(Long id) {
        return signMapper.getSignById(id);
    }
}
