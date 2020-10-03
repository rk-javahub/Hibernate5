package com.hb.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue(value = "contract_employee")
@Getter
@Setter
public class ContractEmployee extends User {
	private float pay_per_hour;
	private String contract_duration;

}
