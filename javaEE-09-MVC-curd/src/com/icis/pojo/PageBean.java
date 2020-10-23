package com.icis.pojo;


import java.util.List;

public class PageBean<T, E> {
    private Integer currentPage;//第几页
    private Integer totPage;//一共多少页
    private Integer totCount;//一共多少个
    private Integer pageSize;//每页多少个
    private List<T> dataList;//目标集合
    private List<E> addressList;
    private String query_username, queyr_sex, cur_query_address;

    @Override
    public String toString() {
        return "PageBean{" +
                "currentPage=" + currentPage +
                ", totPage=" + totPage +
                ", totCount=" + totCount +
                ", pageSize=" + pageSize +
                ", dataList=" + dataList +
                ", addressList=" + addressList +
                ", query_username='" + query_username + '\'' +
                ", queyr_sex='" + queyr_sex + '\'' +
                ", cur_query_address='" + cur_query_address + '\'' +
                '}';
    }

    public List<E> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<E> addressList) {
        this.addressList = addressList;
    }

    public String getCur_query_address() {
        return cur_query_address;
    }

    public void setCur_query_address(String cur_query_address) {
        this.cur_query_address = cur_query_address;
    }

    public String getQuery_username() {
        return query_username;
    }

    public void setQuery_username(String query_username) {
        this.query_username = query_username;
    }

    public String getQueyr_sex() {
        return queyr_sex;
    }

    public void setQueyr_sex(String queyr_sex) {
        this.queyr_sex = queyr_sex;
    }

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
