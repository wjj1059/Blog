package wang.blog.admin.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import wang.blog.admin.pojo.Admin;

import java.util.ArrayList;

/**
 * @author 王家俊
 */
@Component
public class SecurityUserServiceImpl implements UserDetailsService {

    @Autowired
    private AdminServiceImpl adminService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //登陆的时候，会把username传递到这里
        //通过username查询到admin表，如果admin存在将密码告诉spring  Security
        Admin admin = this.adminService.findAdminByUsername(username);
        if (admin==null){
            //登陆失败
            return null;
        }
        UserDetails userDetails = new User(username, admin.getPassword(), new ArrayList<>());
        return userDetails;
    }
}
