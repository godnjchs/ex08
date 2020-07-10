package org.zerox.ex08.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerox.ex08.domain.BoardVo;
import org.zerox.ex08.service.BoardService;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/board/*")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	

	
	@GetMapping("/list")
	public void list(Model model) {
		
		System.out.println("info ..." + boardService.getList());
		model.addAttribute("list",boardService.getList());
		
	}
	
	@PostMapping("/register")
	public String register(BoardVo vo,RedirectAttributes rttr) {
		boardService.register(vo);
//		new BoardVo(12,"register", "registerContent","registerWriter")
		rttr.addFlashAttribute("result",vo.getBno());
		return "redirect:/board/list";
		
		
	}
	
	@GetMapping("/getOne")
	public void getOne(int bno,Model model) {
		model.addAttribute("vo",boardService.getOne(bno));
		
		
		
	}
	
	@PostMapping("/update")
	public String update(BoardVo vo,Model model) {
		boardService.update(vo);
		model.addAttribute(boardService.getList());
		return "redirect:/board/list";
	}
	
	@PostMapping("/delete")
	public String delete(int bno,RedirectAttributes rttr) {
		
		if(boardService.delete(bno)) {
			boardService.delete(bno);
			rttr.addFlashAttribute("result","success");
		}
		rttr.addFlashAttribute("result","fail");
		return "redirect:/board/list";
	}
	@RequestMapping("/goRegister")
	public String goReg() {
		return "/board/inputForm";
	}
	@RequestMapping("/updateForm")
	public String updateForm() {
		
		return "/board/updateForm";
	}
	@GetMapping("/test")
	public void test(int bno) {
		System.out.println("********************************" + bno);
	}
	
	


	
	
}
