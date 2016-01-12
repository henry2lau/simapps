package com.cart.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cart.pojo.Cart;
import com.cart.pojo.Goods;
import com.cart.service.CartService;
import com.cart.utils.PageBean;

@Controller
@RequestMapping("shop")
public class CartHandler {
	@Autowired
	private CartService cartService;
	
	@RequestMapping("list")
	public String list(Map<String,Object>map,@RequestParam(value="pager.offset",required=false)Integer pc){
		int ps = 3;
		if(pc==null){
			pc=0;
		}
		PageBean<Goods> pageBean = cartService.findByPage(pc, ps);
		map.put("pb",pageBean);
		return "list";
	}
	
	@RequestMapping("cart")
	public String cart(Map<String,Object>map){
		List<Cart> list = cartService.findAllCarts();
		map.put("list",list);
		return "cart";
	}
	
	@RequestMapping("add")
	public @ResponseBody String add(String[]ids){
		List<Cart> listcarts= new ArrayList<Cart>();
		List<Cart> carts = cartService.findAllCarts();
		Boolean b = false;
		for (String string : ids) {
			int id =Integer.parseInt(string);
			Goods goods = cartService.findByGId(id);
			if(goods.getNum()<1){
				return "1";
			}
			for (Cart cart : carts) {
				if(cart.getGoods().getName().equals(goods.getName())){
					cart.setCount(cart.getCount()+1);
					 b = true;
				}
			}
			if(b){
				continue;
			}
			Cart cart = new Cart();
			cart.setGoods(goods);
			cart.setCount(1);
			listcarts.add(cart);
		}
		cartService.insertcarts(listcarts);
		return "0";
	}
}
