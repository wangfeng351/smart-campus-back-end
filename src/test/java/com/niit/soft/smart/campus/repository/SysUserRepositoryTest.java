package com.niit.soft.smart.campus.repository;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/5/19
 * @Version 1.0
 */
@SpringBootTest
class SysUserRepositoryTest {
    @Resource
    private SysUserRepository sysUserRepository;

    @Test
    void findBySysUserName() {
        System.out.println(sysUserRepository.findBySysUserName("test"));
    }
}