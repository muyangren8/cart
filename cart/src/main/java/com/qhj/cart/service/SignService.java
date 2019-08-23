package com.qhj.cart.service;

import com.qhj.cart.domain.ChartResult;
import com.qhj.cart.domain.Manager;
import com.qhj.cart.domain.Sign;
import com.qhj.cart.mapper.CustMapper;
import com.qhj.cart.mapper.ManagerMapper;
import com.qhj.cart.mapper.SignMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author lenovo
 * @date 2019/8/18 15:01
 */
@Service
@Transactional
public class SignService {
    private final ManagerMapper managerMapper;
    private final SignMapper signMapper;
    private final CustMapper custMapper;

    @Autowired
    public SignService(ManagerMapper managerMapper, SignMapper signMapper, CustMapper custMapper) {
        this.managerMapper = managerMapper;
        this.signMapper = signMapper;
        this.custMapper = custMapper;
    }

    public ChartResult doSign(Sign sign) {
        Manager manager = managerMapper.getManagerById(sign.getMid());
        sign.setId(sign.getCid());
        sign.setMname(manager.getUsername());
        Integer integer = signMapper.addSign(sign);

        //将客户协议状态置为1，即用户已签订协议
        if (integer > 0 && custMapper.updateStatus(sign.getCid(), 1) == 1) {
            return ChartResult.ok();
        }
        return ChartResult.build(400, "插入Sign失败");
    }

    public Sign getSignById(Long id) {
        return signMapper.getSignById(id);
    }
}
