package com.foodshop.test;

import java.util.Set;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.foodshop.pojo.Area;
import com.foodshop.pojo.Shop;
import com.foodshop.service.FoodsService;

public class shopTest {
	
	private ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

	@Test
	public void test01() {
		DataSource bean = ctx.getBean(DataSource.class);
		System.out.println(bean);
	}
	
	@Test
	public void test02() {
		 FoodsService service = ctx.getBean(FoodsService.class);
		 Set<Shop> set = service.findShopByAddress("上地");
		System.out.println(set.size());
	}

}
