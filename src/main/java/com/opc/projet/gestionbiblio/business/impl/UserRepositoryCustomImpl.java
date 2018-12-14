package com.opc.projet.gestionbiblio.business.impl;

import com.opc.projet.gestionbiblio.business.contract.UserRepositoryCustom;
import com.opc.projet.gestionbiblio.model.Address;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@SuppressWarnings({"JpaQueryApiInspection", "JpaQlInspection"})
@Repository
public class UserRepositoryCustomImpl implements UserRepositoryCustom {

    // for connection to the db
    @PersistenceContext
    EntityManager em;

    @Override
    public List<Address> findUserAddresses(long userId) {
        TypedQuery<Address> query =
                em.createQuery(
                        "select a from User u  join u.locations a where u.id="+ userId, Address.class);
        return  query.getResultList();
    }

    @Override
    public Address findUserAddressById(long userId, long addressId) {
        TypedQuery<Address> query =
                em.createQuery(
                        "select a from User u  join u.locations a where u.id="+ userId +" and a.id="+ addressId,
                        Address.class);
        Address theAddress = null;
        try {
            theAddress = query.getSingleResult();
        }catch (Exception ignored){}

        return  theAddress;
    }


    @Transactional
    @Override
    public int deleteAddressFromUserAddresses(long userId, long addressId) {
        Query query = em.createNativeQuery(
                "DELETE FROM person_address pa WHERE pa.person_id=? and pa.address_id=?");

        query.setParameter(1, userId);
        query.setParameter(2, addressId);

        return query.executeUpdate();
    }


}
