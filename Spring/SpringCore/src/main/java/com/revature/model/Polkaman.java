package com.revature.model;

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
public class Polkaman {

	private int id;
	private String name;
	private String type;
	private String polka_trainer;

}
