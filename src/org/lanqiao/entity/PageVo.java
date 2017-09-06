package org.lanqiao.entity;

public class PageVo {
	private int pagesize;
	private int pageindex;
	
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getPageindex() {
		return pageindex;
	}
	public void setPageindex(int pageindex) {
		this.pageindex = pageindex;
	}
	public PageVo(int pagesize, int pageindex) {
		super();
		this.pagesize = pagesize;
		this.pageindex = pageindex;
	}
	@Override
	public String toString() {
		return "PageVo [pagesize=" + pagesize + ", pageindex=" + pageindex
				+ "]";
	}
	public PageVo() {
		super();
	}
	
	

}
