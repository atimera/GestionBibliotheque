package com.opc.projet.gestionbiblio.business.contract;

import com.opc.projet.gestionbiblio.model.Address;

import java.util.List;

@SuppressWarnings({"JpaQueryApiInspection", "JpaQlInspection"})
public interface MemberRepositoryCustom {


    List<Address> findMemberAddresses(long memberId);
    Address findMemberAddressById(long memberId, long addressId);
    int deleteAddressFromMemberAddresses(long memberId, long addressId);


}
