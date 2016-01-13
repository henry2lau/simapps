package com.person.dao.impl;

import org.springframework.stereotype.Repository;

import com.person.dao.PersonDao;
import com.person.pojo.Person;
import com.person.utils.BaseDaoImpl;
@Repository
public class PersonDaoImpl extends BaseDaoImpl<Person> implements PersonDao {


}
