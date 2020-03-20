package com.hulk.store.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hulk.store.entity.Register;
import com.hulk.store.repository.RegisterRepository;

@Service
public class RegisterService implements IRegisterService{
	@Autowired
    private RegisterRepository repository;

    @Override
    public List<Register> findAll() {

        return (List<Register>) repository.findAll();
    }
    
    public Register save(Register p)    
    {
    	return repository.save(p);
    }
    
    public Register findId(Long id)
    {
    	return repository.findById(id).get();
    }   

    
    public void deleteId(Long id)
    {
    	repository.deleteById(id);    	
    }
}