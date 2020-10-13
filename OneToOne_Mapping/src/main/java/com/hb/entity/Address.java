package com.hb.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Address {
	@Id
	@GeneratedValue(generator = "address_id", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "address_id", sequenceName = "address_id_generator",allocationSize = 1)
	private long id;
	private String street;
	private String city;
	private String state;
	private int pincode;
}
