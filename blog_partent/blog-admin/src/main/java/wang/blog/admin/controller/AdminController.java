package wang.blog.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wang.blog.admin.model.params.PageParam;
import wang.blog.admin.pojo.Permission;
import wang.blog.admin.service.Impl.PermissionServiceImpl;
import wang.blog.admin.service.PermissionService;
import wang.blog.admin.vo.Result;

/**
 * @author 王家俊
 */
@RestController
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private PermissionServiceImpl permissionService;

    @PostMapping("permission/permissionList")
    public Result listPermission(@RequestBody PageParam pageParam){
      return permissionService.listPermission(pageParam);
    }
    @PostMapping("permission/add")
    public Result add(@RequestBody Permission permission){
        return permissionService.add(permission);
    }
    @PostMapping("permission/update")
    public Result update(@RequestBody Permission permission){
        return permissionService.update(permission);
    }
    @GetMapping("permission/delete/{id}")
    public Result delete(@PathVariable("id") Long id){
        return permissionService.delete(id);
    }
}
