package com.infinova.sso.controller;

import com.infinova.sso.entity.Manager;
import com.infinova.sso.entity.ReturnEntity;
import com.infinova.sso.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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
}
