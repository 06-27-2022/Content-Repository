package com.revature.repository;

import java.util.List;

import com.revature.model.Associate;

public interface AssociateRepository {

	/*
	 * What types of methods will I need to write for data access? What actions
	 * must be performed to get or update the data in this application?
	 */
	
	List<Associate> findAllAssociates();
	/**
	 * This method inserts a new record into the associate table.
	 * 
	 * @param associate
	 * 
	 */
	void save(Associate associate);
	
	/**
	 * 
	 * This method updates an existing associate record.
	 * 
	 * @param associate
	 * 
	 */
	void update(Associate associate);
	
	/**
	 * This method finds a single associate record by its ID.
	 * 
	 * @param id the id associated with the record you're trying to fetch.
	 */
	Associate findById(int id);
}
