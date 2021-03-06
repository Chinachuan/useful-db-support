package com.useful.support;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @version 2.0
 * @created Oct 29, 2012 10:01:57 AM
 */
@Service
@SuppressWarnings({"unchecked", "rawtypes" })
public class QueryDaoImpl implements QueryDao {
	@Autowired(required=false)
	@Qualifier("querySessionFactory")  
	private SessionFactory querySessionFactory;
	/**
	 * @description 返回当前SESSION
	 */
	public Session getCurrentSession() {
		return querySessionFactory.getCurrentSession();
	}

	
	/**
	 * @description 根据nameQuery查询
	 */
	public List findBySql(String sql, Object[] params)
			throws DbException {
		try {
			Query query = getCurrentSession().createSQLQuery(sql);
			if (params != null) {
				for (int i = 0; i < params.length; i++)
					query.setParameter(i, params[i]);
			}
			return query.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DbException("[DAO层]QueryDao.findBySql()出错", e);
		}
	}
	
	/**
	 * @description 根据nameQuery查询
	 */
	public List findBySql(String sql,Class entityType, Object[] params)
			throws DbException {
		try {
			Query query = getCurrentSession().createSQLQuery(sql).addEntity(entityType);
			if (params != null) {
				for (int i = 0; i < params.length; i++)
					query.setParameter(i, params[i]);
			}
			return query.list();
		} catch (Exception e) {
			throw new DbException("[DAO层]QueryDao.findBySql()出错", e);
		}
	}
	
	/**
	 * @description 根据nameQuery查询
	 */
	public List findBySqlListMap(String sql,Object[] params) throws DbException {
		try {
			Query query = getCurrentSession().createSQLQuery(sql);
			//设定结果结果集中的每个对象为Map类型   
			query.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);
			if (params != null) {
				for (int i = 0; i < params.length; i++)
					query.setParameter(i, params[i]);
			}
			return query.list();
		} catch (Exception e) {
			throw new DbException("[DAO层]QueryDao.findBySql()出错", e);
		}
	}

	/**
	 * @description 根据hql查询
	 */
	public  List findByHql(String hql, Object[] params)
			throws DbException {
		try {
			Query query = getCurrentSession().createQuery(hql);
			if (params != null) {
				for (int i = 0; i < params.length; i++)
					query.setParameter(i, params[i]);
			}
			return query.list();
		} catch (Exception e) {
			throw new DbException("[DAO层]QueryDao.findByHql()出错", e);
		}
	}
	
	/**
	 * @description 根据hql查询(分页)
	 */
	public  List findByPage(String hql, Object[] params, int pageIndex, int pageSize)
			throws DbException {
		try {
			Query query = getCurrentSession().createQuery(hql);
			if (params != null) {
				for (int i = 0; i < params.length; i++)
					query.setParameter(i, params[i]);
			}
			query.setFirstResult((pageIndex-1)*pageSize);
			query.setMaxResults(pageSize);
			return query.list();
		} catch (Exception e) {
			throw new DbException("[DAO层]QueryDao.findByPage()出错", e);
		}
	}
	/**
	 * @desc    查询分页记录数
	 * @version 2.0
	 * @param sql
	 * @param params
	 * @return
	 * @throws DbException
	 */
	public  List findByPageForSql(String sql, Object[] params, int pageIndex, int pageSize)
			throws DbException {
		try {
			Query query = getCurrentSession().createSQLQuery(sql);
			if (params != null) {
				for (int i = 0; i < params.length; i++)
					query.setParameter(i, params[i]);
			}
			query.setFirstResult((pageIndex-1)*pageSize);
			query.setMaxResults(pageSize);
			return query.list();
		} catch (Exception e) {
			throw new DbException("[DAO层]QueryDao.findByPage()出错", e);
		}
	}
	
	
	/**
	 * @desc    查询分页记录数
	 * @version 2.0
	 * @param sql
	 * @param params
	 * @return
	 * @throws DbException
	 */
	public  List findByPageForSqlToMap(String sql, Object[] params, int pageIndex, int pageSize)
			throws DbException {
		try {
			Query query = getCurrentSession().createSQLQuery(sql);
			//设定结果结果集中的每个对象为Map类型   
			query.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);
			if (params != null) {
				for (int i = 0; i < params.length; i++)
					query.setParameter(i, params[i]);
			}
			query.setFirstResult((pageIndex-1)*pageSize);
			query.setMaxResults(pageSize);
			return query.list();
		} catch (Exception e) {
			throw new DbException("[DAO层]QueryDao.findByPage()出错", e);
		}
	}
	
	

	/**
	 * @description 根据class和id查询
	 */
	public <T> T findById(Class<T> cls, Serializable id) throws DbException {
		try {
			return (T)getCurrentSession().get(cls, id);
		} catch (Exception e) {
			throw new DbException("[DAO层]QueryDao.findById(Class<T> cls, Serializable id)出错", e);
		}
	}
	/**
	 * @desc    查询分页记录数
	 * @author  shuhui.wen
	 * @version 2.0
	 * @param hql
	 * @param params
	 * @return
	 * @throws DbException
	 */
	protected Object findPageCountByHql(String hql, Object[] params) throws DbException{
		List<Object> list = findByHql(hql, params);
		if(list == null || list.size()==0)return 0;
		return list.get(0);
	}
	/**
	 * @desc    查询分页记录数
	 * @author  shuhui.wen
	 * @version 2.0
	 * @param hql
	 * @param params
	 * @return
	 * @throws DbException
	 */
	protected Object findPageCountBySql(String sql, Object[] params) throws DbException{
		List<Object> list = findBySql(sql, params);
		if(list == null || list.size()==0)return 0;
		return list.get(0);
	}


	public SessionFactory getQuerySessionFactory() {
		return querySessionFactory;
	}


	public void setQuerySessionFactory(SessionFactory querySessionFactory) {
		this.querySessionFactory = querySessionFactory;
	}
	
	

}
