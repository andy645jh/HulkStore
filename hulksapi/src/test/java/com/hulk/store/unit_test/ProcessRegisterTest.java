package com.hulk.store.unit_test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.hulk.store.controllers.ProccessRegister;
import com.hulk.store.entity.Register;
import com.hulk.store.integration_test.RegisterTest.Operation;

public class ProcessRegisterTest 
{
	private ProccessRegister proccess;
	
	@Test
	public void GetLastRegisterTest_ListWithEmptyRegister()
	{
		List<Register> list = new ArrayList();
		list.add(new Register());
		
		// lista con registro sin valores
		proccess = new ProccessRegister(list);
		Register reg = proccess.GetLastRegister();
		assertThat(reg).isNull();					
		
	}
	
	@Test
	public void GetLastRegisterTest_ListNull()
	{
		List<Register> list = new ArrayList();
		list.add(new Register());		
	
		// lista nula
		proccess = new ProccessRegister(null);
		Register reg = proccess.GetLastRegister();
		assertThat(reg).isNull();	
	}
	
	@Test
	public void GetLastRegisterTest_ValidRegister()
	{
		List<Register> list = new ArrayList();
		Register r = new Register();
		r.setOperation(Operation.COMPRA.intValue);
		r.setCantEntrada(10);
		r.setUnitVal(2000);
		r.setCantSalida(20000);
		r.setId(2L);
		list.add(r);		
	
		// lista nula
		proccess = new ProccessRegister(list);
		Register reg = proccess.GetLastRegister();
		assertThat(reg).isEqualTo(r);	
	}
	
	@Test
	public void GetLastRegisterTest_MultiplesRegister()
	{
		List<Register> list = new ArrayList();
		Register r = new Register();
		r.setOperation(Operation.COMPRA.intValue);
		r.setCantEntrada(10);
		r.setUnitVal(2000);
		r.setCantSaldo(20000);
		r.setId(2L);
		list.add(r);		
	
		Register r2 = new Register();
		r2.setOperation(Operation.VENTA.intValue);
		r2.setCantSalida(5);
		r2.setUnitVal(2000);
		r2.setCantSaldo(10000);
		r2.setId(3L);
		list.add(r2);
		
		// lista nula
		proccess = new ProccessRegister(list);
		Register reg = proccess.GetLastRegister();
		assertThat(reg).isEqualTo(r2);	
		
	}
	
	@Test
	public void CalculateNewRegisterTest_Compras()
	{
		// first register
		List<Register> list = new ArrayList();
		Register r = new Register();
		r.setDescription("Compra #1");
		r.setOperation(Operation.COMPRA.intValue);
		r.setCantEntrada(10);
		r.setUnitVal(2000);		
		r.setId(2L);
		//list.add(r);					
		
		proccess = new ProccessRegister(list);
		Register reg = proccess.calculateNewRegister(r);
		list.add(reg);
		assertThat(reg.getValSaldo()).isEqualTo(20000);
		assertThat(reg.getCantSaldo()).isEqualTo(10);
		
		
		Register r2 = new Register();
		r.setDescription("Compra #2");
		r2.setOperation(Operation.COMPRA.intValue);
		r2.setCantEntrada(5);
		r2.setUnitVal(1500);
		r2.setId(3L);
		
		reg = proccess.calculateNewRegister(r2);
		list.add(reg);
		assertThat(reg.getValSaldo()).isEqualTo(27500);
		assertThat(reg.getCantSaldo()).isEqualTo(15);
		assertThat(reg.getUnitVal()).isGreaterThan(0);
		assertThat(reg.getUnitVal()).isEqualTo(27500/15);
	}
	
	@Test
	public void CalculateNewRegisterTest_Ventas()
	{
		// primer registro debe ser una compra
		List<Register> list = new ArrayList();
		Register r = new Register();
		r.setDescription("Compra #1");
		r.setOperation(Operation.COMPRA.intValue);
		r.setCantEntrada(10);
		r.setUnitVal(2000);		
		r.setId(2L);
		list.add(r);	
		
		proccess = new ProccessRegister(list);
		Register reg = proccess.calculateNewRegister(r);
						
		
		//registro con igual precio unitario
		Register r2 = new Register();
		r.setDescription("Venta #1");
		r2.setOperation(Operation.VENTA.intValue);
		r2.setCantSalida(5);
		r2.setUnitVal(2000);
		r2.setId(3L);		
		
		reg = proccess.calculateNewRegister(r2);
		
		assertThat(reg.getValSaldo()).isEqualTo(10000);
		assertThat(reg.getCantSaldo()).isEqualTo(5);
		assertThat(reg.getUnitVal()).isGreaterThan(0);		
		assertThat(reg.getUnitVal()).isEqualTo(10000/5);
	}
	
	@Test
	public void CalculateNewRegisterTest_DevolucionVenta()
	{
		// primer registro debe ser una compra
		List<Register> list = new ArrayList();
		Register r = new Register();
		r.setDescription("Compra #1");
		r.setOperation(Operation.COMPRA.intValue);
		r.setCantEntrada(10);
		r.setUnitVal(2000);		
		r.setId(2L);
		list.add(r);	
		
		proccess = new ProccessRegister(list);
		Register reg = proccess.calculateNewRegister(r);						
		
		//registro de venta
		Register r2 = new Register();
		r2.setDescription("Venta #1");
		r2.setOperation(Operation.VENTA.intValue);
		r2.setCantSalida(5);
		r2.setUnitVal(2000);
		r2.setId(3L);				
		
		reg = proccess.calculateNewRegister(r2);
		list.add(reg);
		
		
		//registro de devolucion venta
		Register r3 = new Register();
		r3.setDescription("Dev Venta #1");
		r3.setOperation(Operation.DEVOLUCION_VENTA.intValue);
		r3.setCantSalida(3);
		r3.setUnitVal(2000);
		r3.setId(4L);		
				
		reg = proccess.calculateNewRegister(r3);
		
		assertThat(reg.getValSaldo()).isEqualTo(16000);
		assertThat(reg.getCantSaldo()).isEqualTo(8);
		assertThat(reg.getUnitVal()).isGreaterThan(0);		
		assertThat(reg.getUnitVal()).isEqualTo(2000);
	}
	
	@Test
	public void CalculateNewRegisterTest_DevolucionCompra()
	{
		// primer registro debe ser una compra
		List<Register> list = new ArrayList();
		Register r = new Register();
		r.setDescription("Compra #1");
		r.setOperation(Operation.COMPRA.intValue);
		r.setCantEntrada(10);
		r.setUnitVal(2000);		
		r.setId(2L);
			
		
		proccess = new ProccessRegister(list);
		Register reg = proccess.calculateNewRegister(r);						
		list.add(r);
		
		//registro de compra
		Register r2 = new Register();
		r2.setDescription("Compra #2");
		r2.setOperation(Operation.COMPRA.intValue);
		r2.setCantEntrada(5);
		r2.setUnitVal(1500);
		r2.setId(3L);				
		
		reg = proccess.calculateNewRegister(r2);
		list.add(reg);
		
		
		//registro de devolucion compra
		Register r3 = new Register();
		r3.setDescription("Dev Compra #1");
		r3.setOperation(Operation.DEVOLUCION_COMPRA.intValue);
		r3.setCantEntrada(3);
		r3.setUnitVal(2000);
		r3.setId(4L);		
				
		reg = proccess.calculateNewRegister(r3);
		
		assertThat(reg.getValSaldo()).isEqualTo(21500);
		assertThat(reg.getCantSaldo()).isEqualTo(12);
		assertThat(reg.getUnitVal()).isGreaterThan(0);		
		assertThat(reg.getUnitVal()).isEqualTo(21500/12);
	}
}
