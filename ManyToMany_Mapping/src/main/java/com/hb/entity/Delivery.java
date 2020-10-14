package com.hb.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Rohit
 *
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Delivery {
	@Id
	@GeneratedValue(generator = "delivery_id", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "delivery_id", sequenceName = "delivery_id")
	private Integer deliveryId;
	private String partnerName;
	private Double charges;
	@ManyToMany(mappedBy = "delivery")
	Set<Restaurant> restaurantList = new HashSet<Restaurant>();
}
