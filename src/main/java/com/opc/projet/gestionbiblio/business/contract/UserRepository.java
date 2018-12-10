package com.opc.projet.gestionbiblio.business.contract;

import com.opc.projet.gestionbiblio.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@SuppressWarnings({"JpaQueryApiInspection", "JpaQlInspection"})
public interface UserRepository extends JpaRepository<User, Long> {

//
//    // === find all
//    public List<User> findAll();
//
//    // === find by id
//    public User findById(long id);
//
//    // === insert / update
//    public User save(User user);
//
//    // === delete by id
//    public void deletById(long id);



}
