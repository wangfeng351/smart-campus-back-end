package com.niit.soft.smart.campus.repository;

import com.niit.soft.smart.campus.model.entity.Permission;
import com.niit.soft.smart.campus.model.entity.RolePermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/5/19
 * @Version 1.0
 */
public interface RolePermissionRepository extends JpaRepository<RolePermission, Long> {

    /**
     * 查询角色的信息
     * @param roleId
     * @return
     */
    @Query("SELECT u FROM RolePermission a, Permission u WHERE a.roleId=?1 AND a.permissionId=u.permissionId")
    List<Permission> getByRoleId(Long roleId);
}
