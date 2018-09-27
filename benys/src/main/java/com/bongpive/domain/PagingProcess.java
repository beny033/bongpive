package com.bongpive.domain;

public class PagingProcess {

	private int totalPosts;		// 총 게시글
	private int totalPages;		// 페이지 수
	private int curruntPage;	// 현재페이지
	private int pageShown = 10;		// 보여지는 페이지
	private boolean prev;
	private boolean next;
	
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		
		next = (totalPosts / pageShown) >= 1 ? true : false;
		
		this.next = next;
	}
	public int getTotalPosts() {
		return totalPosts;
	}
	public void setTotalPosts(int totalPosts) {
		this.totalPosts = totalPosts;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
	
		if(totalPosts % 10 == 0) {
			totalPages = totalPosts / pageShown;
		} else {
			totalPages = (totalPosts / pageShown) + 1;
		}

		this.totalPages = totalPages;
	}
	
	public int getCurruntPage() {
		return curruntPage;
	}
	public void setCurruntPage(int curruntPage) {
		
		if(curruntPage <= 0) {
			curruntPage = 1;
		}
		curruntPage = (curruntPage - 1) * 10;
		
		this.curruntPage = curruntPage;
	}
	public int getPageShown() {
		return pageShown;
	}
	public void setPageShown(int pageShown) {
		
		if(pageShown <= 0) {
			pageShown = 10;
		}
		this.pageShown = pageShown;
	}
	
	
	
}
