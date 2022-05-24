package com.example.demo.helloworld.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.helloworld.model.ToDo;

@Repository
public interface ToDoJpaRepository extends JpaRepository<ToDo, Long>{

//	List<T> findAll();
//	List<T> findAll(Sort sort);
//	List<T> findAllById(Iterable<ID> ids);
//	<S extends T> List<S> saveAll(Iterable<S> entities);
//	void flush();
//	<S extends T> S saveAndFlush(S entity);
//	<S extends T> List<S> saveAllAndFlush(Iterable<S> entities);
//	default void deleteInBatch(Iterable<T> entities){deleteAllInBatch(entities);}
//	void deleteAllInBatch(Iterable<T> entities);
//	void deleteAllByIdInBatch(Iterable<ID> ids);
//	void deleteAllInBatch();
//	T getById(ID id);
//	<S extends T> List<S> findAll(Example<S> example, Sort sort);
	
//	select mp from MedioPago mp 
//	join fetch mp.cliente
//	where mp.cliente.id =?1
	@Query("SELECT t FROM ToDo t WHERE t.user.username = :username")
//	@Query("SELECT t FROM ToDo t INNER JOIN user u WHERE t.user.username = :username")
	List<ToDo> findByUsername(@Param("username") String username);
	

	List<ToDo> findByUserId(Long user_id);
}
