package io.egen.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.api.entity.Movie;
import io.egen.api.exception.MovieAlreadyExistException;
import io.egen.api.exception.MovieNotFound;
import io.egen.api.repository.MovieRepository;

@Service
@Transactional
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository repository;

	@Override
	public List<Movie> findAll() {
		return repository.findAll();
	}

	@Override
	public Movie findOne(String id) {
		Movie existing = repository.findOne(id);
		if (existing == null) {
			throw new MovieNotFound("Movie with id=" + id + " not found");
		}
		return existing;
	}

	@Override
	public Movie create(Movie movie) {
		Movie existing = repository.findById(movie.getId());
		if (existing != null) {
			throw new MovieAlreadyExistException("Movie with Id already exists");
		}
		return repository.create(movie);
	}

	@Override
	public Movie update(String id, Movie movie) {
		Movie existing = repository.findOne(id);
		if (existing == null) {
			throw new MovieNotFound("Movie with id=" + id + " not found");
		}
		return repository.update(movie);
	}

	@Override
	public void delete(String id) {
		Movie existing = repository.findOne(id);
		if (existing == null) {
			throw new MovieNotFound("Movie with id=" + id + " not found");
		}
		repository.delete(existing);
	}
}
