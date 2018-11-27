package com.opc.projet.gestionbiblio.consumer.contract;

import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;

public interface AbstractHibernateDao< T extends Serializable> {

    void setClazz(Class clazzToSet);

    Serializable findOne(long id);

    List findAll();

    void create(Serializable entity);

    void update(Serializable entity);

    void delete(Serializable entity);

    void deleteById(long entityId);

    Session getCurrentSession();
}
