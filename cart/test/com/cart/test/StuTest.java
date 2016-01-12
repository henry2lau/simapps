package com.cart.test;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cart.pojo.Goods;
import com.cart.service.CartService;

public class StuTest {
	@Test
	public void test1() throws SQLException{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		DataSource dataSource = ctx.getBean(DataSource.class);
		System.out.println(dataSource);
	}
	@Test
	public void test2() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		CartService bean = ctx.getBean(CartService.class);
		Goods goods = bean.findByGId(3);
		Goods good  = bean.findByGId(3);
		System.out.println(goods==good);
	}
}
