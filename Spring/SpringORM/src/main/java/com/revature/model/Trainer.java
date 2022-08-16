package com.revature.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity

@Table(name = "trainer")
public class Trainer {

	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "trainer_name")
	private String trainer_name;
	@Column(name = "region")
	private String region;
	/*
	 * Now let's imagine that trainers have a Collection of Polkamans. NOTE: Hibernate prefers
	 * Sets.
	 * 
	 * Please note that the fetch type for Collections in Hibernate is actually Lazy by default.
	 * You can change it to eager however.
	 */
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn
	private Set<Polkaman> polkamans;
}
