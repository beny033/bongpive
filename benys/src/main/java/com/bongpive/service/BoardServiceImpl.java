package com.bongpive.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bongpive.domain.BoardSearch;
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
	public List<BoardVO> list(BoardSearch search) {
		return dao.list(search);
	}

	@Override
	public BoardVO read(int seq) {
		return dao.read(seq);
	}

	@Override
	public int getPassword(int seq) {
		return dao.getPassword(seq);
	}

	@Override
	public void remove(int seq) {
		dao.remove(seq);
	}

	@Override
	public void modify(BoardVO board) {
		dao.modify(board);
	}

	@Override
	public int totalPosts(BoardSearch search) {
		return dao.totalPosts(search);
	}

}
