package com.lz.service;

import com.lz.entity.SiteInfo;
public interface ISiteInfoService {


    int deleteByPrimaryKey(Integer id);

    int insert(SiteInfo record);

    int insertSelective(SiteInfo record);

    SiteInfo selectByPrimaryKey(Integer id);

    SiteInfo quireSiteInfo();

    int updateByPrimaryKeySelective(SiteInfo record);

    int updateByPrimaryKey(SiteInfo record);

}
