package io.egen.api.service;

import java.util.List;

import io.egen.api.entity.IMDBDetails;


public interface IMDBDetailsService {

	public List<IMDBDetails> findAll();

	public IMDBDetails findOne(String id);

	public IMDBDetails create(IMDBDetails imdbDetail);

	public IMDBDetails update(String id, IMDBDetails imdbDetail);

	public void delete(String id);
}
