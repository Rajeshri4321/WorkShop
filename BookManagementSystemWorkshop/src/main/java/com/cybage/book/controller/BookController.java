package com.cybage.book.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cybage.book.model.Book;
import com.cybage.book.service.BookService;

@RestController
@RequestMapping("/bookManagement")
public class BookController {
	
	@Autowired
	private BookService bookService;

	@GetMapping("/showbooks")
	public ModelAndView getAllTutorial() {

		List<Book> bookList = bookService.getBooks();

		return new ModelAndView("book", "bookList", bookList);
	}

	@GetMapping("/addBook")
	public ModelAndView showForm() {
		Book book = new Book();

		return new ModelAndView("addBook", "book", book);
	}

	@PostMapping("/")
	public ModelAndView addTutorial(@Valid @ModelAttribute Book book, BindingResult result) {
		if (result.hasErrors())
			return new ModelAndView("addBook", "book", book);
		bookService.addBook(book);
		return new ModelAndView("book", "bookList", bookService.getBooks());
	}

	@GetMapping("/deleteBook/{id}")
	public ModelAndView deleteBook(@PathVariable int id) {
		bookService.deleteBook(id);
		return new ModelAndView("book", "bookList", bookService.getBooks());
	}

	@GetMapping("/editBook/{id}")
	public ModelAndView showEditForm(@PathVariable int id) {
		Book book = bookService.getBookById(id);
		return new ModelAndView("editBook", "book", book);
	}

	@PostMapping("/editBook/")
	public ModelAndView editTutorial(@Valid @ModelAttribute Book book, BindingResult result) {
		if (result.hasErrors()) {
			return new ModelAndView("editBook", "book", book);
		} else {
			bookService.editBook(book);
			return new ModelAndView("book", "bookList", bookService.getBooks());
		}
	}

}
