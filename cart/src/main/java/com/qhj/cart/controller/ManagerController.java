package com.qhj.cart.controller;

import com.qhj.cart.domain.ChartResult;
import com.qhj.cart.domain.Manager;
import com.qhj.cart.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author lenovo
 * @date 2019/8/13 11:03
 */
@RestController
@RequestMapping("/manager")
public class ManagerController {
    private ManagerService managerService;

    @Autowired
    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    @RequestMapping("/getManagerList")
    public ChartResult getManagerList() {
        List<Manager> managerList = managerService.getManagerList();
        if (managerList != null && managerList.size() > 0) {
            return ChartResult.ok(managerList);
        }
        return ChartResult.build(400, "该目录下为空");
    }

    @RequestMapping("/getMidByUsername")
    public ChartResult getMidByUsername(String username) {
        Long mid = managerService.getMidByUsername(username);
        System.out.println(mid);
        if (mid < 1) {
            return ChartResult.build(400,"无该用户");
        }
        return ChartResult.ok(mid);

    }
}
