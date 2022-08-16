package com.revature.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/*
 * We will be using this class to configure our ApplicationContext. This means that we will be
 * adding Spring beans to our IoC container using this class. This is a replacement for our XML
 * configuration.
 * 
 * If you wish to use a class to configure your context, it must be annotated with @Configuration.
 */

@Configuration
/*
 * The @ComponentScan annotation tells Spring which packages to scan for Spring
 * stereotypes.
 */
@ComponentScan(basePackages = { "com.revature.service", "com.revature.repository", "com.revature.controller" })
/*
 * To enable support for Spring Web Mvc, use the following annotation:
 */
@EnableWebMvc
public class AppConfig{

	/*
	 * Recall that we can create methods annotated with @Bean in a configuration class to add
	 * beans to our IOC container. Also recall that I said that it is common to use this approach
	 * when beans require heavy customization before they are added to the container.
	 * 
	 * We'll start with a bean that will be used to manage our DB credentials. Please note that
	 * Spring will use your DataSource bean to connect to your DB. You should never have to manually
	 * open a connection or close a connection.
	 */
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		//Again, I'm using a different DB from you all, so my URL looks different from yours.
		dataSource.setUrl("jdbc:h2:mem:test;INIT=RUNSCRIPT FROM 'classpath:init.sql';DB_CLOSE_DELAY=-1");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		return dataSource;
		
	}
	
	/*
	 * In order to remove our boilerplate JDBC code from our repository, we can define a JdbcTemplate
	 * bean. The JdbcTemplate abstracts away the process of connecting to the DB, creating Statement objects
	 * and Result Set objects, and closing our connections as it wraps around our DataSource bean
	 * and handles those tasks for us. This is technically a feature of a Spring module called
	 * Spring JDBC as Spring ORM includes the Spring JDBC module transitively.
	 */
	
//	@Bean
//	public JdbcTemplate jdbcTemplate() {
//		return new JdbcTemplate(dataSource());
//	}
	
	/*
	 * Right now, we're using Spring JDBC, which provides decent abstraction over our standard,
	 * boilerplate JDBC code. That said, there are still some problems that Spring JDBC just can't
	 * address:
	 * 
	 * 1) As developers, we are doing a lot of context switching; our brains are having to switch
	 * and back forth and between OOP (with Java) and designing our DB schema (using SQL). This is
	 * a problem because SQL and OOP languages have what we call a "paradigm mismatch". For instance,
	 * not all of the same data types are supported in OOP languages and SQL.
	 * 
	 * Spring ORM is the solution to this paradigm mismatch. ORM stands for "Object Relational
	 * Mapping". ORM is not specific to Spring as Spring ORM is a module of Spring that simply
	 * abstracts away the configuration of your ORM framework of choice. Our ORM framework of 
	 * choice today is called "Hibernate", which is a popular Java ORM framework.
	 * 
	 * What are some of the ways in which an ORM framework removes the paradigm mismatch? Well:
	 * 
	 * 1) It removes the need to match Java data types up with SQL data types as the ORM framework
	 * can manage these relationships the Java code and the DB schema.
	 * 2) It removes the need to write SQL queries; you just deal with the Java objects entirely.
	 * 3) In fact, you don't even have to make the DB tables yourself as Hibernate is capable of
	 * creating them for you based on your Java classes. Please note that this one is bad practice
	 * as you do want to write your own SQL scripts for table creation.
	 * 
	 * In order to take advantage of Spring ORM's Hibernate integration, we will create an
	 * EntityManagerFactoryBean that is actually just an abstraction over Hibernate.
	 */
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		/*
		 * The EntityManagerFactory needs to know which packages to scan for entities (anything
		 * annotated with @Entity).
		 */
		em.setPackagesToScan("com.revature.model");
		//Now I need to tell Spring ORM what my Jpa provider is. My Jpa provider is Hibernate.
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		//Set some Hibernate properties. We'll use the built-in Java "Properties" class to define these properties.
		Properties hibernateProps = new Properties();
		//This Hibernate property shows the SQL queries that Hibernate writes for you in the console.
		hibernateProps.put("hibernate.show_sql", "true");
		//This property denotes that Hibernate will run in "create" mode, which means it can create our tables for us.
		hibernateProps.put("hibernate.hbm2ddl.auto", "validate");
		em.setJpaProperties(hibernateProps);
		return em;
	}
	

	
	

}
