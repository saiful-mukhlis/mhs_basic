package org.bmb.dao.entity;

import java.math.BigInteger;

import javax.persistence.Table;

import org.apache.log4j.Logger;
import org.bmb.dao.abst.DaoAbstract;
import org.bmb.dao.adapter.IdListener;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class DaoIdListener<T extends IdListener> extends DaoAbstract<T, Long> {

	protected Logger log = Logger.getLogger(DaoIdListener.class);

	public DaoIdListener(Class<T> domainClass) {
		super(domainClass);
	}

	@Transactional(readOnly = false)
	public void save(T domain) {
		sessionFactory.getCurrentSession().saveOrUpdate(domain);
	}

	@Transactional(readOnly = false)
	public void save(T domain, boolean baru) {
		if (baru) {
			generateId(domain);
		}
		sessionFactory.getCurrentSession().saveOrUpdate(domain);
	}

	protected void generateId(T domain) {

		Table table = domainClass.getAnnotation(Table.class);
		String tableName;
		if (table!=null) {
			tableName = table.name();
		}else{
			tableName=domainClass.getSimpleName().toLowerCase();
		}
		BigInteger newid = getNewId(tableName);

		if (domain.getKode() == null
				|| domain.getKode().equalsIgnoreCase("AUTO")
				|| domain.getKode().trim().equalsIgnoreCase("")) {
			generateKode(domain, newid);
		}

	}
	protected void generateKode(T domain, BigInteger no){
		domain.setKode(no+"");
	}

}
