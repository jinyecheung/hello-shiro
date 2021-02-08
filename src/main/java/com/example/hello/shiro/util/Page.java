package com.example.hello.shiro.util;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * @author zhangjinpei
 * @version 1.0
 * @date 2021/2/8 10:28
 **/

public class Page<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer totalCount = 0;
    private Integer pageSize = 10;
    private Integer currPage = 1;
    private List<T> list = Collections.emptyList();

    public int getTotalPage() {
        if (this.getPageSize() == 0) {
            return 0;
        } else {
            int totalPage = this.getTotalCount() / this.getPageSize();
            if (this.getTotalCount() % this.getPageSize() != 0) {
                ++totalPage;
            }

            return totalPage;
        }
    }

    public Page(int currPage, int pageSize) {
        if (currPage > 1) {
            this.currPage = currPage;
        }

        this.pageSize = pageSize;
    }

    public static <T> Page.PageBuilder<T> builder() {
        return new Page.PageBuilder();
    }

    @Override
    public String toString() {
        return "Page(totalCount=" + this.getTotalCount() + ", pageSize=" + this.getPageSize() + ", currPage=" + this.getCurrPage() + ", list=" + this.getList() + ")";
    }

    public Page() {
    }

    public Page(Integer totalCount, Integer pageSize, Integer currPage, List<T> list) {
        this.totalCount = totalCount;
        this.pageSize = pageSize;
        this.currPage = currPage;
        this.list = list;
    }

    public Integer getTotalCount() {
        return this.totalCount;
    }

    public Page<T> setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
        return this;
    }

    public Integer getPageSize() {
        return this.pageSize;
    }

    public Page<T> setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public Integer getCurrPage() {
        return this.currPage;
    }

    public Page<T> setCurrPage(Integer currPage) {
        this.currPage = currPage;
        return this;
    }

    public List<T> getList() {
        return this.list;
    }

    public Page<T> setList(List<T> list) {
        this.list = list;
        return this;
    }

    public static class PageBuilder<T> {
        private Integer totalCount;
        private Integer pageSize;
        private Integer currPage;
        private List<T> list;

        PageBuilder() {
        }

        public Page.PageBuilder<T> totalCount(Integer totalCount) {
            this.totalCount = totalCount;
            return this;
        }

        public Page.PageBuilder<T> pageSize(Integer pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public Page.PageBuilder<T> currPage(Integer currPage) {
            this.currPage = currPage;
            return this;
        }

        public Page.PageBuilder<T> list(List<T> list) {
            this.list = list;
            return this;
        }

        public Page<T> build() {
            return new Page(this.totalCount, this.pageSize, this.currPage, this.list);
        }

        @Override
        public String toString() {
            return "Page.PageBuilder(totalCount=" + this.totalCount + ", pageSize=" + this.pageSize + ", currPage=" + this.currPage + ", list=" + this.list + ")";
        }
    }
}
