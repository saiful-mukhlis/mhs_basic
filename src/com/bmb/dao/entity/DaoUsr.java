package com.bmb.dao.entity;

import org.bmb.dao.entity.DaoIdListener;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bmb.entity.model.Usr;

@Repository
@Transactional
public class DaoUsr extends DaoIdListener<Usr> {

	public DaoUsr() {
		super(Usr.class);
	}

}
