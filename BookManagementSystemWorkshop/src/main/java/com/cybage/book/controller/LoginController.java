package com.cybage.book.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cybage.book.model.User;
import com.cybage.book.service.BookService;
import com.cybage.book.service.UserService;

@RestController
@RequestMapping("/bookManagement")
public class LoginController {
	@Autowired
	private UserService userService;
	@Autowired
	private BookService bookService;
	
	@GetMapping("/login")
	public ModelAndView login(@Valid @ModelAttribute User user,BindingResult result) {
		if(result.hasErrors())
			return new ModelAndView("login","user",user);
		userService.login(user.getUsername(),user.getPassword());
		return new ModelAndView("book","bookList",bookService.getBooks());
	}
	
//	@GetMapping("/logout/{userId}")
//	public ModelAndView logout(@Valid @ModelAttribute User user) {
//			return new ModelAndView("login","user",user);
//	}

}
