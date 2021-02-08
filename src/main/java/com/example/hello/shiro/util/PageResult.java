package com.example.hello.shiro.util;

import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * 分页查询结果对象
 * @author zhangjinpei
 * @version 1.0
 * @date 2021/2/8 10:06
 **/
public class PageResult<T> extends Page<T> {
    public PageResult(int currPage, int pageSize) {
        super(currPage, pageSize);
    }

    public PageResult(Integer totalCount, Integer pageSize, Integer currPage, List<T> list) {
        super(totalCount, pageSize, currPage, list);
    }

    public com.baomidou.mybatisplus.extension.plugins.pagination.Page convert() {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page page = new com.baomidou.mybatisplus.extension.plugins.pagination.Page((long)this.getCurrPage(), (long)this.getPageSize(), (long)this.getTotalCount());
        page.setRecords(this.getList()).setSearchCount(true);
        return page;
    }

    public static PageResult convert(IPage dbPage) {
        return new PageResult((int)dbPage.getTotal(), (int)dbPage.getSize(), (int)dbPage.getCurrent(), dbPage.getRecords());
    }

    public PageResult() {
    }
}
