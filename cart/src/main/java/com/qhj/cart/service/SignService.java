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

import java.nio.charset.StandardCharsets;

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
        byte[] imageA = sign.getSignatureImageA().getBytes(StandardCharsets.UTF_8);
        sign.setImageA(imageA);
        byte[] imageB = sign.getSignatureImageB().getBytes(StandardCharsets.UTF_8);
        sign.setImageB(imageB);
        System.out.println("协议" + sign);
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

    public ChartResult getSignByCid(Long cid) {
        Sign sign = signMapper.getSignByCid(cid);
        if ( sign != null) {
            String signImageA = new String(sign.getImageA(),StandardCharsets.UTF_8);
            String signImageB = new String(sign.getImageB(),StandardCharsets.UTF_8);
            sign.setSignatureImageA(signImageA);
            sign.setSignatureImageB(signImageB);
            return ChartResult.ok(sign);
        }
        return ChartResult.build(400,"无法查询到此客户所签订的协议");
    }
}
