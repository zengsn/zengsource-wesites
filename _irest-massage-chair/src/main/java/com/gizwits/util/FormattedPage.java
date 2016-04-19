package com.gizwits.util;

import org.springframework.data.domain.Page;

/**
 * @author Marvel
 * 
 * 有分页的接口返回格式
 */
public class FormattedPage extends FormattedResult {

    private static final long serialVersionUID = 1L;
    
    // 当前页码
    private Integer page;
    // 每页大小
    private Integer size;
    // 总记录数
    private Long totalElements;
    // 总页码
    private Integer totalPages;
    
    public FormattedPage(Page<?> page, RetMsg rm) {
        super(page.getContent(), rm);
        this.page = page.getNumber();
        this.size = page.getSize();
        this.totalElements = page.getTotalElements();
        this.totalPages = page.getTotalPages();
    }
    
    public FormattedPage(Integer page, Integer size, RetMsg rm) {
        super(rm);
        this.page = page;
        this.size = size;
        this.totalElements = (long) 0;
        this.totalPages = 0;
    }
    
    // get、set方法

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(Long totalElements) {
        this.totalElements = totalElements;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }
    
}
