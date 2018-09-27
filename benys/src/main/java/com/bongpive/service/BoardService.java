package com.bongpive.service;

import java.util.List;
import java.util.Map;

import com.bongpive.domain.BoardVO;

public interface BoardService {

	public void register(BoardVO board);
	
	public List<BoardVO> list(Map<String, Integer> map);
	
	public BoardVO read(int seq);
	
	public int getPassword(int seq);
	
	public void remove(int seq);

	public void modify(BoardVO board);
	
	public int totalPosts();
}
