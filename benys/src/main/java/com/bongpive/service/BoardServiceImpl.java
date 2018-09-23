package com.bongpive.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bongpive.domain.BoardVO;
import com.bongpive.persistence.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO dao;
	
	@Override
	public void register(BoardVO board) {
		dao.register(board);
	}
	
	@Override
	public List<BoardVO> list() {
		return dao.list();
	}

	@Override
	public BoardVO read(int seq) {
		return dao.read(seq);
	}

}
