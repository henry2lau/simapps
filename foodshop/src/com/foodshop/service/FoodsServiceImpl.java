package com.foodshop.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.foodshop.dao.AddressDao;
import com.foodshop.dao.AreaDao;
import com.foodshop.dao.CategoryDao;
import com.foodshop.dao.FoodsDao;
import com.foodshop.dao.ShopDao;
import com.foodshop.pojo.Address;
import com.foodshop.pojo.Area;
import com.foodshop.pojo.Category;
import com.foodshop.pojo.Foods;
import com.foodshop.pojo.Shop;

@Transactional
@Service
public class FoodsServiceImpl implements FoodsService {
	@Autowired
	private AddressDao addressDao;
	@Autowired
	private AreaDao areaDao;
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private FoodsDao foodsDao;
	@Autowired
	private ShopDao shopDao;

	@Override
	public Set<Shop> findShopByAddress(String address) {
		Area area = findByAddress(address);
		if(area==null){
			return null;
		}
		else{
			return area.getShops();
		}
	}

	@Override
	public Area findByAddress(String address) {
		String[] propertys={"address"};
		Object[] values={address};
		List<Address> list = addressDao.findByProperty(propertys, values, 0, 100);
		if(list.size()==0){
			return null;
		}
		return list.get(0).getArea();
	}

	@Override
	public void addFoods(Foods foods) {
		foodsDao.insert(foods);
	}

	@Override
	public List<Foods> findAllFoodsBySid(int sid) {
		String[] propertys={"shop.id"};
		Object[] values={sid};
		return foodsDao.findByProperty(propertys, values, 0, 100);
	}

	@Override
	public List<Shop> findAllShop() {
		List<Shop> list = shopDao.findAll();
		return list;
	}

	@Override
	public List<Category> findAllCate() {
		return categoryDao.findAll();
	}

}
