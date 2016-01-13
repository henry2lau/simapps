package com.foodshop.service;

import java.util.List;
import java.util.Set;

import com.foodshop.pojo.Area;
import com.foodshop.pojo.Category;
import com.foodshop.pojo.Foods;
import com.foodshop.pojo.Shop;

public interface FoodsService {
	
	public Set<Shop> findShopByAddress(String address);
	
	public Area findByAddress(String address);
	
	public void addFoods(Foods foods);
	
	public List<Foods> findAllFoodsBySid(int sid);
	
	public List<Shop> findAllShop();
	
	public List<Category> findAllCate();
}
