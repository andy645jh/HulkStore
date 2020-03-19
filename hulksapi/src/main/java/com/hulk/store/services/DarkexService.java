package com.hulk.store.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hulk.store.entity.Darkex;
import com.hulk.store.repository.DarkexRepository;


@Service
public class DarkexService implements IDarkexServices{
	@Autowired
    private DarkexRepository repository;

    @Override
    public List<Darkex> findAll() {

        return (List<Darkex>) repository.findAll();
    }
    
    public Darkex save(Darkex p)    
    {
    	return repository.save(p);
    }
    
    public Darkex findId(Long id)
    {
    	return repository.findById(id).get();
    }   

    
    public void deleteId(Long id)
    {
    	repository.deleteById(id);
    }
}
