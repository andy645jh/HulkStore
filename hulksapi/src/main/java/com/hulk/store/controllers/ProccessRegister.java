package com.hulk.store.controllers;

import com.hulk.store.entity.Register;

public class ProccessRegister 
{
	
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
