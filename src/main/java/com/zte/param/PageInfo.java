package com.zte.param;

import java.io.Serializable;
import java.util.List;

public class PageInfo implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * 页码，从1开始
     */
    private int pageNum;

    /**
     * 页面大小
     */
    private int pageSize;

    /**
     * 总数
     */
    private long total;

    /**
     * 总页数
     */
    private int pages;

    private List data;

    public PageInfo() {
        super();
    }

    public PageInfo(int pageNum, int pageSize, long total, int pages) {
        super();
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.total = total;
        this.pages = pages;
    }

    public PageInfo(int pageNum, int pageSize, long total, int pages, List data) {
        super();
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.total = total;
        this.pages = pages;
        this.data = data;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }
}
