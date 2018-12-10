package com.opc.projet.gestionbiblio.business;

import com.opc.projet.gestionbiblio.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@SuppressWarnings({"JpaQueryApiInspection", "JpaQlInspection"})
@Repository
@Transactional
public class UserRepository {

    // for connection to the db
    @PersistenceContext
    EntityManager em;

    // === find all
    public List<User> findAll(){

        TypedQuery<User> namedQuery = em.createNamedQuery("find_all_users", User.class);
        return namedQuery.getResultList();
    }

    // === find by id
    public User findById(long id){
        return em.find(User.class, id);
    }

    // === insert / update
    public User save(User user){
        if(user.getId() == null){
            em.persist(user);
        }else {
            em.merge(user);
        }
        return user;
    }

    // === delete by id
    public void deletById(long id){
        User user = findById(id);
        if(user != null)
            em.remove(user);
    }



}
