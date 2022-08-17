package com.revature.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Polkaman;
import com.revature.repository.PolkamanRepository;

/*
 * @Service is a Spring stereotype that indicates that the annotated type should be added to the
 * container as a Spring bean.
 * 
 * @Service should be used for classes that contain business logic.
 * 
 * Also note that there is a generic stereotype called @Component. In fact, all specialized stereotypes
 * are built on top of @Component.
 */

@Service("polkamanService")
public class PolkamanService {

	/*
	 * We can identify this as a dependency of this class; it is not possible for the PolkamanService
	 * to access the data source without having a PolkamanRepositoryImpl object.
	 */
	@Autowired
	private PolkamanRepository polkamanRepository;
	
	/*
	 * Spring looks for this no-args constructor when wiring in beans unless you're using 
	 * constructor injection.
	 */
	public PolkamanService() {
		
	}
	
	/*
	 * You can also instruct Spring to use constructor injection to perform dependency injection.
	 * 
	 * Note that by using @Autowired, we're instructing Spring to use the construction to wire in
	 * our dependencies.
	 */
//	@Autowired
//	public PolkamanService(PolkamanRepository polkamanRepository) {
//		this.polkamanRepository = polkamanRepository;
//	}
	
	/*
	 * By default, Spring uses setter injection. This means that when it attempts to perform dependency
	 * injection (DI) for us, it attempts to call a setter method in which it passes the bean to us.
	 * 
	 * Spring is very much about "convention over configuration". It expects you to name methods in
	 * very conventional ways. For instance, this setter needs to follow the convention for setters as
	 * far as naming goes (set + propertyName).
	 */
//	@Autowired
//	public void setPolkamanRepository(PolkamanRepository polkamanRepository) {
//		this.polkamanRepository = polkamanRepository;
//	}
	
	/*
	 * This method sorts the polkamans by their name and then returns the sorted
	 * list.
	 */
	public List<Polkaman> findAllByOrderByPolkaname(){
		
		return this.polkamanRepository.findAllByOrderByPolkaname();
	}
	
	public Polkaman findById(int id) {
		return this.polkamanRepository.findById(id);
	}
	
	public void save(Polkaman polkaman) {
		this.polkamanRepository.save(polkaman);
	}
	
	public List<Polkaman> findAllByPolkaType(String polkaType){
		return this.polkamanRepository.findAllByPolkatype(polkaType);
	}
}
