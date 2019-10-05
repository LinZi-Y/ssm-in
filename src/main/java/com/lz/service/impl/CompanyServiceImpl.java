package com.lz.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.lz.mapper.ICompanyMapper;
import com.lz.entity.Company;
import com.lz.service.ICompanyService;
@Service
public class CompanyServiceImpl implements ICompanyService {

    @Resource
    private ICompanyMapper companyMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return companyMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Company record) {
        return companyMapper.insert(record);
    }

    @Override
    public int insertSelective(Company record) {
        return companyMapper.insertSelective(record);
    }

    @Override
    public Company selectByPrimaryKey(Integer id) {
        return companyMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Company record) {
        return companyMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Company record) {
        return companyMapper.updateByPrimaryKey(record);
    }

}
