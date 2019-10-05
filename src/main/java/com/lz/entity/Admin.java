package com.lz.entity;

import lombok.Data;

@Data
public class Admin {
    private Integer aId;

    private String username;

    private String password;

    private String isDelete;
}