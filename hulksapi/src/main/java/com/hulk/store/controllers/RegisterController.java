package com.hulk.store.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hulk.store.entity.Register;
import com.hulk.store.services.IRegisterService;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,RequestMethod.PUT })
public class RegisterController {
	@Autowired
	private IRegisterService registerService;

	@RequestMapping(value = "/registers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Register> findAll(Model model) {

		return registerService.findAll();
	}

}
