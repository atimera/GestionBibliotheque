package com.opc.projet.gestionbiblio.webapp.dao.contract;

import com.opc.projet.gestionbiblio.webapp.entity.Address;

import java.util.List;


public interface AddressDao {

    /**
     * Get all Adress from the db
     * @return list of Addresses
     */
    public List<Address> getAddresses();

    /**
     * Add the Address to the db
     * @param address Address to save
     */
    public void save(Address address);

    /**
     * Get an Address from db
     * @param id The Address id
     * @return The Address object
     */
    public Address get(Integer id);

    /**
     * Delete the Address from the db
     * @param id the address id
     */
    public void delete(Integer id);

}
