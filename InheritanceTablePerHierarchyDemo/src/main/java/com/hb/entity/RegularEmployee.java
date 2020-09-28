package com.hb.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue(value = "regular_employee")
@Getter
@Setter
public class RegularEmployee extends User {
	private float salary;  
	private int bonus;  

}
