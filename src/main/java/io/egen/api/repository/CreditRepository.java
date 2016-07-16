package io.egen.api.repository;

import java.util.List;

import io.egen.api.entity.Credit;


public interface CreditRepository {

	public List<Credit> findAll();

	public Credit findOne(String id);

	public Credit findById(String id);

	public Credit create(Credit credit);

	public Credit update(Credit credit);

	public void delete(Credit credit);
}
