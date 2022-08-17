package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.model.Trainer;

public interface TrainerRepository extends JpaRepository<Trainer, Integer>{

	<S extends Trainer> S save(Trainer trainer);
	List<Trainer> findAll();
}
