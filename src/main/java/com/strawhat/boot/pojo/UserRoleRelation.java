package com.strawhat.boot.pojo;

import lombok.Data;

@Data
public class UserRoleRelation {
    private Integer id;
    private String account;
    private String roleId;
}
