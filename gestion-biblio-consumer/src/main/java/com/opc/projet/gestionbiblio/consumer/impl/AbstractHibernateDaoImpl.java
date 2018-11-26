package com.opc.projet.gestionbiblio.consumer.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;


public class AbstractHibernateDaoImpl<T extends Serializable> {

    private Class< T > clazz;

    @Autowired
    SessionFactory sessionFactory;


    public final void setClazz(Class<T> clazzToSet){
        this.clazz = clazzToSet;
    }

    public T findOne(long id){
        return (T) getCurrentSession().get( clazz, id );
    }

    public List< T > findAll(){
        return getCurrentSession().createQuery( "from " + clazz.getName() ).list();
    }

    public void create(T entity){
        getCurrentSession().persist( entity );
    }

    public void update(T entity){
        getCurrentSession().merge( entity );
    }

    public void delete(T entity){
        getCurrentSession().delete( entity );
    }

    public void deleteById(long entityId) {
        T entity = findOne( entityId );
        delete( entity );
    }

    public final Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

}
