package com.niit.soft.smart.campus.repository;


import com.niit.soft.smart.campus.model.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/5/19
 * @Version 1.0
 */
public interface SysUserRepository extends JpaRepository<SysUser, Long> {

    /**
     * 根据账号查询
     * @param sysUserName
     * @return
     */
    SysUser findBySysUserName(String sysUserName);
}
