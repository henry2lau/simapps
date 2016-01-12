package com.cart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.druid.sql.dialect.oracle.ast.stmt.OracleSelectRestriction.ReadOnly;
import com.cart.dao.CartDao;
import com.cart.dao.GoodsDao;
import com.cart.pojo.Cart;
import com.cart.pojo.Goods;
import com.cart.service.CartService;
import com.cart.utils.PageBean;
@Service
@Transactional
public class CartServiceImpl implements CartService {
	@Autowired
	private GoodsDao goodsDao;
	@Autowired
	private CartDao cartDao;
	
	@Override
	public void insert(Cart cart) {
		cartDao.insert(cart);
	}

	@Override
	public List<Cart> findAllCarts() {
		return cartDao.findAll();
	}

	@Override
	public PageBean<Goods> findByPage(int pc, int ps) {
		return goodsDao.findByPageAndProperties(null, null, pc, ps);
	}

	@Override
	public void insertcarts(List<Cart> carts) {
		for (Cart cart : carts) {
			cartDao.insert(cart);
		}
	}
	
	@Transactional(readOnly=true)
	@Override
	public Goods findByGId(int id) {
		Goods goods = goodsDao.findById(id);
		return goods;
	}

}
