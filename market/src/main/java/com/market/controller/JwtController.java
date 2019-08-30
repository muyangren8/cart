package com.market.controller;

import com.market.domain.ChartResult;
import com.market.domain.Manager;
import com.market.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/sso")
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
        return ChartResult.build(400, "注销失败");
    }

    @GetMapping("/getCode")
    public ChartResult getCode(Long cid) {
        String phone = service.getCode(cid);

        if (phone != null) {
            return ChartResult.ok(phone);
        }

        return ChartResult.build(400, "发送验证码失败");
    }

    @GetMapping("/checkCode")
    public ChartResult checkCode(String phone, String code) {
        Boolean aBoolean = service.checkCode(phone, code);

        if (aBoolean) {
            return ChartResult.ok();
        }

        return ChartResult.build(400, "验证码验证失败");
    }

    @GetMapping("/test")
    public String test(){
        return "test";
    }
}
