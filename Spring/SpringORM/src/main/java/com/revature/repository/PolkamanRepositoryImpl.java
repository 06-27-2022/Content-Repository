package com.revature.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.Polkaman;

/*
 * This annotation is called a Spring stereotype. A Spring stereotype can be used to denote that
 * we would like Spring to add a bean of the annotated type to the container.
 * 
 * @Repository is a special stereotype that indicates that the annotated type is used as a part
 * of an application's data layer (e.g. data access, persistence).
 */
@Repository("polkamanRepository")
/*
 * This annotation can be used at the method level or at the class level, and it denotes that
 * you want Spring to manage your DB transactions for you.
 */
@Transactional
public class PolkamanRepositoryImpl implements PolkamanRepository{
	
	/*
	 * We can use our JdbcTemplate bean here by autowiring it in. I've commented this out as we
	 * are no longer using Spring JDBC. We're now using Spring ORM.
	 */
//	@Autowired
//	private JdbcTemplate jdbcTemplate;
	
	/*
	 * For using Spring ORM, you need to include an EntityManager. Understand that we do not
	 * @Autowired in this case to inject a dependency. We instead use @PersistenceContext to
	 * inject an EntityManager supplied the EntityManagerFactory in our IoC container.
	 * 
	 * The PersistenceContext consists of the different entities that are being managed by our
	 * ORM framework (in this case, we just have one: Polkaman).
	 */
	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	private EntityManager entityManager;

	@Override
	public List<Polkaman> findAll() {
		/*
		 * The DataClassRowMapper is just an abstraction over taking the data from each DB row, storing in a Polkaman
		 * object, and then adding that Polkaman object to a List.
		 */
//		return this.jdbcTemplate
//				.query("select * from polkaman", new DataClassRowMapper<Polkaman>(Polkaman.class));
		/*
		 * Hibernate Query Language (HQL) is specific to Hibernate and allows you to focus your
		 * queries on your Java classes rather than on the tables in the DB.
		 */
		return this.entityManager.createQuery("FROM Polkaman", Polkaman.class).getResultList();
	}

//	@Transactional
	@Override
	public void save(Polkaman polkaman) {
//		this.jdbcTemplate.update("insert into polkaman values(default, ?, ?, ?)", 
//				polkaman.getPolka_name(), polkaman.getPolka_type(), polkaman.getPolka_trainer());
		this.entityManager.persist(polkaman);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
	}

	@Override
	public Polkaman findById(int id) {
		return this.entityManager.find(Polkaman.class, id);
	}

	
}
