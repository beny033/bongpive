package com.bongpive.persistence;

import java.util.List;

import com.bongpive.domain.BoardVO;

public interface BoardDAO {
	
	public void register(BoardVO board);
	
	public List<BoardVO> list();
}
