package com.hulk.store.controllers;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
import com.hulk.store.utils.Rules;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,RequestMethod.PUT })
public class RegisterController 
{
	
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
	public ResponseEntity<Register> create(@RequestBody Register register, @PathVariable long darkex_id)
	{
		System.out.println("Id: "+darkex_id);
		Darkex darkex = darkexService.findId(darkex_id);		
		
		if(Rules.isValidKardex(darkex) && Rules.isValidRegister(register) ) 			
		{
			List<Register> regs = darkex.getRegisters();
			ProccessRegister pR = new ProccessRegister( regs );
			register = pR.calculateNewRegister( register );			
			
			register.setDarkex(darkex);
			Register regCreated = registerService.save(register);
			
			if(regCreated == null)
			{
				return new ResponseEntity<Register>(HttpStatus.UNPROCESSABLE_ENTITY);
			}
			return new ResponseEntity<Register>(regCreated, HttpStatus.OK);	
			
		}else {
			return new ResponseEntity<Register>(HttpStatus.UNPROCESSABLE_ENTITY);
		}	
				
	}
}
