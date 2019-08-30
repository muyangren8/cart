package com.market.controller;


import com.market.domain.ChartResult;
import com.market.domain.Cust;
import com.market.service.CustService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 客户Controller
 * @Author lenovo
 * @date 2019/8/13 11:03
 */
@RestController
@RequestMapping("/cust")
public class CustController {
    private CustService custService;
    @Autowired
    public CustController(CustService custService) {
        this.custService = custService;
    }

    /**
     * @param gid 集团id
     * @return 客户列表
     */
    @RequestMapping("/getCustList")
    public ChartResult getCustList(Long gid) {
        List<Cust> custList = custService.getCustList(gid);
        if (custList != null && custList.size() > 0) {
            return ChartResult.ok(custList);
        }
        return ChartResult.build(400, "该目录下为空");
    }

    /**
     * @param id 客户id
     * @return 客户对象
     */
    @RequestMapping("/getCustById")
    public ChartResult getCustById(Long id) {
        Cust cust = custService.getCustById(id);
        if (cust != null) {
            return ChartResult.ok(cust);
        }

        return ChartResult.build(400, "无该客户");
    }
}
