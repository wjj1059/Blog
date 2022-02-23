package wang.blog.admin.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wang.blog.admin.mapper.AdminMapper;
import wang.blog.admin.mapper.PermissionMapper;
import wang.blog.admin.pojo.Admin;
import wang.blog.admin.pojo.Permission;
import wang.blog.admin.service.AdminService;

import java.util.List;

/**
 * @author 王家俊
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private PermissionMapper permissionMapper;

    public Admin findAdminByUsername(String username){
        LambdaQueryWrapper<Admin> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Admin::getUsername,username);
        queryWrapper.last("limit 1");
        Admin admin = adminMapper.selectOne(queryWrapper);
        return admin;
    }


    public List<Permission> findPermissionByAdminId(Long adminId) {
        return permissionMapper.findPermissionsByAdminId(adminId);
    }
}
