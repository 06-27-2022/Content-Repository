package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Trainer;
import com.revature.repository.TrainerRepository;

@Service("trainerService")
public class TrainerService {

	@Autowired
	private TrainerRepository trainerRepository;
	
	public void save(Trainer trainer) {
		this.trainerRepository.save(trainer);
	}
	
	public List<Trainer> findAll(){
		return this.trainerRepository.findAll();
	}
}
