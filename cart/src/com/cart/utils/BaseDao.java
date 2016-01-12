package com.cart.utils;

import java.util.List;

public interface BaseDao<T> {

	/**
	 * @author Henry
	 * 2015年12月14日
	 * 下午1:33:02
	 * 功能：增加一条数据
	 * @param t为加入数据
	 */
	public void insert(T t);
	
	
	/**
	 * @author Henry
	 * 2015年12月14日
	 * 下午1:33:02
	 * 功能：按id删除一条数据
	 * @param id为传来的id
	 */
	public void delete(Integer id);
	
	
	
	/**
	 * @author Henry
	 * 2015年12月14日
	 * 下午1:33:02
	 * 功能：修改一条数据
	 * @param t为修改的数据
	 */
	public void update(T t);
	
	
	/**
	 * @author Henry
	 * 2015年12月14日
	 * 下午1:37:51
	 * 功能：按id查找对象
	 * @param id
	 */
	public T findById(Integer id);
	
	
	/**
	 * @author Henry
	 * 2015年12月14日
	 * 下午1:38:27
	 * 功能：查找全部list
	 */
	public List<T> findAll();
	
	/**
	 * @author Henry
	 * 2015年12月14日
	 * 下午1:59:32
	 * 功能：综合查询list
	 * @param propertys 多条件的条件名
	 * @param values 多条件的取值
	 * @param pc 当前页代码
	 * @param ps 每页条目数
	 * @return list
	 */
	public List<T> findByProperty(String[] propertys, Object[] values,int pc,int ps);
	
	/**
	 * @author Henry
	 * 2015年12月14日
	 * 下午2:01:40
	 * 功能：综合查询查出的总行数
	 * @param propertys 多条件的条件名
	 * @param values 多条件的取值
	 * @return 总行数
	 */
	public Integer countTrByProperty(String[] propertys, Object[] values);

	/**
	 * @author Henry
	 * 2015年12月14日
	 * 下午2:02:46
	 * 功能：综合查询PageBean
	 * @param propertys 多条件的条件名
	 * @param values 多条件的取值
	 * @param pc 当前页代码
	 * @param ps 每页条目数
	 * @return PageBean
	 */
	public PageBean<T> findByPageAndProperties(String[] propertys, Object[] values,
			int pc, int ps);
	
	/**
	 * @author Henry
	 * 2015年12月14日
	 * 下午2:07:16
	 * 功能：多对多综合查询
	 * @param propertys 多条件的条件名
	 * @param values 多条件的取值
	 * @param pc 当前页代码
	 * @param ps 每页条目数
	 * @return PageBean
	 */
	public PageBean<T> findByPageAndPropertiesInManyToMany(String[] propertys, Object[] values,
			int pc, int ps,Object modelset);
	
	/**
	 * @author Henry
	 * 2015年12月14日
	 * 下午1:59:32
	 * 功能：多对多综合查询list
	 * @param propertys 多条件的条件名
	 * @param values 多条件的取值
	 * @param pc 当前页代码
	 * @param ps 每页条目数
	 * @return list
	 */
	public List<T> findByPropertyInManyToMany(String[] propertys, Object[] values,int pc,int ps,Object modelset);
	
	/**
	 * @author Henry
	 * 2015年12月14日
	 * 下午2:01:40
	 * 功能：多对多综合查询查出的总行数
	 * @param propertys 多条件的条件名
	 * @param values 多条件的取值
	 * @return 总行数
	 */
	public Integer countTrByPropertyInManyToMany(String[] propertys, Object[] values,Object modelset);

	
	/**
	 * @author Henry
	 * 2015年12月14日
	 * 下午1:59:32
	 * 功能：综合查询list
	 * @param propertys 多条件的条件名
	 * @param values 多条件的取值
	 * @return list
	 */
	public List<T> findByProperty(String[] propertys, Object[] values);
}
