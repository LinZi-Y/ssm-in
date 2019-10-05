package com.lz.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.lz.mapper.IAdminMapper;
import com.lz.entity.Admin;
import com.lz.service.IAdminService;
@Service
public class AdminServiceImpl implements IAdminService {

    @Resource
    private IAdminMapper adminMapper;

    @Override
    public int deleteByPrimaryKey(Integer aId) {
        return adminMapper.deleteByPrimaryKey(aId);
    }

    @Override
    public int insert(Admin record) {
        return adminMapper.insert(record);
    }

    @Override
    public int insertSelective(Admin record) {
        return adminMapper.insertSelective(record);
    }

    @Override
    public Admin selectByPrimaryKey(Integer aId) {
        return adminMapper.selectByPrimaryKey(aId);
    }

    @Override
    public int updateByPrimaryKeySelective(Admin record) {
        return adminMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Admin record) {
        return adminMapper.updateByPrimaryKey(record);
    }

}
