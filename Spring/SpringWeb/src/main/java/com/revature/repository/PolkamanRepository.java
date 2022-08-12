package com.revature.repository;

import java.util.List;

import com.revature.model.Polkaman;

public interface PolkamanRepository {

	List<Polkaman> findAll();
	void save(Polkaman polkaman);
	void deleteById(int id);
	Polkaman findById(int id);
}
