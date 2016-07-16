package io.egen.api.repository;

import java.util.List;

import io.egen.api.entity.IMDBDetails;

public interface IMDBDetailsRepository {

	public List<IMDBDetails> findAll();

	public IMDBDetails findOne(String id);

	public IMDBDetails findById(String id);

	public IMDBDetails create(IMDBDetails imdb);

	public IMDBDetails update(IMDBDetails imdb);

	public void delete(IMDBDetails imdb);
}
