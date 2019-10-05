package com.lz.service;

import com.lz.entity.Article;

import java.util.List;

public interface IArticleService {


    int deleteByPrimaryKey(Integer articleId);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(Integer articleId);

    int selectPage();

    List<Article> selectByList(int pageStart, int pageEnd);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKey(Article record);

}
