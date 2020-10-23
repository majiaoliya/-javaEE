package com.icis.pojo;


import java.util.List;

public class PageBean<T> {
    private Integer currentPage;//第几页
    private Integer totPage;//一共多少页
    private Integer totCount;//一共多少个
    private Integer pageSize;//每页多少个
    private List<T> dataList;//目标集合

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getTotPage() {
        return totPage;
    }

    public void setTotPage(Integer totPage) {
        this.totPage = totPage;
    }

    public Integer getTotCount() {
        return totCount;
    }

    public void setTotCount(Integer totCount) {
        this.totCount = totCount;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }
}
