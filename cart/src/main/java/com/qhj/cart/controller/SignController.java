package com.qhj.cart.controller;

import com.qhj.cart.domain.ChartResult;
import com.qhj.cart.domain.Sign;
import com.qhj.cart.service.SignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 协议Controller
 *
 * @Author lenovo
 * @date 2019/8/17 15:56
 */
@RestController
@RequestMapping("/sign")
public class SignController {
    private final SignService signService;
    @Autowired
    public SignController(SignService signService) {
        this.signService = signService;
    }

    @PostMapping(value = "/doSign")
    public ChartResult doSign(@RequestBody Sign sign) {
        return signService.doSign(sign);
    }

    @GetMapping("/getSignById")
    public ChartResult getSignById(Long id) {
        return ChartResult.ok(signService.getSignById(id));
    }

    @GetMapping("/getSignByCid")
    public ChartResult getSignByCid(Long cid) {
        return signService.getSignByCid(cid);
    }
}
