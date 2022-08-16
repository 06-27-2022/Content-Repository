package com.revature.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.Trainer;

@Repository("trainerRepository")
@Transactional
public class TrainerRepositoryImpl {

	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	private EntityManager entityManager;
	
	public void save(Trainer trainer) {
		this.entityManager.persist(trainer);
	}
	
	public List<Trainer> findAll(){
		return this.entityManager.createQuery("FROM Trainer", Trainer.class).getResultList();
	}
}
