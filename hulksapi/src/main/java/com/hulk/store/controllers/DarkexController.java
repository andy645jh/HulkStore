package com.hulk.store.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping(value = "/darkex/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Darkex find(@PathVariable Long id)
	{
		Darkex darkex = darkexService.findId(id);
		/*if(darkex==null)
		{
			return new ResponseEntity<>("Resource not found", HttpStatus.NOT_FOUND);
		}*/
		return darkex;
	}
	
	@RequestMapping(value = "/darkex/search/{word}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Darkex> find( @PathVariable String word)
	{
		return darkexService.search(word.toLowerCase());		
	}
	
	@RequestMapping(value = "/darkex/{id}", method = RequestMethod.DELETE)
	public boolean delete(@PathVariable Long id)
	{
		try {
			darkexService.deleteId(id);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
}
