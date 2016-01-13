package com.person.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.person.dao.PersonDao;
import com.person.dao.PersontypeDao;
import com.person.dao.WeaponDao;
import com.person.dao.WeapontypeDao;
import com.person.pojo.Person;
import com.person.pojo.Persontype;
import com.person.pojo.Weapon;
import com.person.pojo.Weapontype;
import com.person.service.PersonService;
import com.person.utils.PageBean;
@Service
@Transactional
public class PersonServiceImpl implements PersonService {
	@Autowired
	private PersonDao personDao;
	@Autowired
	private PersontypeDao persontypeDao;
	@Autowired
	private WeaponDao weaponDao;
	@Autowired
	private WeapontypeDao weapontypeDao;

	@Override
	public void update(Person person) {
		personDao.update(person);

	}

	@Override
	public PageBean<Person> findByPage(int pc, int ps) {
		return personDao.findByPageAndProperties(null, null, pc, ps);
	}

	@Override
	public Person findById(int id) {
		return personDao.findById(id);
	}

	@Override
	public List<Persontype> findAllPType() {
		return persontypeDao.findAll();
	}

	@Override
	public List<Weapontype> findAllWType() {
		return weapontypeDao.findAll();
	}

	@Override
	public List<Weapon> findWeaponById(int id) {
		String [] propertys= {"weapontype.id"};
		Object[] values={id};
		return weaponDao.findByProperty(propertys, values);
	}

	@Override
	public Weapontype findWTByPId(int id) {
			Person person = personDao.findById(id);
			Weapon weapon = person.getWeapon();
			Weapontype weapontype=null;
			if(weapon!=null)
				weapontype = weapon.getWeapontype();
			else 
				return null;
		return weapontype;
	}

}
