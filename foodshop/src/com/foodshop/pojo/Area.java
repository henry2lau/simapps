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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Area entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "t_area", catalog = "kafe")
public class Area implements java.io.Serializable {

	// Fields

	private Integer id;
	private String TAreacol;
	@JsonIgnore
	private Set<Address> addresses = new HashSet<Address>(0);
	private Set<Shop> shops = new HashSet<Shop>(0);

	// Constructors

	/** default constructor */
	public Area() {
	}

	/** full constructor */
	public Area(String TAreacol, Set<Address> addresses, Set<Shop> shops) {
		this.TAreacol = TAreacol;
		this.addresses = addresses;
		this.shops = shops;
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

	@Column(name = "t_areacol", length = 45)
	public String getTAreacol() {
		return this.TAreacol;
	}

	public void setTAreacol(String TAreacol) {
		this.TAreacol = TAreacol;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "area")
	public Set<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "area")
	public Set<Shop> getShops() {
		return this.shops;
	}

	public void setShops(Set<Shop> shops) {
		this.shops = shops;
	}

}