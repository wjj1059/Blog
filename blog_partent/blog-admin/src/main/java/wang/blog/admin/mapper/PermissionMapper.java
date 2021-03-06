package wang.blog.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import wang.blog.admin.pojo.Permission;

import java.util.List;

/**
 * @author 王家俊
 */
@Mapper
@Repository
public interface PermissionMapper extends BaseMapper<Permission> {
    List<Permission> findPermissionsByAdminId(Long adminId);
}
