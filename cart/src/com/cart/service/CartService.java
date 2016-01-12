package com.cart.service;

import java.util.List;

import com.cart.pojo.Cart;
import com.cart.pojo.Goods;
import com.cart.utils.PageBean;

public interface CartService {
	
	public void insert(Cart cart);
	
	public List<Cart> findAllCarts();
	
	public PageBean<Goods> findByPage(int pc,int ps);
	
	public void insertcarts(List<Cart> carts);
	
	public Goods findByGId(int id);
}
