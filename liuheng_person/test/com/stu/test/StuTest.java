package com.stu.test;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StuTest {
	
		@Test
		public void test1() throws SQLException{
			ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
			DataSource dataSource = ctx.getBean(DataSource.class);
			System.out.println(dataSource);
		}
	
}
