package com.hulk.store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hulk.store.entity.Darkex;


@Repository
public interface DarkexRepository extends CrudRepository<Darkex, Long>{
	@Query("SELECT d FROM Darkex d WHERE LOWER(d.productName) like %:data%")
	public List<Darkex> search(@Param("data") String data);
}
