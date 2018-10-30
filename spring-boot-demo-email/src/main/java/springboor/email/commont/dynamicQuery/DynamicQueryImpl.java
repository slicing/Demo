package springboor.email.commont.dynamicQuery;



import org.hibernate.SQLQuery;
import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


public class DynamicQueryImpl implements DynamicQuery {
	Logger logger = LoggerFactory.getLogger(DynamicQueryImpl.class);
	@PersistenceContext
	private EntityManager em;
	public EntityManager getEntityManager(){
		return em;
	}
	@Override
	public void save(Object entity) {
		em.persist(entity);
	}

	@Override
	public void update(Object entity) {
		em.persist(entity);
	}

	@Override
	public <T> void delete(Class<T> entityClass, Object entityid) {
		delete(entityClass,new Object[]{
				entityid
		});
	}

	@Override
	public <T> void delete(Class<T> entityClass, Object[] entityids) {
		for (Object id:entityids){
			em.remove(em.getReference(entityClass,id));
		}
	}

	public Query createNativeQuery(String sql,Object... params){
		Query q = em.createNativeQuery(sql);
		if (params != null && params.length >0){
			for (int i = 0;i<params.length;i++){
				q.setParameter(i+1,params[i]);
			}
		}
		return q;
	}

	@SuppressWarnings({"unchecked"})
	@Override
	public <T> List<T> nativeQueryList(String nativeSql, Object... params) {
		Query q = createNativeQuery(nativeSql,params);
		q.unwrap(NativeQueryImpl.class).setResultTransformer(Transformers.TO_LIST);
		return q.getResultList();
	}


	@Override
	public <T> List<T> nativeQueryListMap(String nativeSql, Object... params) {
		Query q = createNativeQuery(nativeSql,params);
		q.unwrap(NativeQueryImpl.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		return q.getResultList();
	}

	@Override
	public <T> List<T> nativeQueryListModel(Class<T> resultClass, String nativeSql, Object... params) {
		Query q = createNativeQuery(nativeSql,params);
		q.unwrap(NativeQueryImpl.class).setResultTransformer(Transformers.aliasToBean(resultClass));
		return q.getResultList();
	}

	@Override
	public Long nativeQueryCount(String nativeSql, Object... params) {
		Object count = createNativeQuery(nativeSql,params).getSingleResult();
		return ((Number)count).longValue();
	}
}
