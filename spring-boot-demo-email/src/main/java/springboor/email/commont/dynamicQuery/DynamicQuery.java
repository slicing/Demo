package springboor.email.commont.dynamicQuery;

import java.util.List;

/*
* 扩展SpringDataJpa,支持动态jpql/nativesql查询并支持分页查询
* 使用方法，注入ServiceImpl
* */
public interface DynamicQuery {
	public void save(Object entity);
	public void update(Object entity);
	public <T> void  delete(Class<T> entityClass,Object entityid);
	public <T> void delete(Class<T> entityClass,Object[] entityids);
	<T>List<T> nativeQueryList(String nativeSql,Object... params);
	<T>List<T> nativeQueryListMap(String nativeSql,Object... params);
	<T> List<T> nativeQueryListModel(Class<T> resultClass, String nativeSql, Object... params);
	Long nativeQueryCount(String nativeSql, Object... params);
}
