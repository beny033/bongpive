package com.bongpive.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bongpive.domain.BoardSearch;
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
	public List<BoardVO> list(BoardSearch search) {
		return session.selectList("board.list", search);
	}

	@Override
	public BoardVO read(int seq) {
		return session.selectOne("board.read", seq);
	}

	@Override
	public int getPassword(int seq) {
		return session.selectOne("board.password", seq);
	}

	@Override
	public void remove(int seq) {
		session.delete("board.remove", seq);
	}

	@Override
	public void modify(BoardVO board) {
		session.update("board.modify", board);
	}

	@Override
	public int totalPosts(BoardSearch search) {
		return session.selectOne("board.totalPosts", search);
	}


}
