package com.aravind.micro.serviceimpl;

import java.util.List;


import org.springframework.stereotype.Service;

import com.aravind.micro.model.Author;
import com.aravind.micro.repository.AuthorRepo;
import com.aravind.micro.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {

	
	AuthorRepo arepo;
	
	static final String SUCCESS = "Success";
	 static final String FAILURE = "Failure";
	
	public AuthorRepo getArepo() {
		return arepo;
	}

	public void setArepo(AuthorRepo arepo) {
		this.arepo = arepo;
	}

	@Override
	public String addAuthor(Author au) {
		arepo.save(au);
		return SUCCESS;
		
	}

	@Override
	public List<Author> getAllAuthor() {
		return arepo.findAllAuthors();
	}

	@Override
	public List<Integer> getIdList() {
		return arepo.getIdList();
		
	}

	@Override
	public String updateAuthor(Author au) {
		arepo.update(au);
		return SUCCESS;
		
	}

	@Override
	public String deleteAuthor(int aid) {
		arepo.delete(aid);
		return SUCCESS;
		
	}


	@Override
	public Author getAuthor(int aid) {
		return arepo.findById(aid);
	}
	

}
