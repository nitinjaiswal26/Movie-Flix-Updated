package io.egen.api.service;

import java.util.List;

import io.egen.api.entity.Credit;


public interface CreditService {

	public List<Credit> findAll();

	public Credit findOne(String id);

	public Credit create(Credit credit);

	public Credit update(String id, Credit credit);

	public void delete(String id);
}
