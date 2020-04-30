package com.hulk.store.unit_test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.hulk.store.entity.Darkex;
import com.hulk.store.entity.Register;
import com.hulk.store.integration_test.RegisterTest.Operation;
import com.hulk.store.utils.Rules;


public class RuleTest 
{
	private boolean setUpIsDone;
	private Register register;
	private Darkex kardex;
	
	@BeforeEach
	void setUp() throws Exception 
	{			
		
		kardex = new Darkex();
		kardex.setId(1L);
		kardex.setProductName("Camisa");
		kardex.setProveedores("Textiles");
		
	    register = new Register();
	    register.setCantEntrada(10);
	    register.setCantSalida(12);
	    register.setUnitVal(1000);
	    register.setOperation(Operation.VENTA.intValue);
	    register.setDate(new Date());
	    register.setId(2L);
	    register.setDarkex(kardex);
	    
	    System.out.println("Registro");
	}
	
	@Test
	public void ValidateRegisterEmpty()
	{		
		register = new Register();
		assertThat(Rules.isValidRegister(register)).isFalse();			
	}
	
	@Test
	public void ValidateRegisterCantEntrada()
	{		
		// se pasa a 0 la salida ya que se va a validar la entrada
		// por ser valores excluyentes, es decir, si hay entrada (compra)
		// no requiere salida, lo mismo pasa si es salida (venta)
		// no requiere entrada
		register.setCantSalida(0);		
		
		
		register.setCantEntrada(-1);		
		assertThat(Rules.isValidRegister(register)).isFalse();
		
		register.setCantEntrada(0);		
		assertThat(Rules.isValidRegister(register)).isFalse();	
	}
	
	@Test
	public void ValidateRegisterCantSalidaZero()
	{				
		register.setCantEntrada(0);		
		
		// cuando la salida es 0
		register.setCantSalida(0);		
		assertThat(Rules.isValidRegister(register)).isFalse();		
		
		//cuando la salida es negativa
		register.setCantSalida(-1);		
		assertThat(Rules.isValidRegister(register)).isFalse();	
	}
	
	@Test
	public void ValidateRegisterOperation()
	{		
		
		// operacion negativa
		register.setOperation(-1);
		assertThat(Rules.isValidRegister(register)).isFalse();		
		
		// operacion igual a 0
		register.setOperation(0);
		assertThat(Rules.isValidRegister(register)).isFalse();	
		
		// operacion mayor a 4
		register.setOperation(5);
		assertThat(Rules.isValidRegister(register)).isFalse();	
	}
	
	@Test
	public void ValidateRegisterUnitVal()
	{		
		
		// valor unitario negativo
		register.setUnitVal(-1);
		assertThat(Rules.isValidRegister(register)).isFalse();		
		
		// valor unitario igual a 0
		register.setUnitVal(0);
		assertThat(Rules.isValidRegister(register)).isFalse();		
		
	}
	
	@Test
	public void ValidateKardexEmptyOrNull()
	{					
		
		kardex = new Darkex();
		assertThat(Rules.isValidKardex(kardex)).isFalse();	
		
		kardex = null;
		assertThat(Rules.isValidKardex(kardex)).isFalse();
	}
	
	@Test
	public void ValidateKardexProperties()
	{		
		
		// productName vacio
		kardex.setProductName("");
		assertThat(Rules.isValidKardex(kardex)).isFalse();		
		
		// proveedores vacio
		kardex.setProveedores("");
		assertThat(Rules.isValidKardex(kardex)).isFalse();	
		
		
		// productName y proveedores vacio
		kardex.setProductName("");
		kardex.setProveedores("");
		assertThat(Rules.isValidKardex(kardex)).isFalse();	
			
	}
}
