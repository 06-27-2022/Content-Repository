package com.revature.repository;

import java.util.ArrayList;
import java.util.List;

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

	private static List<Polkaman> polkamans;
	
	public static void initPolkamans() {
		polkamans = new ArrayList<>();
		polkamans.add(new Polkaman(1, "Pekachu", "Electric", "Bash"));
		polkamans.add(new Polkaman(2, "Water Turtle", "Water", "Nisty"));
		polkamans.add(new Polkaman(3, "Grass polkaman", "Grass", "Bash"));
	}
	
	static {
		initPolkamans();
	}

	@Override
	public List<Polkaman> findAll() {
		return polkamans;
	}

	@Override
	public void save(Polkaman polkaman) {
		polkamans.add(polkaman);
		
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Polkaman findById(int id) {
		Polkaman thePolkaman = null;
		
		for(Polkaman p : polkamans) {
			if(p.getId() == id) {
				thePolkaman = p;
			}
		}
		
		return thePolkaman;
	}

	
}
