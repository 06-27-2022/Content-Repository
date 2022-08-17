package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.revature.model.Polkaman;

/*
 * Typically when you're building a Spring Boot project, you use a module called "Spring Data JPA"
 * with it. Spring Data JPA is a module of Spring that can abstract away repository implementations
 * from developers.
 * 
 * But where will the implementation come from if we only have interfaces?
 * 
 * Spring Data JPA is capable of providing these implementations at runtime. All you have to do is
 * provide interfaces that extend either the JpaRepository or the CrudRepository (the sources of
 * many of the common methods that Spring Data Jpa implements at runtime).
 * 
 * When extending the JpaRepository, the first generic should be the type of the entity and the
 * second generic should be the type of the entity's unique identifier (primary key).
 */

public interface PolkamanRepository extends JpaRepository<Polkaman, Integer>{

	/*
	 * Sometimes, we are limited in what we can do with the JPA expression language. In those cases,
	 * we might want to be able to do slightly modify the query that will be executed by Spring
	 * Data JPA. In order to do so, we can use the @Query annotation.
	 */
	@Query("select p from Polkaman p where p.polkatype = ?1")
	List<Polkaman> findByPolkatype(String polkatype);
	List<Polkaman> findAllByOrderByPolkaname();
	/*
	 * Let's say that you want to find all Polkamans by their type (e.g. "electric").
	 * 
	 * Please note that Spring Data JPA is very picky about how you name your properties on your
	 * classes. It doesn't like underscores in the names. It also does not like camel casing
	 * once you start adding predicates after the field name in the method name.
	 */
	List<Polkaman> findAllByPolkatype(String polkaType);
	/*
	 * As a fun fact, methods inherited from the standard CRUD repository don't technically have
	 * to be declared here to be used. It is only the custom methods which contain field names
	 * and predicates that you must declare here.
	 */
	<S extends Polkaman> S save(S entity);
	void delete(Polkaman entity);
	Polkaman findById(int id);
	
}
