package com.lz.entity;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

@Data
public class Goods {
    private Integer gId;

    private String title;

    private String pic;

    private String name;

    /**
    * 出发地点
    */
    private String address;

    private String goAddress;

    private BigDecimal price;

    /**
    * 描述
    */
    private String describe;

    private String longTime;

    private Date date;

    private Integer isDelete;
}