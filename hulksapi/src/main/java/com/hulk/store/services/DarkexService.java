package com.hulk.store.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hulk.store.entity.Darkex;
import com.hulk.store.entity.Register;
import com.hulk.store.repository.DarkexRepository;
import com.hulk.store.repository.RegisterRepository;


@Service
public class DarkexService implements IDarkexServices{
	@Autowired
    private DarkexRepository darkexRepo;
	
	@Autowired
	private RegisterRepository registerRepo;

    @Override
    public List<Darkex> findAll() {

        return (List<Darkex>) darkexRepo.findAll();
    }
    
    public Darkex save(Darkex p)    
    {
    	/*Register r = registerRepo.findById(registerId);
    	p.setRegisters(registers);*/
    	return darkexRepo.save(p);
    }
    
    public Darkex findId(Long id)
    {
    	return darkexRepo.findById(id).get();
    }   

    
    public void deleteId(Long id)
    {
    	darkexRepo.deleteById(id);
    }
}
