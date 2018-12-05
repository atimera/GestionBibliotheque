package com.opc.projet.gestionbiblio.service.impl;

import com.opc.projet.gestionbiblio.model.Address;
import com.opc.projet.gestionbiblio.service.contract.AddressService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;

@Service
@Profile("jpadao")
public class AddressServiceJpaDaoImpl implements AddressService {

    private EntityManagerFactory emf;

    @PersistenceUnit
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public List<Address> getAll() {
        EntityManager em = emf.createEntityManager();
        List<Address> list = em.createQuery("from Address", Address.class).getResultList();
        System.out.println("\n************ LISTE ***************");
        System.out.println(list);
        System.out.println("\n************ LISTE ***************");
        return list;
    }

    @Override
    public Address getById(Integer id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Address.class, id);
    }

    @Override
    public Address saveOrUpdate(Address domainObject) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Address savedAddress = em.merge(domainObject);

        em.getTransaction().commit();
        return savedAddress;
    }

    @Override
    public void delete(Integer id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.remove(em.find(Address.class, id));

        em.getTransaction().commit();
    }
}
