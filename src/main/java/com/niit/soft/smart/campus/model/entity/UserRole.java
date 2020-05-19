package com.niit.soft.smart.campus.model.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/5/19
 * @Version 1.0
 */
@Entity
@Data
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "sys_user_id")
    private Long sysUserId;

    @Column(name = "role_id")
    private Long roleId;
}
