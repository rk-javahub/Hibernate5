package com.hb.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Rohit
 *
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Restaurant {
	@Id
	@GeneratedValue(generator = "restaurant_id", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "restaurant_id", sequenceName = "restaurant_id")
	private Integer restaurantId;
	private String restaurantName;
	private String address;
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "restaurant_delivery", joinColumns = @JoinColumn(name = "restaurant_id"), inverseJoinColumns = @JoinColumn(name = "delivery_id"))
	private Set<Delivery> delivery=new HashSet<Delivery>();
}