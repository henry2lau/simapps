package com.person.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Person entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_person", catalog = "hlink")
public class Person implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Weapon weapon;
	private Persontype persontype;
	private String name;
	private String intro;
	private String life;

	// Constructors

	/** default constructor */
	public Person() {
	}

	/** full constructor */
	public Person(Weapon weapon, Persontype persontype, String name,
			String intro, String life) {
		this.weapon = weapon;
		this.persontype = persontype;
		this.name = name;
		this.intro = intro;
		this.life = life;
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
	@JoinColumn(name = "wid")
	public Weapon getWeapon() {
		return this.weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ptid")
	public Persontype getPersontype() {
		return this.persontype;
	}

	public void setPersontype(Persontype persontype) {
		this.persontype = persontype;
	}

	@Column(name = "name", length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "intro", length = 45)
	public String getIntro() {
		return this.intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	@Column(name = "life", length = 45)
	public String getLife() {
		return this.life;
	}

	public void setLife(String life) {
		this.life = life;
	}

}