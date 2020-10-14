package com.hb.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "user_otm")
@Getter
@Setter
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue(generator = "user_id", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "user_id", sequenceName = "user_id_generator", allocationSize = 1)
	private int id;
	private String firstName;
	private String lastName;
	@OneToMany(mappedBy = "user")
	@Cascade(CascadeType.ALL)
	private Set<BankAccount> bankAccount;

}
