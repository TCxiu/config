package com.xiu.jpa.page.demo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Page<T> implements Iterable<T>, Serializable {
    private static final long serialVersionUID = -3720998571176536865L;  
    private List<T> content = new ArrayList<>();

    //总记录数
    private long total;  
    private int pageNo;  
    private int pageSize;

    //是否有前一页
    private Boolean hasPrevious;

    //是否有下一页
    private Boolean hasNext;

    //是否是第一页
    private Boolean isFirst;

    //总页数
    private Integer totalPage;

    //是否有记录
    private Boolean hasContent;


    public Page() {  
    }  
  
    public Page(List<T> content, long total, int pageNo, int pageSize) {  
        this.content = content;  
        this.total = total;  
        this.pageNo = pageNo;  
        this.pageSize = pageSize;
        this.hasPrevious=pageNo >1;
        this.isFirst = !hasPrevious;
        this.totalPage = pageSize == 0 ? 1 : (int) Math.ceil((double) total / (double) getPageSize());
        this.hasNext = pageNo < totalPage;
        this.hasContent = content.size()>0;
    }

    public Boolean getHasPrevious() {
        return hasPrevious;
    }

    public void setHasPrevious(Boolean hasPrevious) {
        this.hasPrevious = hasPrevious;
    }

    public Boolean getHasNext() {
        return hasNext;
    }

    public void setHasNext(Boolean hasNext) {
        this.hasNext = hasNext;
    }

    public Boolean getFirst() {
        return isFirst;
    }

    public void setFirst(Boolean first) {
        isFirst = first;
    }


    public long getTotal() {  
        return total;  
    }  
  
    public void setTotal(long total) {  
        this.total = total;  
    }  
  

    public int getTotalPage() {  
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }


    public List<T> getContent() {  
        return Collections.unmodifiableList(content);
    }  
  
    public void setContent(List<T> content) {  
        this.content = content;  
    }


    public Boolean getHasContent() {
        return hasContent;
    }

    public void setHasContent(Boolean hasContent) {
        this.hasContent = hasContent;
    }

    public int getContentSize() {
        return content.size();  
    }  
  

    public int getPageSize() {  
        return pageSize;  
    }  
  
    public void setPageSize(int pageSize) {  
        this.pageSize = pageSize;  
    }  
  

    public int getPageNo() {  
        return pageNo;  
    }  
  

    public void setPageNo(int pageNo) {  
        this.pageNo = pageNo;  
    }  
  
    @Override  
    public Iterator<T> iterator() {
        return getContent().iterator();  
    }  
}  