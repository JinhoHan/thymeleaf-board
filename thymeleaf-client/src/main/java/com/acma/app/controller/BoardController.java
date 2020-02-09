package com.acma.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.acma.app.domain.Board;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@GetMapping("/list")
	public String list() throws Exception {
		return "/board/list";
	}
	
	@GetMapping({"", "/"})
	public String board(@RequestParam(value = "idx", defaultValue = "0") Long idx, Model model) throws Exception {
		if(idx != 0) {
			Board board = new Board();
			board.setIdx(idx);
			model.addAttribute("board", board);
		}
		return "/board/form";
	}
}
