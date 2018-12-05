//package com.opc.projet.gestionbiblio.dao.impl;
//
//import com.opc.projet.gestionbiblio.entity.Address;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.query.Query;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.io.Serializable;
//import java.util.List;
//
//public abstract class AbstractDaoImpl< T extends Serializable> {
//
//    private Class< T > theClass;
//
//    @Autowired
//    SessionFactory sessionFactory;
//
//    public final void setTheClass(Class<T> pClass){
//        theClass = pClass;
//    }
//
//    public T findOne(long id){
//        return (T) getCurrentSession().get(theClass, id);
//    }
//
//    public List< ? > findAll(){
//
//        // get the current hibernate session
//
//        // create a query
//        System.out.println("\n\n" + theClass.getSimpleName() +"\n\n");
//        String sql = "from " + "Address";
//        Query<?> theQuery = getCurrentSession().createQuery(sql, Address.class);
//
//        // executre query and get results
//        return theQuery.getResultList();
//
////        List <?> resultList = getCurrentSession()
////                .createQuery("from " + theClass.getName())
////                .getResultList();
////
////        return resultList;
//    }
//
//    public void create(T entity){
//        getCurrentSession().persist(entity);
//    }
//
//    public void update(T entity){
//        getCurrentSession().merge(entity);
//    }
//
//    public void delete(T entity){
//        getCurrentSession().delete(entity);
//    }
//
//    public void deleteById(long entityId){
//        T theEntity = findOne( entityId );
//        delete( theEntity );
//    }
//
//    public final Session getCurrentSession(){
//        return sessionFactory.getCurrentSession();
//    }
//
//}
