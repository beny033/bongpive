package com.bongpive.persistence;

import java.util.List;

import com.bongpive.domain.BoardVO;

public interface BoardDAO {
	
	public void register(BoardVO board);
	
	public List<BoardVO> list();
	
	public BoardVO read(int seq);
	
	public int getPassword(int seq);
	
	public void remove(int seq);
	
	public void modify(BoardVO board);
}
