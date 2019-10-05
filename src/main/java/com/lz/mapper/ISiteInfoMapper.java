package com.lz.mapper;

import com.lz.entity.SiteInfo;

public interface ISiteInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SiteInfo record);

    int insertSelective(SiteInfo record);

    SiteInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SiteInfo record);

    int updateByPrimaryKey(SiteInfo record);
}