package com.jkxy.support.model;

import java.util.Date;
import java.util.Set;


public class Poets {
	private Integer id;
	private String name;	////作者
	private Date created_at;	//创建时间
	private Date updated_at;	//更新时间
	private Set<Poetries> poeList;
	public Poets() {
		// TODO 自动生成的构造函数存根
	}
	public Poets(Integer id,String name){
		this.id=id;
		this.name=name;
	}
	
	public Set<Poetries> getPoeList() {
		return poeList;
	}

	public void setPoeList(Set<Poetries> poeList) {
		this.poeList = poeList;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public Date getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
	@Override
	public String toString() {
		return "Poets [id=" + id + ", name=" + name + ", created_at="
				+ created_at + ", updated_at=" + updated_at + "]";
	}
	
}
