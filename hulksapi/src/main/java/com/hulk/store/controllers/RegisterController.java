package com.hulk.store.controllers;

import java.util.List;

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
		Darkex darkex = darkexService.findId(darkex_id);		
		
		if(darkex!=null) 			
		{
			List<Register> regs =darkex.getRegisters();
			Register reg = null;
			if(regs.size()>0)
			{
				reg = regs.get(regs.size()-1);		
			}
				
			register = calculateRegister(register, reg);			
			
			register.setDarkex(darkex);
			return registerService.save(register);
		}
		return null;		
	}
	
	public Register calculateRegister(Register newReg, Register lastReg) 
	{
		switch (newReg.getOperation()) 
		{
			//ENTRADA-COMPRA
			case 1:
				
				if(lastReg!=null) {
					newReg.setValEntrada(newReg.getUnitVal() * newReg.getCantEntrada());
					int cantSaldo = lastReg.getCantSaldo() + newReg.getCantEntrada();
					int valSaldo = lastReg.getValSaldo() + newReg.getValEntrada();
					newReg.setCantSaldo(cantSaldo);
					newReg.setValSaldo(valSaldo);	
					newReg.setUnitVal(valSaldo/cantSaldo);
				}else {
					newReg.setValEntrada(newReg.getUnitVal() * newReg.getCantEntrada());
					newReg.setCantSaldo(newReg.getCantEntrada());
					newReg.setValSaldo(newReg.getValEntrada());	
				}
			break;
			
			//SALIDA-VENTA
			case 2:				
				newReg.setValSalida(newReg.getCantSalida() * lastReg.getUnitVal());
				if(lastReg!=null) {
					int cantSaldo = lastReg.getCantSaldo() - newReg.getCantSalida();
					int valSaldo = lastReg.getValSaldo() - newReg.getValSalida();
					newReg.setCantSaldo(cantSaldo);
					newReg.setValSaldo(valSaldo);					
					newReg.setUnitVal(lastReg.getUnitVal());
				}
			break;
			
			//DEVOLUCION ENTRADA-COMPRA
			case 3:
				newReg.setValEntrada(newReg.getUnitVal() * newReg.getCantEntrada());
				if(lastReg!=null) {
					int cantSaldo = lastReg.getCantSaldo() - newReg.getCantEntrada();
					int valSaldo = lastReg.getValSaldo() - newReg.getValEntrada();
					newReg.setCantSaldo(cantSaldo);
					newReg.setValSaldo(valSaldo);					
					newReg.setUnitVal(valSaldo/cantSaldo);
				}
			break;
			
			//DEVOLUCION SALIDA-VENTA
			case 4:
				newReg.setValSalida(newReg.getUnitVal() * newReg.getCantSalida());
				if(lastReg!=null) {
					int cantSaldo = lastReg.getCantSaldo() + newReg.getCantSalida();
					int valSaldo = lastReg.getValSaldo() + newReg.getValSalida();
					newReg.setCantSaldo(cantSaldo);
					newReg.setValSaldo(valSaldo);					
					newReg.setUnitVal(valSaldo/cantSaldo);
				}
			break;

		default:
			break;
		}
		
		return newReg;
	}

}
