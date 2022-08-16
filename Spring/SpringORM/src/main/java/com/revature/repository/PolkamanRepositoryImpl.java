package com.revature.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.revature.model.Polkaman;

/*
 * This annotation is called a Spring stereotype. A Spring stereotype can be used to denote that
 * we would like Spring to add a bean of the annotated type to the container.
 * 
 * @Repository is a special stereotype that indicates that the annotated type is used as a part
 * of an application's data layer (e.g. data access, persistence).
 */
@Repository("polkamanRepository")
public class PolkamanRepositoryImpl implements PolkamanRepository{
	
	/*
	 * We can use our JdbcTemplate bean here by autowiring it in:
	 */
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Polkaman> findAll() {
		/*
		 * The DataClassRowMapper is just an abstraction over taking the data from each DB row, storing in a Polkaman
		 * object, and then adding that Polkaman object to a List.
		 */
		return this.jdbcTemplate
				.query("select * from polkaman", new DataClassRowMapper<Polkaman>(Polkaman.class));
	}

	@Override
	public void save(Polkaman polkaman) {
		this.jdbcTemplate.update("insert into polkaman values(default, ?, ?, ?)", 
				polkaman.getPolka_name(), polkaman.getPolka_type(), polkaman.getPolka_trainer());
		
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Polkaman findById(int id) {
		
		return null;
	}

	
}
