package io.egen.api.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.egen.api.entity.Credit;
import io.egen.api.entity.Movie;

@Repository
public class CreditRepositoryImpl implements CreditRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Credit> findAll() {
		TypedQuery<Credit> query = em.createQuery("select c from Credit c", Credit.class);
		return query.getResultList();
	}

	@Override
	public Credit findOne(String id) {
		return em.find(Credit.class, id);
	}

	@Override
	public Credit create(Credit credit) {
		em.persist(credit);
		return credit;
	}

	@Override
	public Credit update(Credit credit) {
		return em.merge(credit);
	}

	@Override
	public void delete(Credit credit) {
		em.remove(credit);
	}

	@Override
	public Credit findById(String id) {
		TypedQuery<Credit> query = em.createNamedQuery("Credit.findById", Credit.class);
		query.setParameter("pid", id);
		List<Credit> credit = query.getResultList();
		if (credit != null && credit.size() == 1) {
			return credit.get(0);
		} else {
			return null;
		}
	}
}
