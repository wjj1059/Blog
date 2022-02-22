package wang.blog.admin.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import wang.blog.admin.mapper.PermissionMapper;
import wang.blog.admin.model.params.PageParam;
import wang.blog.admin.pojo.Permission;
import wang.blog.admin.service.PermissionService;
import wang.blog.admin.vo.PageResult;
import wang.blog.admin.vo.Result;

/**
 * @author 王家俊
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public Result listPermission(PageParam pageParam) {
        /**
         * 要的数据，管理台，表的所有字段
         * 分页查询
         * @param pageParam
         * @return
         */
       Page<Permission> page = new Page<>(pageParam.getCurrentPage(),pageParam.getPageSize());
        LambdaQueryWrapper<Permission> queryWrapper = new LambdaQueryWrapper();
        if (StringUtils.isNotBlank(pageParam.getQueryString())){
           queryWrapper.eq(Permission::getName,pageParam.getQueryString());
        }
        Page<Permission> permissionPage = permissionMapper.selectPage(page, queryWrapper);
        PageResult<Permission> pageResult = new PageResult<>();
        pageResult.setList(permissionPage.getRecords());
        pageResult.setTotal(permissionPage.getTotal());
        return Result.success(pageResult);
    }

    @Override
    public Result add(Permission permission) {
       this.permissionMapper.insert(permission);
       return Result.success("插入成功");
    }

    @Override
    public Result update(Permission permission) {
        this.permissionMapper.updateById(permission);
        return Result.success("修改成功");
    }

    @Override
    public Result delete(Long id) {
        this.permissionMapper.deleteById(id);
        return Result.success("删除成功");
    }
}
