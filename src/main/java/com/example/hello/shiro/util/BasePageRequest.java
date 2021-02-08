package com.example.hello.shiro.util;

/**
 * 分页查询请求对象，入参默认包含：当前页面的显示数量pageSize，当前页面的索引值currPage
 * @author zhangjinpei
 * @version 1.0
 * @date 2021/2/8 10:01
 **/
public class BasePageRequest {
    private int pageSize = 10;
    private int currPage = 1;

    public BasePageRequest() {
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public int getCurrPage() {
        return this.currPage;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof BasePageRequest)) {
            return false;
        } else {
            BasePageRequest other = (BasePageRequest)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getPageSize() != other.getPageSize()) {
                return false;
            } else {
                return this.getCurrPage() == other.getCurrPage();
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof BasePageRequest;
    }

    @Override
    public int hashCode() {
        // boolean PRIME = true;
        int result = 1;
        result = result * 59 + this.getPageSize();
        return result;
    }
    @Override
    public String toString() {
        return "BasePageQuery(pageSize=" + this.getPageSize() + ", currPage=" + this.getCurrPage() + ")";
    }
}
