package com.acma.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.PagedResources.PageMetadata;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.time.LocalDateTime;

import com.acma.app.domain.Board;
import com.acma.app.service.BoardService;

@RestController
@RequestMapping("/api/boards")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	
	/*
	 * 목록조회
	 */
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getBoards(@PageableDefault(sort = "idx", direction = Direction.DESC) Pageable pageable) throws Exception {
		Page<Board> boards = boardService.findAll(pageable);
		// HATEOAS 주입
		//PageMetadata pageMetadata = new PageMetadata(size, number, totalElements)
		PageMetadata pageMetadata = new PageMetadata(pageable.getPageSize(), boards.getNumber(), boards.getTotalElements());
		PagedResources<Board> resources = new PagedResources<>(boards.getContent(), pageMetadata);
		resources.add(linkTo(methodOn(BoardController.class).getBoards(pageable)).withSelfRel());
		return ResponseEntity.ok(resources);
	}
	
	
	/*
	 * 상세
	 */
	@GetMapping("/{idx}")
	public ResponseEntity<?> getBoard(@PathVariable("idx") Long idx, Model model) throws Exception {
		model.addAttribute("board", boardService.findBoardByIdx(idx));
		return ResponseEntity.ok(model);
	}
	
	
	/*
	 * 등록
	 */
	@PostMapping
	public ResponseEntity<?> postBoard(@RequestBody Board board) throws Exception {
		board.setCreatedDate(LocalDateTime.now());
		board.setUpdatedDate(LocalDateTime.now());
		boardService.postBoard(board);
		return new ResponseEntity<>("{}", HttpStatus.CREATED);
	}
	
	
	/*
	 * 수정
	 */
	@PutMapping("/{idx}")
	public ResponseEntity<?> putBoard(@PathVariable("idx") Long idx, @RequestBody Board board) throws Exception {
		Board updateBoard = boardService.findBoardByIdx(idx);
		updateBoard.setTitle(board.getTitle());
		updateBoard.setContent(board.getContent());
		updateBoard.setUpdatedDate(LocalDateTime.now());
		boardService.postBoard(updateBoard);
		return new ResponseEntity<>("{}", HttpStatus.OK);
	}
	
	
	/*
	 * 삭제
	 */
	@DeleteMapping("/{idx}")
	public ResponseEntity<?> deleteBoard(@PathVariable("idx") Long idx) throws Exception {
		boardService.deleteBoard(idx);
		return new ResponseEntity<>("{}", HttpStatus.OK);
	}
}
