package com.graduateDesign.req;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageReq {
    /**
     * 第几页
     */
    private Long pageSize;

    /**
     * 每一页的数据量
     */
    private Long curPage;
}
