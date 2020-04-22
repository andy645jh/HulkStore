package com.hulk.store.controllers;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hulk.store.entity.Darkex;
import com.hulk.store.entity.Register;
import com.hulk.store.services.IDarkexServices;
import com.hulk.store.services.IRegisterService;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,RequestMethod.PUT })
public class RegisterController {
	@Autowired
	private IRegisterService registerService;
	
	@Autowired
	private IDarkexServices darkexService;
		
	
	@RequestMapping(value = "/registers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Register> findAll() {
		return registerService.findAll();
	}
	
	@RequestMapping(value = "/registers/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Register> findBy(@PathVariable Long id) {
		Darkex darkex = darkexService.findId(id);
		if(darkex!=null)
		{
			return darkex.getRegisters();
		}
		return null;
	}
	
	@RequestMapping(value = "/registers/{darkex_id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Register create(@RequestBody Register register, @PathVariable long darkex_id)
	{
		ProccessRegister pR = new ProccessRegister();
		Darkex darkex = darkexService.findId(darkex_id);		
		
		if(darkex!=null) 			
		{
			List<Register> regs =darkex.getRegisters();
			Register reg = null;
			if(regs.size()>0)
			{
				reg = regs.get(regs.size()-1);		
			}
				
			register = pR.calculateRegister(register, reg);			
			
			register.setDarkex(darkex);
			return registerService.save(register);
		}
		return null;		
	}
	
	

}
