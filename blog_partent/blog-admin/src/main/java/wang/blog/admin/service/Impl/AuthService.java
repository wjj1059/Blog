package wang.blog.admin.service.Impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import wang.blog.admin.pojo.Admin;
import wang.blog.admin.pojo.Permission;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author 王家俊
 */
@Service
public class AuthService {

    @Autowired
    private AdminServiceImpl adminService;

    public boolean auth(HttpServletRequest request, Authentication authentication){
        //权限认证
         //请求路径
        String requestURI = request.getRequestURI();
        Object principal = authentication.getPrincipal();
        if (principal==null||"anonymousUser".equals(principal)){
            //未登录
            return false;
        }
        UserDetails userDetails =(UserDetails) principal;
        String username = userDetails.getUsername();
        Admin admin = adminService.findAdminByUsername(username);
        if (admin==null){
            return false;
        }
        if (1==admin.getId()){
            //超级管理员
            return true;
        }
        Long id = admin.getId();
        List<Permission> permissions = adminService.findPermissionByAdminId(id);
        requestURI=StringUtils.split(requestURI,"?")[0];
        for (Permission permission : permissions) {
            if (requestURI.equals(permission.getPath())){
                return  true;
            }
        }
        //放行
        return  false;
    }
}
