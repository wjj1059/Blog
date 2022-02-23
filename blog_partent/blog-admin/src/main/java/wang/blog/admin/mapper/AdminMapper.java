package wang.blog.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import wang.blog.admin.pojo.Admin;
import wang.blog.admin.pojo.Permission;

import java.util.List;

/**
 * @author 王家俊
 */
@Repository
@Mapper
public interface AdminMapper  extends BaseMapper<Admin> {
}
