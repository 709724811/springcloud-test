package com.springcloud.test.common;

import java.util.List;

/**
 * @Description
 * @Author LANRY
 * @Date 2018-11-23 15:27
 * @Company www.midea.com
 */
public class PageDataResult extends BaseResult {

    /**
     * 总条目数
     */
    private int totalCount;

    /**
     * 返回结果（数据）
     */
    private DataPage result;

    /**
     * 页数
     */
    private int pageSize;

    /**
     * 当前页
     */
    private int pageIndex;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public DataPage getResult() {
        return result;
    }

    public void setResult(DataPage result) {
        this.result = result;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }
}
