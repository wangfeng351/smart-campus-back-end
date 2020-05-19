package com.niit.soft.smart.campus.repository;

import com.niit.soft.smart.campus.model.entity.Permission;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/5/19
 * @Version 1.0
 */
@SpringBootTest
class RolePermissionRepositoryTest {
    @Resource
    private RolePermissionRepository rolePermissionRepository;

    @Test
    void getByRoleId() {
        List<Permission> permissions = rolePermissionRepository.getByRoleId((long) 1);
        permissions.forEach(permission -> {
            System.out.println(permission.getName());
            System.out.println(permission.getName().length());
        });
    }
}