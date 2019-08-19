package com.qhj.cart.service;

import com.qhj.cart.domain.Company;
import com.qhj.cart.mapper.CompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author lenovo
 * @date 2019/8/13 11:04
 */
@Service
public class CompanyService {
    private CompanyMapper companyMapper;
    @Autowired
    public CompanyService(CompanyMapper companyMapper) {
        this.companyMapper = companyMapper;
    }

    public List<Company> getCompanyList(Long mid) {
        return companyMapper.getCompanyList(mid);
    }

    public Company getCompanyById(Long id) {
        return companyMapper.getCompanyById(id);
    }
}
