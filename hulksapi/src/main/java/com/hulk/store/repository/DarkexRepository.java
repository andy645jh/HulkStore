package com.hulk.store.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hulk.store.entity.Darkex;


@Repository
public interface DarkexRepository extends CrudRepository<Darkex, Long>{

}
