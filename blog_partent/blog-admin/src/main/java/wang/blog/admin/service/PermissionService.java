package wang.blog.admin.service;

import org.springframework.stereotype.Repository;
import wang.blog.admin.model.params.PageParam;
import wang.blog.admin.pojo.Permission;
import wang.blog.admin.vo.Result;

/**
 * @author 王家俊
 */
@Repository
public interface PermissionService {
    Result listPermission(PageParam pageParam);

    Result add(Permission permission);

    Result update(Permission permission);

    Result delete(Long id);
}
