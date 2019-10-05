package com.lz.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.lz.mapper.IOrderMapper;
import com.lz.entity.Order;
import com.lz.service.IOrderService;
@Service
public class OrderServiceImpl implements IOrderService {

    @Resource
    private IOrderMapper orderMapper;

    @Override
    public int deleteByPrimaryKey(Integer oId) {
        return orderMapper.deleteByPrimaryKey(oId);
    }

    @Override
    public int insert(Order record) {
        return orderMapper.insert(record);
    }

    @Override
    public int insertSelective(Order record) {
        return orderMapper.insertSelective(record);
    }

    @Override
    public Order selectByPrimaryKey(Integer oId) {
        return orderMapper.selectByPrimaryKey(oId);
    }

    @Override
    public int updateByPrimaryKeySelective(Order record) {
        return orderMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Order record) {
        return orderMapper.updateByPrimaryKey(record);
    }

}
