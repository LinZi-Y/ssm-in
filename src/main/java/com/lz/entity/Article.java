package com.lz.entity;

import lombok.Data;

@Data
public class Article {
    private Integer articleId;

    private String title;

    private String subtitle;

    private String content;
}