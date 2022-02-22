package wang.blog.admin.model.params;

import lombok.Data;

/**
 * @author 王家俊
 */
@Data
public class PageParam {

    private Integer currentPage;

    private Integer pageSize;

    private String queryString;
}
