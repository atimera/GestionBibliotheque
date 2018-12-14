package com.opc.projet.gestionbiblio.business.impl;

import com.opc.projet.gestionbiblio.business.contract.MemberRepositoryCustom;
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
public class MemberRepositoryCustomImpl implements MemberRepositoryCustom {

    // for connection to the db
    @PersistenceContext
    EntityManager em;

    @Override
    public List<Address> findMemberAddresses(long memberId) {
        TypedQuery<Address> query =
                em.createQuery(
                        "select a from Member u  join u.locations a where u.id="+ memberId, Address.class);
        return  query.getResultList();
    }

    @Override
    public Address findMemberAddressById(long memberId, long addressId) {
        TypedQuery<Address> query =
                em.createQuery(
                        "select a from Member u  join u.locations a where u.id="+ memberId +" and a.id="+ addressId,
                        Address.class);
        Address theAddress = null;
        try {
            theAddress = query.getSingleResult();
        }catch (Exception ignored){}

        return  theAddress;
    }


    @Transactional
    @Override
    public int deleteAddressFromMemberAddresses(long memberId, long addressId) {
        Query query = em.createNativeQuery(
                "DELETE FROM person_address pa WHERE pa.person_id=? and pa.address_id=?");

        query.setParameter(1, memberId);
        query.setParameter(2, addressId);

        return query.executeUpdate();
    }


}
