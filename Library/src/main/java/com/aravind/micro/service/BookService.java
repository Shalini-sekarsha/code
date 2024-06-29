package com.aravind.micro.service;

import java.util.List;

import com.aravind.micro.model.Book;

public interface BookService {
	

	
   public String addBook(Book book);
	public String updateBook(Book book);
	public String deleteBook(int bid);
	public List<Book> getAllBook();
	public Book getBook(int bid);
	
	


}
