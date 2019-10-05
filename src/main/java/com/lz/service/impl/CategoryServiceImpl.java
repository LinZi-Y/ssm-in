package com.lz.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.lz.mapper.ICategoryMapper;
import com.lz.entity.Category;
import com.lz.service.ICategoryService;
@Service
public class CategoryServiceImpl implements ICategoryService {

    @Resource
    private ICategoryMapper categoryMapper;

    @Override
    public int deleteByPrimaryKey(Integer catId) {
        return categoryMapper.deleteByPrimaryKey(catId);
    }

    @Override
    public int insert(Category record) {
        return categoryMapper.insert(record);
    }

    @Override
    public int insertSelective(Category record) {
        return categoryMapper.insertSelective(record);
    }

    @Override
    public Category selectByPrimaryKey(Integer catId) {
        return categoryMapper.selectByPrimaryKey(catId);
    }

    @Override
    public int updateByPrimaryKeySelective(Category record) {
        return categoryMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Category record) {
        return categoryMapper.updateByPrimaryKey(record);
    }

}
