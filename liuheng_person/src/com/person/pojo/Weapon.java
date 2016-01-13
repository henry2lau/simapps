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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Weapon entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_weapon", catalog = "hlink")
public class Weapon implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Weapontype weapontype;
	private String name;
	@JsonIgnore
	private Set<Person> persons = new HashSet<Person>(0);

	// Constructors

	/** default constructor */
	public Weapon() {
	}

	/** full constructor */
	public Weapon(Weapontype weapontype, String name, Set<Person> persons) {
		this.weapontype = weapontype;
		this.name = name;
		this.persons = persons;
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
	@JoinColumn(name = "wtid")
	public Weapontype getWeapontype() {
		return this.weapontype;
	}

	public void setWeapontype(Weapontype weapontype) {
		this.weapontype = weapontype;
	}

	@Column(name = "name", length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "weapon")
	public Set<Person> getPersons() {
		return this.persons;
	}

	public void setPersons(Set<Person> persons) {
		this.persons = persons;
	}

}