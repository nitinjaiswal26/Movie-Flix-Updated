package io.egen.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.api.entity.IMDBDetails;
import io.egen.api.entity.Movie;
import io.egen.api.exception.MovieAlreadyExistException;
import io.egen.api.exception.MovieNotFound;
import io.egen.api.repository.IMDBDetailsRepository;
import io.egen.api.repository.MovieRepository;

@Service
@Transactional
public class IMDBDetailsServiceImpl implements IMDBDetailsService {

	@Autowired
	private IMDBDetailsRepository repository;

	@Override
	public List<IMDBDetails> findAll() {
		return repository.findAll();
	}

	@Override
	public IMDBDetails findOne(String id) {
		IMDBDetails existing = repository.findOne(id);
		if (existing == null) {
			throw new MovieNotFound("IMDBDetails with id=" + id + " not found");
		}
		return existing;
	}

	@Override
	public IMDBDetails create(IMDBDetails imdb) {
		IMDBDetails existing = repository.findById(imdb.getId());
		if (existing != null) {
			throw new MovieAlreadyExistException("IMDBDetails with Id already exists");
		}
		return repository.create(imdb);
	}

	@Override
	public IMDBDetails update(String id, IMDBDetails imdb) {
		IMDBDetails existing = repository.findOne(id);
		if (existing == null) {
			throw new MovieNotFound("IMDBDetails with id=" + id + " not found");
		}
		return repository.update(imdb);
	}

	@Override
	public void delete(String id) {
		IMDBDetails existing = repository.findOne(id);
		if (existing == null) {
			throw new MovieNotFound("IMDBDetails with id=" + id + " not found");
		}
		repository.delete(existing);
	}
}
