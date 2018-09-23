package com.bongpive.service;

import java.util.List;

import com.bongpive.domain.BoardVO;

public interface BoardService {

	public void register(BoardVO board);
	
	public List<BoardVO> list();
	
	public BoardVO read(int seq);
}
