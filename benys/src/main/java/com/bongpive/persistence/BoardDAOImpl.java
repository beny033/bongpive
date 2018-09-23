package com.bongpive.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bongpive.domain.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	private SqlSession session;
	
	@Override
	public void register(BoardVO board) {
		session.insert("board.register", board);
	}

	@Override
	public List<BoardVO> list() {
		return session.selectList("board.list");
	}

	@Override
	public BoardVO read(int seq) {
		return session.selectOne("board.read", seq);
	}


}
