package com.cart.utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseDaoImpl<T> implements BaseDao<T> {

	private Class<T> clazz;

	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {

		Type type = this.getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) type;
		clazz = (Class<T>) pt.getActualTypeArguments()[0];
	}

	@Autowired
	protected SessionFactory sessionFactory;

	protected Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public void insert(T t) {
		this.getSession().persist(t);
	}

	@Override
	public void delete(Integer id) {
		Object o = this.getSession().get(clazz, id);
		this.getSession().delete(o);
	}

	@Override
	public void update(T t) {
		this.getSession().merge(t);
	}

	@Override
	@SuppressWarnings("unchecked")
	public T findById(Integer id) {
		return (T) this.getSession().get(clazz, id);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		String hql = "From " + clazz.getSimpleName();
		return (List<T>) this.getSession().createQuery(hql).list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<T> findByProperty(String[] propertys, Object[] values, int pc,
			int ps) {
		StringBuffer sb = new StringBuffer();
		if (propertys != null && values != null) {
			for (int i = 0; i < propertys.length; i++) {
				if (values[i] != null) {
					if (values[i].getClass() == Integer.class) {
						sb.append(" and model." + propertys[i] + " = "
								+ values[i] + " ");
					} else {
						sb.append(" and model." + propertys[i] + " like '%"
								+ values[i] + "%' ");
					}
				}
			}
		}
		try {
			String queryString = "from " + clazz.getSimpleName()
					+ " as model where 1=1 " + sb;
			Query queryObject = getSession().createQuery(queryString)
					.setFirstResult(pc).setMaxResults(ps);
			return queryObject.list();
		} catch (RuntimeException re) {
			throw re;
		}

	}

	@Override
	public Integer countTrByProperty(String[] propertys, Object[] values) {
		StringBuffer sb = new StringBuffer();
		if (propertys != null && values != null) {
			for (int i = 0; i < propertys.length; i++) {
				if (values[i] != null) {
					if (values[i].getClass() == Integer.class) {
						sb.append(" and model." + propertys[i] + " = "
								+ values[i] + " ");
					} else {
						sb.append(" and model." + propertys[i] + " like '%"
								+ values[i] + "%' ");
					}
				}
			}
		}
		try {
			String queryString = "select count(model.id) from "
					+ clazz.getSimpleName() + " as model where 1=1 " + sb;
			Query queryObject = getSession().createQuery(queryString);
			return ((Long) queryObject.uniqueResult()).intValue();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@Override
	public PageBean<T> findByPageAndProperties(String[] propertys,
			Object[] values, int pc, int ps) {
		PageBean<T> pageBean = new PageBean<T>();
		pageBean.setPc(pc);
		pageBean.setPs(ps);

		List<T> list = this.findByProperty(propertys, values, pc, ps);
		pageBean.setList(list);

		int tr = this.countTrByProperty(propertys, values);
		pageBean.setTr(tr);
		return pageBean;
	}

	@Override
	public PageBean<T> findByPageAndPropertiesInManyToMany(String[] propertys,
			Object[] values, int pc, int ps, Object modelset) {
		PageBean<T> pageBean = new PageBean<T>();
		pageBean.setPc(pc);
		pageBean.setPs(ps);

		List<T> list = this.findByPropertyInManyToMany(propertys, values, pc,
				ps, modelset);
		pageBean.setList(list);

		int tr = this
				.countTrByPropertyInManyToMany(propertys, values, modelset);
		pageBean.setTr(tr);
		return pageBean;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<T> findByPropertyInManyToMany(String[] propertys,
			Object[] values, int pc, int ps, Object modelset) {
		StringBuffer sb = new StringBuffer();
		String model2 = modelset.getClass().getSimpleName();
		model2 = model2.toLowerCase();
		if (propertys != null && values != null) {
			for (int i = 0; i < propertys.length; i++) {
				if (i == 0) {
					sb.append(" and md2." + propertys[i] + " = " + values[i]
							+ " ");
				}
				if (values[i] != null && i >= 1) {
					if (values[i].getClass() == Integer.class) {
						sb.append(" and model." + propertys[i] + " = "
								+ values[i] + " ");
					} else {
						sb.append(" and model." + propertys[i] + " like '%"
								+ values[i] + "%' ");
					}
				}
			}
		}
		try {
			String queryString = "from " + clazz.getSimpleName()
					+ " as model left join fetch model." + model2
					+ " md2 where 1=1 " + sb;
			Query queryObject = getSession().createQuery(queryString)
					.setFirstResult(pc).setMaxResults(ps);
			return queryObject.list();
		} catch (RuntimeException re) {
			throw re;
		}

	}

	@Override
	public Integer countTrByPropertyInManyToMany(String[] propertys,
			Object[] values, Object modelset) {
		StringBuffer sb = new StringBuffer();
		String model2 = modelset.getClass().getSimpleName();
		model2 = model2.toLowerCase();
		if (propertys != null && values != null) {
			for (int i = 0; i < propertys.length; i++) {
				if (i == 0) {
					sb.append(" and md2." + propertys[i] + " = " + values[i]
							+ " ");
				}
				if (values[i] != null && i >= 1) {
					if (values[i].getClass() == Integer.class) {
						sb.append(" and model." + propertys[i] + " = "
								+ values[i] + " ");
					} else {
						sb.append(" and model." + propertys[i] + " like '%"
								+ values[i] + "%' ");
					}
				}
			}
		}
		try {
			String queryString = "select count(model.id) from "
					+ clazz.getSimpleName() + " as model left join model."
					+ model2 + " md2 where 1=1 " + sb;
			Query queryObject = getSession().createQuery(queryString);
			return ((Long) queryObject.uniqueResult()).intValue();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<T> findByProperty(String[] propertys, Object[] values) {
		StringBuffer sb = new StringBuffer();
		if (propertys != null && values != null) {
			for (int i = 0; i < propertys.length; i++) {
				if (values[i] != null) {
					if (values[i].getClass() == Integer.class) {
						sb.append(" and model." + propertys[i] + " = "
								+ values[i] + " ");
					} else {
						sb.append(" and model." + propertys[i] + " = '"
								+ values[i] + "' ");
					}
				}
			}
		}
		try {
			String queryString = "from " + clazz.getSimpleName()
					+ " as model where 1=1 " + sb;
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			throw re;
		}
	}

}
