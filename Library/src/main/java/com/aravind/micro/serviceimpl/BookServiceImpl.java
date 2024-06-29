package com.aravind.micro.serviceimpl;

import java.util.List;


import org.springframework.stereotype.Service;

import com.aravind.micro.model.Book;
import com.aravind.micro.repository.BookRepo;
import com.aravind.micro.service.BookService;


@Service
public class BookServiceImpl implements BookService {
	

	BookRepo brepo;
	
	static final String SUCCESS = "Success";
	 static final String FAILURE = "Failure";
	
	

	public BookRepo getBrepo() {
		return brepo;
	}

	public void setBrepo(BookRepo brepo) {
		this.brepo = brepo;
	}

	@Override
	public String addBook(Book book) {
		brepo.save(book);
		return SUCCESS;
		
	}

	@Override
	public Book getBook(int bid) {
		return brepo.findById(bid);
	}

	@Override
	public List<Book> getAllBook() {
		return brepo.findAllBooks();
	}

	
	@Override
	public String updateBook(Book book) {
		brepo.update(book);
		return SUCCESS;
		
	}

	@Override
	public String deleteBook(int bid) {
		brepo.delete(bid);
		return SUCCESS;
		
	}

}
