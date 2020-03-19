package com.hulk.store.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hulk.store.entity.Darkex;
import com.hulk.store.services.IDarkexServices;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,RequestMethod.PUT })
public class DarkexController {
	@Autowired
	private IDarkexServices darkexService;

	@RequestMapping(value = "/darkex", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Darkex> findAll() {

		return darkexService.findAll();
	}
	
	@RequestMapping(value = "/darkex", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Darkex create(@RequestBody Darkex darkex) {

		return darkexService.save(darkex);
	}
}
