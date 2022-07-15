package com.revature.model;

/**
 * 
 * @author 17084
 *
 * This class models a Revature associate. Models help us cleanly represent real-world
 * data as we can easily pass around several pieces of data.
 * 
 * Each time I make a model, I will include all of the following:
 * 
 * private fields
 * a no-args constructor
 * a constructor using fields (one that takes parameters)
 * getters
 * setters
 * hashCode method
 * equals method
 * toString method
 * 
 * When you include all of the above in a class, you are following the "Java Bean"
 * design pattern.
 */
public class Associate {

	/*
	 * Notice that our fields match up nicely with the columns in our database.
	 */
	private int id;
	private String associateName;
	private String associateLocale;
	private String associateHobby;
	private int trainerId;
	
	public Associate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Associate(int id, String associateName, String associateLocale, String associateHobby, int trainerId) {
		super();
		this.id = id;
		this.associateName = associateName;
		this.associateLocale = associateLocale;
		this.associateHobby = associateHobby;
		this.trainerId = trainerId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAssociateName() {
		return associateName;
	}

	public void setAssociateName(String associateName) {
		this.associateName = associateName;
	}

	public String getAssociateLocale() {
		return associateLocale;
	}

	public void setAssociateLocale(String associateLocale) {
		this.associateLocale = associateLocale;
	}

	public String getAssociateHobby() {
		return associateHobby;
	}

	public void setAssociateHobby(String associateHobby) {
		this.associateHobby = associateHobby;
	}

	public int getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((associateHobby == null) ? 0 : associateHobby.hashCode());
		result = prime * result + ((associateLocale == null) ? 0 : associateLocale.hashCode());
		result = prime * result + ((associateName == null) ? 0 : associateName.hashCode());
		result = prime * result + id;
		result = prime * result + trainerId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Associate other = (Associate) obj;
		if (associateHobby == null) {
			if (other.associateHobby != null)
				return false;
		} else if (!associateHobby.equals(other.associateHobby))
			return false;
		if (associateLocale == null) {
			if (other.associateLocale != null)
				return false;
		} else if (!associateLocale.equals(other.associateLocale))
			return false;
		if (associateName == null) {
			if (other.associateName != null)
				return false;
		} else if (!associateName.equals(other.associateName))
			return false;
		if (id != other.id)
			return false;
		if (trainerId != other.trainerId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Associate [id=" + id + ", associateName=" + associateName + ", associateLocale=" + associateLocale
				+ ", associateHobby=" + associateHobby + ", trainerId=" + trainerId + "]";
	}
}
