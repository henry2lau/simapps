package com.person.utils;

import java.util.ArrayList;
import java.util.List;

public class PageBean<T> {

	// 1.entity集合
	private List<T> list = new ArrayList<T>();
	// 2.当前页代码
	private int pc;
	// 3 每页行数
	private int ps;
	// 4.总行数
	private int tr;
	// 5.总页数
	public int getTp() {
		int tp = tr/ps;
		return tr%ps==0 ? tp : tp+1;
	}
	// 6.当前页数
	public int getCp() {
		int cp = (pc+ps)/ps;
		return cp;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public int getPc() {
		return pc;
	}
	public void setPc(int pc) {
		this.pc = pc;
	}
	public int getPs() {
		return ps;
	}
	public void setPs(int ps) {
		this.ps = ps;
	}
	public int getTr() {
		return tr;
	}
	public void setTr(int tr) {
		this.tr = tr;
	}


	
	
}
