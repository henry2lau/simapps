package com.cart.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Cart entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "t_cart", catalog = "hlink")
public class Cart implements java.io.Serializable {

	// Fields

	private Integer id;
	private Goods goods;
	private Integer count;
	@SuppressWarnings("unused")
	private Integer gprice;

	// Constructors

	/** default constructor */
	public Cart() {
	}

	/** full constructor */
	public Cart(Goods goods, Integer count, Integer gprice) {
		this.goods = goods;
		this.setCount(count);
		this.gprice = gprice;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "gid")
	public Goods getGoods() {
		return this.goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}



	@Column(name = "gprice")
	public Integer getGprice() {
		int s=this.goods.getPrice()*this.count;
		return s;
	}

	public void setGprice(Integer gprice) {
		this.gprice = gprice;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

}