package io.egen.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.egen.api.entity.IMDBDetails;
import io.egen.api.service.IMDBDetailsService;


@RestController
@RequestMapping("/IMDBDetails")
public class IMDBDetailsController {

	@Autowired
	private IMDBDetailsService service;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<IMDBDetails> findAll() {
		return service.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public IMDBDetails findOne(@PathVariable("id") String movieid) {
		return service.findOne(movieid);
	}

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public IMDBDetails create(@RequestBody IMDBDetails imdb) {
		return service.create(imdb);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public IMDBDetails update(@PathVariable("id") String imdbid, @RequestBody IMDBDetails imdb) {
		return service.update(imdbid, imdb);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public void delete(@PathVariable("id") String imdbid) {
		service.delete(imdbid);
	}
}
