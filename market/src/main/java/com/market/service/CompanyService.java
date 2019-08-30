package com.market.service;

import com.market.domain.Company;
import com.market.mapper.CompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author lenovo
 * @date 2019/8/13 11:04
 */
@Service
@Transactional
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
