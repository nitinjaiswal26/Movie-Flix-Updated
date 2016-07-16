package io.egen.api.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.egen.api.entity.IMDBDetails;
import io.egen.api.entity.Movie;

@Repository
public class IMDBDetailsRepositoryImpl implements IMDBDetailsRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<IMDBDetails> findAll() {
		TypedQuery<IMDBDetails> query = em.createQuery("select i from IMDBDetails i", IMDBDetails.class);
		return query.getResultList();
	}

	@Override
	public IMDBDetails findOne(String id) {
		return em.find(IMDBDetails.class, id);
	}

	@Override
	public IMDBDetails create(IMDBDetails imdb) {
		em.persist(imdb);
		return imdb;
	}

	@Override
	public IMDBDetails update(IMDBDetails imdb) {
		return em.merge(imdb);
	}

	@Override
	public void delete(IMDBDetails imdb) {
		em.remove(imdb);
	}

	@Override
	public IMDBDetails findById(String id) {
		TypedQuery<IMDBDetails> query = em.createNamedQuery("IMDBDetails.findById", IMDBDetails.class);
		query.setParameter("pid", id);
		List<IMDBDetails> imdb = query.getResultList();
		if (imdb != null && imdb.size() == 1) {
			return imdb.get(0);
		} else {
			return null;
		}
	}
}
