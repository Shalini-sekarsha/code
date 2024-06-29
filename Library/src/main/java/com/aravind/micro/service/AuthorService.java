package com.aravind.micro.service;

import java.util.List;

import com.aravind.micro.model.Author;

public interface AuthorService  {

	
    public String addAuthor(Author au);
    public String updateAuthor(Author au);
	public String deleteAuthor(int aid);
	public List<Author> getAllAuthor();
	public List<Integer> getIdList();
	public Author getAuthor(int aid);
	
}
