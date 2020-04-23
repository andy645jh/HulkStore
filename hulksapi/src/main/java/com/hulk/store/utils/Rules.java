package com.hulk.store.utils;

import com.hulk.store.entity.Darkex;
import com.hulk.store.entity.Register;

public class Rules {
	public static boolean isValidRegister(Register reg)
	{
		boolean opIsValid = reg.getOperation() > 0 && reg.getOperation() < 5;
		return (reg != null && (reg.getCantEntrada()>0 || reg.getCantSalida()>0) && reg.getUnitVal()>0 && opIsValid);
	}
	
	public static boolean isValidKardex(Darkex kardex)
	{				
		return (kardex != null && kardex.getProveedores() != null && 
				kardex.getProductName() != null &&
				!kardex.getProductName().isEmpty() && 
				!kardex.getProveedores().isEmpty() );
	}
}
