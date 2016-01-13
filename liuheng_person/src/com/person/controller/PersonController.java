package com.person.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.person.pojo.Person;
import com.person.pojo.Weapon;
import com.person.pojo.Weapontype;
import com.person.service.PersonService;
import com.person.utils.PageBean;

@Controller
@RequestMapping("person")
public class PersonController {
	@Autowired
	private PersonService personService;
	@RequestMapping("list")
	public String list(Map<String,Object>map,@RequestParam(required=false,value="pager.offset")Integer pc){
		int ps=2;
		if(pc==null){
			pc=0;
		}
		PageBean<Person> pageBean = personService.findByPage(pc, ps);
		map.put("pb", pageBean);
		return "list";
	}
	
	@RequestMapping(value="show")
	public @ResponseBody Map<String,Object> show(@RequestParam(required=true)Integer id){
		Map<String,Object> map= new HashMap<String, Object>();
		Person person = personService.findById(id);
		Weapontype weapontype = personService.findWTByPId(id);
		List<Weapontype> wType = personService.findAllWType();
		map.put("person",person);
		map.put("wtype",weapontype);
		map.put("wType",wType);
		map.put("id", id);
		return map;
	}
	
	@RequestMapping(value="update")
	public String update(Map<String,Object>map,@RequestParam(required=true)Integer id){
		map.put("id", id);
		return "update";
	}
	
	
	
	@RequestMapping("showWeapon")
	public @ResponseBody List<Weapon> showWeapon(@RequestParam(required=true)Integer id){
		List<Weapon> list = personService.findWeaponById(id);
		return list;
	}
	
	@RequestMapping(value="save")
	public String save(Person person){
		personService.update(person);
		return "redirect:/person/list.do";
	}
}
