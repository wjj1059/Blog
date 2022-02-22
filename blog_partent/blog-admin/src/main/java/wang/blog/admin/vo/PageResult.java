package wang.blog.admin.vo;

import lombok.Data;

import java.util.List;

/**
 * @author 王家俊
 */
@Data
public class PageResult<T> {

    private List<T> list;

    private Long total;
}
