package com.person.service;

import java.util.List;

import com.person.pojo.Person;
import com.person.pojo.Persontype;
import com.person.pojo.Weapon;
import com.person.pojo.Weapontype;
import com.person.utils.PageBean;

public interface PersonService {
	
	public void update(Person person);
	
	public PageBean<Person> findByPage(int pc, int ps);
	
	public Person findById(int id);
	
	public List<Persontype> findAllPType();
	
	public List<Weapontype> findAllWType();
	
	public List<Weapon> findWeaponById(int id);
	
	public Weapontype findWTByPId(int id);
	
	
}
