package com.lz.entity;

import lombok.Data;

@Data
public class User {
    private Integer uDi;

    private String nickname;

    private String username;

    private String password;

    private String sex;

    private Integer age;

    private String email;

    private String phone;

    private String describe;

    private Integer isDelete;
}