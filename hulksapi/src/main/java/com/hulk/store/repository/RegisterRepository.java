package com.hulk.store.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hulk.store.entity.Register;

@Repository
public interface RegisterRepository extends CrudRepository<Register, Long>{

}