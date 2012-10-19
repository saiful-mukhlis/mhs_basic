package org.bmb.dao.abst;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import org.bmb.dao.entity.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository @Transactional
public abstract class DaoAbstract<T,I extends Serializable> extends Session{
	protected Class<T> domainClass;
	public DaoAbstract(Class<T> domainClass) {
		this.domainClass=domainClass;
	}
	
	protected String defaultOrder=" order by id desc ";
	protected Order dOrder=Order.desc("id");

	@Transactional(readOnly=false)
	public void save(T domain) {
		sessionFactory.getCurrentSession().saveOrUpdate(domain);
	}


	@SuppressWarnings("unchecked")
	public T getById(I id) {
		return (T) sessionFactory.getCurrentSession().get(domainClass, id);
	}


	public void delete(T domain) {
		sessionFactory.getCurrentSession().delete(domain);
	}

	@SuppressWarnings("unchecked")
	public I count() {
		return (I) sessionFactory
				.getCurrentSession()
				.createQuery(
						"select count(*) from " + domainClass.getName() + " t")
				.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public I count(String column, String value) {
		String w=" where "+column+" like '"+value+"' ";
		return (I) sessionFactory
				.getCurrentSession()
				.createQuery(
						"select count(*) from " + domainClass.getName() + " t "+w)
				.uniqueResult();
	}
	
	

	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		return sessionFactory.getCurrentSession()
				.createQuery("from " + domainClass.getName()+" t "+defaultOrder).list();
	}

	@SuppressWarnings("unchecked")
	public List<T> getAll(int start, int num) {
		return sessionFactory.getCurrentSession()
				.createQuery("from " + domainClass.getName() +" t "+defaultOrder)
				.setFirstResult(start).setMaxResults(num).list();
	}
	@SuppressWarnings("unchecked")
	public List<T> getAll(String column,String value) {
		return sessionFactory.getCurrentSession()
				.createCriteria(domainClass).add( Restrictions.ilike(column, value)).addOrder( dOrder ).list();
	}
	@SuppressWarnings("unchecked")
	public List<T> getAll(String column,String value,int start, int num) {
		return sessionFactory.getCurrentSession()
				.createCriteria(domainClass).add( Restrictions.ilike(column, value)).addOrder( dOrder )
				.setFirstResult(start).setMaxResults(num).list();
	}

	@SuppressWarnings("unchecked")
	public T getOneByColumn(String column,Object value) {
		return (T) sessionFactory.getCurrentSession()
				.createCriteria(domainClass).add( Restrictions.like(column, value)).uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public T getOneByColumn(String column1,Object value1,String column2,Object value2) {
		return (T) sessionFactory.getCurrentSession()
				.createCriteria(domainClass)
				.add( Restrictions.like(column1, value1))
				.add( Restrictions.like(column2, value2))
				.uniqueResult();
	}
	@SuppressWarnings("unchecked")
	public T getOneByColumn(
			String column1,
			Object value1,
			String column2,
			Object value2,
			String column3,
			Object value3
			) {
		return (T) sessionFactory.getCurrentSession()
				.createCriteria(domainClass)
				.add( Restrictions.like(column1, value1))
				.add( Restrictions.like(column2, value2))
				.add( Restrictions.like(column3, value3))
				.uniqueResult();
	}
	@SuppressWarnings("unchecked")
	public BigInteger getNewId(String table) {
		return (BigInteger) sessionFactory
				.getCurrentSession()
				.createSQLQuery("select currval('s"+table+"')")
				.uniqueResult();
	}
	
	public void runSql(String sql){
		sessionFactory
		.getCurrentSession()
		.createSQLQuery(sql).executeUpdate();
	}
}
