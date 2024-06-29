package com.aravind.micro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aravind.micro.model.Book;
import com.aravind.micro.serviceimpl.BookServiceImpl;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/book")
@CrossOrigin("http://localhost:3000")
public class BookController {
	
	@Autowired
	BookServiceImpl service;
	
	static final String SUCCESS = "Success";
	 static final String FAILURE = "Failure";
	
	@PostMapping
	public String insertBook(@RequestBody Book book) {
		
		String msg = "";
		
		try {
			service.addBook(book);
			msg = SUCCESS;
		}
		catch(Exception e) {
			msg = FAILURE;
		}
		
		return msg;
	}
	
	@GetMapping("{bid}")
	public Book getBookById(@PathVariable("bid") int id) {
		
		return service.getBook(id);
	}
	
	@GetMapping("/all")
	public List<Book> getBooks() {
		
		return service.getAllBook();
	}
	
	@PutMapping
	public String updateBook(@RequestBody Book book) {
	String msg = "";
	
	try {
		service.updateBook(book);
		msg = SUCCESS;
	}
	catch(Exception e) {
		msg = FAILURE;
	}
	
	return msg;
}
	
	@DeleteMapping("{bid}")
	public String deleteBookById(@PathVariable("bid") int id) {
		String msg = "";
		
		try {
			service.deleteBook(id);
			msg = SUCCESS;
		}
		catch(Exception e) {
			msg = FAILURE;
		}
		
		return msg;
		
	}
	

}
