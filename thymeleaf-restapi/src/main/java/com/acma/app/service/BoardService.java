package com.acma.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.acma.app.domain.Board;
import com.acma.app.repository.BoardRepository;

@Service
public class BoardService {

	@Autowired
	private BoardRepository boardRepository;
	
	// HATEOAS 주입 방법으로 아래 findAll() method 사용.
	public Page<Board> findBoardList(Pageable pageable) throws Exception {
		pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber(), pageable.getPageSize(), pageable.getSort().descending());
		return boardRepository.findAll(pageable);
	}
	
	public Page<Board> findAll(Pageable pageable) throws Exception {
		return boardRepository.findAll(pageable);
	}
	
	public Board findBoardByIdx(Long idx) throws Exception {
		Board board = boardRepository.findById(idx).orElse(new Board());
		return board;
	}
	
	public void postBoard(Board board) throws Exception {
		boardRepository.save(board);
	}
	
	public void deleteBoard(Long idx) throws Exception {
		boardRepository.deleteById(idx);
	}
}