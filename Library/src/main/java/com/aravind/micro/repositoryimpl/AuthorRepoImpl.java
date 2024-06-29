package com.aravind.micro.repositoryimpl;

import java.util.List;


import org.springframework.stereotype.Repository;

import com.aravind.micro.model.Author;
import com.aravind.micro.repository.AuthorRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class AuthorRepoImpl implements AuthorRepo {
	
	
	EntityManager em;
	
	

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public void save(Author au) {
		em.persist(au);
		
	}

	@Override
	public List<Author> findAllAuthors() {
		String hql = "from Author";
		Query query = em.createQuery(hql);
		return query.getResultList();
	}

	@Override
	public List<Integer> getIdList() {
		String hql = "select aid from Author";
		
		Query q = em.createQuery(hql);
		return q.getResultList();
	}

	@Override
	public void update(Author au) {
		em.merge(au);
		
	}

	@Override
	public void delete(int aid) {
		Author id = em.find(Author.class, aid);
		em.remove(id);
		
	}

	@Override
	public Author findById(int aid) {
		return em.find(Author.class, aid);
	}
	

}
