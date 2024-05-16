package com.MonthlyChalllengeApp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Challenge {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String month;
private String description;


public Challenge() {
	super();
}
public Challenge(Long id, String month, String description) {
	super();
	this.id = id;
	this.month = month;
	this.description = description;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getMonth() {
	return month;
}
public void setMonth(String month) {
	this.month = month;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}

}
