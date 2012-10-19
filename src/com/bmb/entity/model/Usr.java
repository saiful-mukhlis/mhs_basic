package com.bmb.entity.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.bmb.dao.adapter.IdListener;



/**
 * The persistent class for the usr database table.
 * 
 */
@Entity
public class Usr implements IdListener{
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String username;



    public Usr() {
    }

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public void setKode(String kode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getKode() {
		// TODO Auto-generated method stub
		return null;
	}

	
	

	
}