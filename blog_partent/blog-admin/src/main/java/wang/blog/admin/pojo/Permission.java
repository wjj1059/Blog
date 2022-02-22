package wang.blog.admin.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author 王家俊
 */
@Data
public class Permission {
    @TableId(type = IdType.AUTO)
    private Long id;

    private String name;

    private String path;

    private String description;
}
