package io.egen.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.api.entity.Credit;
import io.egen.api.entity.Movie;
import io.egen.api.exception.MovieAlreadyExistException;
import io.egen.api.exception.MovieNotFound;
import io.egen.api.repository.CreditRepository;
import io.egen.api.repository.MovieRepository;

@Service
@Transactional
public class CreditServiceImpl implements CreditService {

	@Autowired
	private CreditRepository repository;

	@Override
	public List<Credit> findAll() {
		return repository.findAll();
	}

	@Override
	public Credit findOne(String id) {
		Credit existing = repository.findOne(id);
		if (existing == null) {
			throw new MovieNotFound("Movie with id=" + id + " not found");
		}
		return existing;
	}

	@Override
	public Credit create(Credit credit) {
		Credit existing = repository.findById(credit.getId());
		if (existing != null) {
			throw new MovieAlreadyExistException("Credit with Id already exists");
		}
		return repository.create(credit);
	}

	@Override
	public Credit update(String id, Credit credit) {
		Credit existing = repository.findOne(id);
		if (existing == null) {
			throw new MovieNotFound("Credit with id=" + id + " not found");
		}
		return repository.update(credit);
	}

	@Override
	public void delete(String id) {
		Credit existing = repository.findOne(id);
		if (existing == null) {
			throw new MovieNotFound("Credit with id=" + id + " not found");
		}
		repository.delete(existing);
	}
}
