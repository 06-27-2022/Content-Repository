package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A Polkaman is the non copywrited version of a pocket monster.
 * 
 * @author 17084
 *
 */

/*
 * Lombok is a nice-to-have tool that allows you to further remove boilerplate code from your
 * projects. It is capable of generating all of the traditional components of a Java bean for
 * you if you use its built-in annotations.
 * 
 * If you wish to use Lombok, you do have to install a plugin. You can find instructions on how
 * to do so on Lombok's official website: https://projectlombok.org/setup/eclipse
 */
@NoArgsConstructor
@AllArgsConstructor
@Data

/*
 * Spring ORM wraps around Hibernate (our ORM framework) in order to abstract SQL from us entirely.
 * In order to make this happen, we need to annotate our models so that Hibernate knows which tables
 * to create and which columns should exist on those tables.
 * 
 * Note that all of our annotations are actually imported from the Java Persistence API (JPA). 
 * Hibernate actually follows the JPA standard and is known as a JPA provider. Please understand
 * that the JPA really just provides an interface for Jpa vendors like Hibernate.
 */

@Entity //denotes that this class is an entity that should be managed by Hibernate

@Table(name = "polkaman") //denotes that this represents a table in our DB
public class Polkaman {

	@Id //denotes that this column is the primary key for this table
	@Column(name = "id") //denotes that this field should correspond to a column on the table in the DB
	private int id;
	@Column(name = "polka_name")
	private String polka_name;
	@Column(name = "polka_type")
	private String polka_type;
	@Column(name = "polka_trainer")
	private String polka_trainer;

}
