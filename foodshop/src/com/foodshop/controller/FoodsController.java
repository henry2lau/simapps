package com.foodshop.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.foodshop.pojo.Category;
import com.foodshop.pojo.Foods;
import com.foodshop.pojo.Shop;
import com.foodshop.service.FoodsService;

@Controller
@RequestMapping("shop")
public class FoodsController {
	@Autowired
	private FoodsService foodsService;
	
	@RequestMapping(value="add",method=RequestMethod.POST)
	public String add(Map<String,Object>map){
		List<Category> cate = foodsService.findAllCate();
		List<Shop> shop = foodsService.findAllShop();
		map.put("cates",cate);
		map.put("shops",shop);
		return "add";
	}
	
	@RequestMapping(value="add",method=RequestMethod.GET)
	public String add(Foods foods){
		foodsService.addFoods(foods);
		return "add";
	}
	
	@RequestMapping("findAdd")
	public String findAdd(){
		return "findAdd";
	}
	
	@RequestMapping("shoplist")
	public String findArea(String address,Map<String,Object>map){
		Set<Shop> set = foodsService.findShopByAddress(address);
		map.put("shops", set);
		return "shoplist";
	}
	
	@RequestMapping("foodslist")
	public String foodslist(Integer sid,Map<String,Object>map){
		List<Foods> list = foodsService.findAllFoodsBySid(sid);
		List<Category> cates = new ArrayList<Category>();
		for (int i = 0; i < list.size(); i++) {
			Foods foods = list.get(i);
			if(foods.getCategory()!=null){
				if(i==0){
					System.out.println(foods.getCategory().getName());
					cates.add(foods.getCategory());
				}
				if(i>=1&&foods.getCategory().getName()!=list.get(i-1).getCategory().getName()){
					cates.add(foods.getCategory());
					System.out.println(foods.getCategory().getName());
				}
				System.out.println(foods.getName()+"---------"+foods.getPrice());
			}
		}
		map.put("cates", cates);
		map.put("list", list);
		return "foodslist";
	}
}
