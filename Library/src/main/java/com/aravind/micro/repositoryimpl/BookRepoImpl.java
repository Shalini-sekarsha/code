package com.aravind.micro.repositoryimpl;

import java.util.List;



import org.springframework.stereotype.Repository;

import com.aravind.micro.model.Book;
import com.aravind.micro.repository.BookRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class BookRepoImpl implements BookRepo {
	
	
	EntityManager em;
	

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public void save(Book book) {
		em.merge(book);
		
	}

	@Override
	public List<Book> findAllBooks() {
		String hql = "from Book";
		Query query = em.createQuery(hql);
		return query.getResultList();
	}

	@Override
	public void update(Book book) {
		em.merge(book);
		
	}
	
	@Override
	public Book findById(int bid) {
		return em.find(Book.class, bid);
	}


	@Override
	public void delete(int bid) {
	    Book id = em.find(Book.class, bid);
		em.remove(id);
	}


	

}
