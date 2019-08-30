package com.market.controller;


import com.market.domain.ChartResult;
import com.market.domain.Manager;
import com.market.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
public class JwtController {

    private JwtService service;

    @Autowired
    public JwtController(JwtService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public ChartResult login(@RequestBody Manager manager) {
        String token = service.login(manager);
        return ChartResult.ok(token);
    }

    @GetMapping("/checkJwt")
    public ChartResult checkJwt(String token) {
        Boolean isExist = service.checkJwt(token);
        return ChartResult.ok(isExist);
    }

    @GetMapping("/inValid")
    public ChartResult inValid(String token) {
        boolean aBoolean = service.inValid(token);
        if (aBoolean) {
            return ChartResult.ok();
        }
        return ChartResult.build(400,"注销失败");
    }

    @GetMapping("/getCode")
    public ChartResult getCode(Long cid) {
        Boolean aboolean = service.getCode(cid);

        if (aboolean) {
            return ChartResult.ok("验证码发送成功");
        }

        return ChartResult.build(400,"发送验证码失败");
    }

    @GetMapping("/checkCode")
    public ChartResult checkCode(String phone, String code) {
        Boolean aBoolean = service.checkCode(phone, code);

        if (aBoolean) {
            return ChartResult.ok("验证码验证成功");
        }

        return ChartResult.build(400,"验证码验证失败");
    }
}
