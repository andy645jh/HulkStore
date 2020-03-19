package com.hulk.store.services;

import java.util.List;

import com.hulk.store.entity.Darkex;

public interface IDarkexServices {
	List<Darkex> findAll();
	Darkex findId(Long id);
    void deleteId(Long id);
    Darkex save(Darkex p);  
}