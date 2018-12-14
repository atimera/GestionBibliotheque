package com.opc.projet.gestionbiblio.business.contract;

import com.opc.projet.gestionbiblio.model.Address;

import java.util.List;

@SuppressWarnings({"JpaQueryApiInspection", "JpaQlInspection"})
public interface UserRepositoryCustom {

    List<Address> findUserAddresses(long userId);
    Address findUserAddressById(long userId, long addressId);
    int deleteAddressFromUserAddresses(long userId, long addressId);


}
