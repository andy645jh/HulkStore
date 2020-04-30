package com.hulk.store.unit_test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.hulk.store.controllers.ProccessRegister;
import com.hulk.store.entity.Register;

public class ProcessRegisterTest 
{
	private ProccessRegister proccess;
	
	@Test
	public void GetLastRegister()
	{
		List<Register> list = new ArrayList();
		list.add(new Register());
		
		proccess = new ProccessRegister(list);
		Register reg = proccess.calculateNewRegister(new Register());
		assertThat(reg.getId()).isNull();		
	}
}
