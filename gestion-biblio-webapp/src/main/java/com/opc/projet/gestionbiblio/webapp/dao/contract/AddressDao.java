package com.opc.projet.gestionbiblio.webapp.dao.contract;

import com.opc.projet.gestionbiblio.webapp.entity.Address;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Named;
import java.util.List;

@Named
public interface AddressDao {

    /**
     * Get all Adress from the db
     * @return list of Addresses
     */
    @Transactional
    public List<Address> getAddresses();

    /**
     * Add the Address to the db
     * @param address Address to save
     */
    @Transactional
    public void add(Address address);

    /**
     * Get an Address from db
     * @param addressId The Address id
     * @return The Address object
     */
    @Transactional
    public Address get(Integer addressId);

    /**
     * Delete the Address from the db
     * @param addressId the address id
     */
    @Transactional
    public void delete(Integer addressId);

}
