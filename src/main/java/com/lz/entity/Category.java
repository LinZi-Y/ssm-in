package com.lz.entity;

import java.util.Date;
import lombok.Data;

@Data
public class Category {
    private Integer catId;

    private String catName;

    private Date date;

    private String about;

    private Integer goodsId;
}