package com.infinova.sso.controller;

import com.infinova.sso.entity.Manager;
import com.infinova.sso.entity.ReturnEntity;
import com.infinova.sso.service.JwtService;
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
    public ReturnEntity login(@RequestBody Manager manager) {
        String token = service.login(manager);
        return ReturnEntity.successResult(token);
    }

    @GetMapping("/checkJwt")
    public ReturnEntity checkJwt(String token) {
        Boolean isExist = service.checkJwt(token);
        return ReturnEntity.successResult(isExist);
    }

    @GetMapping("/inValid")
    public ReturnEntity inValid(String token) {
        Boolean aBoolean = service.inValid(token);
        if (aBoolean) {
            return ReturnEntity.successResult(null);
        }
        return ReturnEntity.failedResult("注销失败");
    }

    @GetMapping("/getCode")
    public ReturnEntity getCode(Long cid) {
        Map map = service.getCode(cid);

        if (map != null && map.size() > 0) {
            return ReturnEntity.successResult(map);
        }

        return ReturnEntity.failedResult("发送验证码失败");
    }

    @GetMapping("/checkCode")
    public ReturnEntity checkCode(String phone, String code) {
        Boolean aBoolean = service.checkCode(phone, code);

        if (aBoolean) {
            return ReturnEntity.successResult("验证码验证成功");
        }

        return ReturnEntity.failedResult("验证码验证失败");
    }
}
