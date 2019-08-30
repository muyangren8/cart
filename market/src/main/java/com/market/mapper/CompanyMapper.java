package com.market.mapper;

import com.market.domain.Company;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author lenovo
 * @date 2019/8/13 10:54
 */
@Repository
public interface CompanyMapper {
    List<Company> getCompanyList(Long mid);

    Company getCompanyById(Long id);
}
