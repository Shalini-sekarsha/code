package com.aravind.micro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aravind.micro.model.Author;
import com.aravind.micro.serviceimpl.AuthorServiceImpl;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/author")
@CrossOrigin("http://localhost:3000")
public class AuthorController {
	
	@Autowired
	AuthorServiceImpl service;
	
	static final String SUCCESS = "Success";
	static final String FAILURE = "Failure";
	
	@PostMapping
	public String insertAuthor(@RequestBody Author au) {

		String msg = "";
		
		try {
			service.addAuthor(au);
			msg = SUCCESS;
		}
		catch(Exception e) {
			msg = FAILURE;
		}
		
		return msg;
	}
	
	@GetMapping("{aid}")
	public Author getAuthorById(@PathVariable("aid") int id) {
		
		return service.getAuthor(id);
	}
	
	@GetMapping("/all")
	public List<Author> getAuthors() {
		
		return service.getAllAuthor();
	}
	
	@PutMapping
	public String updateAuthor(@RequestBody Author au) {
	String msg = "";
	
	try {
		service.updateAuthor(au);
		msg = SUCCESS;
	}
	catch(Exception e) {
		msg = FAILURE;
	}
	
	return msg;
}
	@GetMapping("/idlist")
	public List<Integer> getIdList() {
		
		return service.getIdList();
	}
	
	@DeleteMapping("{aid}")
	public String deleteAuthorById(@PathVariable("aid") int id) {
		String msg = "";
		
		try {
			service.deleteAuthor(id);
			msg = SUCCESS;
		}
		catch(Exception e) {
			msg = FAILURE;
		}
		
		return msg;
		
	}
	

}
