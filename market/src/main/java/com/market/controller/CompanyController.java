package com.market.controller;


import com.market.domain.ChartResult;
import com.market.domain.Company;
import com.market.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 集团Controller
 * @Author lenovo
 * @date 2019/8/13 11:03
 */
@RestController
@RequestMapping("/company")
public class CompanyController {
    private CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    /**
     * @param mid 经理id
     * @return 集团列表
     */
    @RequestMapping("/getCompanyList")
    public ChartResult getCompanyList(Long mid) {
        List<Company> companyList = companyService.getCompanyList(mid);
        if (companyList != null && companyList.size() > 0) {
            return ChartResult.ok(companyList);
        }
        return ChartResult.build(400, "该目录下为空");
    }

    /**
     * @param id 集团id
     * @return 集团对象
     */
    @RequestMapping("/getCompanyById")
    public ChartResult getCompanyById(Long id){
        Company company = companyService.getCompanyById(id);
        if (company != null) {
            return ChartResult.ok(company);
        }
        return ChartResult.build(400, "无该集团");
    }


}
