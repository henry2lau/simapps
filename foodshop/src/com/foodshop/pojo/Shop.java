package com.foodshop.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Shop entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "t_shop", catalog = "kafe")
public class Shop implements java.io.Serializable {

	// Fields

	private Integer id;
	private Area area;
	private String name;
	@JsonIgnore
	private Set<Foods> foodses = new HashSet<Foods>(0);

	// Constructors

	/** default constructor */
	public Shop() {
	}

	/** full constructor */
	public Shop(Area area, String name, Set<Foods> foodses) {
		this.area = area;
		this.name = name;
		this.foodses = foodses;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "aid")
	public Area getArea() {
		return this.area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	@Column(name = "name", length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "shop")
	public Set<Foods> getFoodses() {
		return this.foodses;
	}

	public void setFoodses(Set<Foods> foodses) {
		this.foodses = foodses;
	}

}