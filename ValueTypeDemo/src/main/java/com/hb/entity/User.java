package com.hb.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "user_detail")
@Getter
@Setter
public class User {
	@Id
	@GeneratedValue
	private int id;
	private String firstName;
	private String lastName;
	@Embedded
	private Address address;

}
