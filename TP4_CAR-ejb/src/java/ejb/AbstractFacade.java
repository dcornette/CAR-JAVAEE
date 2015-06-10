/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.persistence.EntityManager;

/**
 * Facade which enable you to abstract some operations
 */
public abstract class AbstractFacade<T> {
    private Class<T> entityClass;
    
    /**
     * Abstract constructor
     * @param entityClass 
     */
    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    /**
     * Create an entity
     * @param entity 
     */
    public void create(T entity) {
        getEntityManager().persist(entity);
    }

    /**
     * Edit an entity
     * @param entity 
     */
    public void edit(T entity) {
        getEntityManager().merge(entity);
    }

    /**
     * Remove the entity created
     * @param entity 
     */
    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    /**
     * Find the correct object created
     * @param id
     * @return the object with the correct id
     */
    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    /**
     * Return the list of all objects
     * @return 
     */
    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    /**
     * Return a range of objects
     * @param range
     * @return 
     */
    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    /**
     * Count the number of objects present in the list
     * @return 
     */
    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
    
}
