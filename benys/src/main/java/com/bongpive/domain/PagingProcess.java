package com.bongpive.domain;

public class PagingProcess {

	private int totalPosts;		// 총 게시글
	private int curruntPage;	// 현재페이지
	private int postShown;		// 보여지는 페이지
	private int pagingShown;	// 보여지는 페이징
	private int startPage;
	private int endPage;

	private boolean previous;
	private boolean next;
	
	public PagingProcess() {
		this.curruntPage = 1;
		this.postShown = 10;
		this.pagingShown = 10;
	}

	public int getTotalPosts() {
		return totalPosts;
	}

	public void setTotalPosts(int totalPosts) {
		this.totalPosts = totalPosts;
		pageCalculation();
	}

	public int getCurruntPage() {
		return curruntPage;
	}

	public void setCurruntPage(int curruntPage) {
		this.curruntPage = curruntPage;
	}

	public int getPostShown() {
		return postShown;
	}

	public void setPostShown(int postShown) {
		this.postShown = postShown;
	}

	public int getPagingShown() {
		return pagingShown;
	}

	public void setPagingShown(int pagingShown) {
		this.pagingShown = pagingShown;
	}

	public boolean isPrevious() {
		return previous;
	}

	public void setPrevious(boolean previous) {
		this.previous = previous;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getPageStart() {
		return (this.curruntPage - 1) * this.postShown;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	
	public void pageCalculation() {
		
		endPage = (int)Math.ceil(curruntPage / (double)pagingShown) * pagingShown; 
		
		startPage = (endPage - pagingShown) + 1;
		
		previous = startPage == 1 ? false : true;

		if(endPage > totalPosts / 10) {
			if(totalPosts % 10 == 0) {
				endPage = totalPosts / 10;
				return;
			} 
			endPage = (totalPosts / 10) + 1;
		}
		
		next = (endPage * postShown) >= totalPosts ? false : true;		
		 
	}
	
}
