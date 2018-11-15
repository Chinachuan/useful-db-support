package com.useful.support;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;

/**    
 * @version 2.0     
 * @created Oct 29, 2012 10:29:16 AM    
 */
public interface  QueryDao {
	
	/**
	 * @desc    返回hibernate当前会话
	 * @version 2.0
	 * @return
	 */
	public Session getCurrentSession();
	

	/**
	 * @desc    根据ID查询实例
	 * @version 2.0
	 * @param cls
	 * @param id
	 * @return
	 * @throws DbException
	 */
	public <T> T findById(Class<T> cls, Serializable id) throws DbException;
	/**
	 * @desc    执行查询HQL语句
	 * @version 2.0
	 * @param hql
	 * @param params
	 * @return
	 * @throws DbException
	 */
	public List findByHql(String hql, Object[] params) throws DbException;
	
	/**
	 * @desc    分页查询
	 * @version 2.0
	 * @param hql
	 * @param params
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 * @throws DbException
	 */
	public List findByPage(String hql, Object[] params, int pageIndex, int pageSize) throws DbException;
	
	public  List findByPageForSql(String sql, Object[] params, int pageIndex, int pageSize) throws DbException;
	
	public  List findByPageForSqlToMap(String sql, Object[] params , int pageIndex, int pageSize) throws DbException;
	
	
	/**
	 * @desc    执行查询SQL语句
	 * @version 2.0
	 * @param sql
	 * @param params
	 * @return
	 * @throws DbException
	 */
	public List findBySql(String sql,Object[] params) throws DbException;
	
	
	/**
	 * @desc    执行查询SQL语句
	 * @version 2.0
	 * @param sql
	 * @param params
	 * @return
	 * @throws DbException
	 */
	public List findBySql(String sql,Class entityType,Object[] params) throws DbException;
	
	/**
	 * @desc    执行查询SQL语句
	 * @version 2.0
	 * @param sql
	 * @param params
	 * @return
	 * @throws DbException
	 */
	public List findBySqlListMap(String sql,Object[] params) throws DbException;
}
