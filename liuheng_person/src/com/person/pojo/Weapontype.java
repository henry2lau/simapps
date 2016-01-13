package com.person.pojo;

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
 * Weapontype entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_weapontype", catalog = "hlink")
public class Weapontype implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	@JsonIgnore
	private Set<Weapon> weapons = new HashSet<Weapon>(0);

	// Constructors

	/** default constructor */
	public Weapontype() {
	}

	/** full constructor */
	public Weapontype(String name, Set<Weapon> weapons) {
		this.name = name;
		this.weapons = weapons;
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

	@Column(name = "name", length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "weapontype")
	public Set<Weapon> getWeapons() {
		return this.weapons;
	}

	public void setWeapons(Set<Weapon> weapons) {
		this.weapons = weapons;
	}

}