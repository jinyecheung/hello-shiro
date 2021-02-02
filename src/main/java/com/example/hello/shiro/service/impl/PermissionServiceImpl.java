package com.example.hello.shiro.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.hello.shiro.mapper.PermissionMapper;
import com.example.hello.shiro.pojo.Permission;
import com.example.hello.shiro.service.IPermissionService;
import com.example.hello.shiro.util.IDUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void savePermission(Permission p) {
        p.setPermissionId(IDUtil.getID());
        this.save(p);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updatePermission(Permission p) {
        this.updateById(p);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deletePermission(Permission p) {
        this.removeById(p.getPermissionId());
    }

    @Override
    public List<Permission> findPermissionList(Permission p) {
        LambdaQueryWrapper<Permission> lqw = new LambdaQueryWrapper<>();
        if(StringUtils.isNotBlank(p.getPermissionId())){
            lqw.eq(Permission::getPermissionId,p.getPermissionId());
        }
        if(StringUtils.isNotBlank(p.getPermissionName())){
            lqw.like(Permission::getPermissionName,p.getPermissionName());
        }
        if(StringUtils.isNotBlank(p.getPermissionCode())){
            lqw.eq(Permission::getPermissionCode,p.getPermissionCode());
        }
        if(StringUtils.isNotBlank(p.getPermissionType())){
            lqw.eq(Permission::getPermissionType,p.getPermissionType());
        }
        return this.list(lqw);
    }
}
