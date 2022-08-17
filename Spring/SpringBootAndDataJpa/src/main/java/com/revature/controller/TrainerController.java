package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Trainer;
import com.revature.service.TrainerService;

@RestController("trainerController")
@RequestMapping("/trainer")
public class TrainerController {

	@Autowired
	private TrainerService trainerService;
	
	@PostMapping("/new")
	public void save(@RequestBody Trainer trainer) {
		this.trainerService.save(trainer);
	}
	
	@GetMapping("/all")
	public List<Trainer> findAll(){
		return this.trainerService.findAll();
	}
}
