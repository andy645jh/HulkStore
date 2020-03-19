package com.hulk.store.services;

import java.util.List;

import com.hulk.store.entity.Register;


public interface IRegisterService {
	List<Register> findAll();
	Register findId(Long id);
    void deleteId(Long id);
    Register save(Register p);  
}