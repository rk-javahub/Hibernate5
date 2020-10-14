package com.hb.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "account_otm")
@Getter
@Setter
@NoArgsConstructor
public class BankAccount {
	@Id
	@GeneratedValue(generator = "account_id", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "account_id", sequenceName = "account_id_generator", allocationSize = 1)
	private int id;
	private String bankName;
	private long accountNumber;
	private String branch;
	@ManyToOne
	private User user;
}
