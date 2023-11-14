package com.multi.mvc03;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {
	
	@Autowired
	BookDAO dao;
	
	@RequestMapping("list") //list
	public void list(Model model) {
		List<BookDTO> list = dao.list();
		model.addAttribute("list", list);
	}
	
	@RequestMapping("one") //one?id=4
	public void one(String id, Model model) {
		BookDTO dto = dao.one(id);
		//views/one.jsp로 dto를 보내서 출력해야한다. 
		//model이라고 하는 객체가 필요!
		model.addAttribute("dto", dto);
	}
	
	
	@RequestMapping("update")
	public String update(BookDTO dto) {
		int result = dao.update(dto);
		if(result == 1) {
			return "update";
		}else {
			return "redirect:index.jsp";
		}
	}
	
	//요청하나당 함수하나!!!
	@RequestMapping("insert")
	public String insert(BookDTO dto) {
		int result = dao.insert(dto);
		if(result == 1) {
			return "insert";
		}else {
			return "redirect:index.jsp";
		}
	}
}
