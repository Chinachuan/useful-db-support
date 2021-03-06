package com.useful.support;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;


public interface GenericDao {
	
	/**
	 * @desc    返回hibernate当前会话
	 * @version 2.0
	 * @return
	 */
	public Session getCurrentSession();
	
	/**
	 * @desc    持久化实例
	 * @version 2.0
	 * @param entity
	 * @return
	 * @throws DbException
	 */
	public <T> T save(T entity) throws DbException;
	
	public <T> T save(T entity,boolean fetch) throws DbException;
	
	/**
	 * 使用无状态session执行操作save，仅限于批量操作使用
	 * @param entity
	 * @return
	 * @throws DbException
	 */
	public <T> T saveByStateless(T entity) throws DbException;
	
	/**
	 * 新增或修改实体
	 * @param entity
	 * @return
	 * @throws DbException
	 */
	public <T> void saveOrUpdate(T entity) throws DbException;
	/**
	 * @desc    删除实例
	 * @version 2.0
	 * @param entity
	 * @throws DbException
	 */
	public void delete(Object entity) throws DbException;

	/**
	 * @desc    根据ID删除实例
	 * @version 2.0
	 * @param cls
	 * @param id
	 * @throws DbException
	 */
	public <T> void delete(Class<T> cls, Serializable id) throws DbException;

	/**
	 * @desc    更新实例
	 * @version 2.0
	 * @param entity
	 * @throws DbException
	 */
	public <T> T update(T entity) throws DbException;
	
	/**
	 * 使用无状态session执行操作，仅限于批量操作使用
	 * @param entity
	 * @return
	 * @throws DbException
	 */
	public <T> T updateByStateless(T entity) throws DbException;
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
	 * @desc    执行更新HQL语句
	 * @version 2.0
	 * @param hql
	 * @param params
	 * @throws DbException
	 */
	public void updateByHql(String hql, Object[] params) throws DbException;
	
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
	
	/**
	 * @desc    执行更新SQL语句
	 * @author  shuhui.wen
	 * @version 2.0
	 * @param sql
	 * @param params
	 * @throws DbException
	 */
	public void updateBySql(String sql,Object[] params) throws DbException;

	/**
	 * @desc    批量保存实体
	 * @version 2.0
	 * @param <T>
	 * @param objectList
	 * @throws DbException
	 */
	public <T> void saveBatch(final List<T> objectList)	throws DbException;

	/**
	 * @desc    批量更新实体
	 * @version 2.0
	 * @param objectList
	 * @throws DbException
	 */
	public <T> void updateBatch(final List<T> objectList) throws DbException;
	
}
