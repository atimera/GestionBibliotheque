package com.opc.projet.gestionbiblio.business.contract;

import com.opc.projet.gestionbiblio.model.Address;

import java.util.List;

@SuppressWarnings({"JpaQueryApiInspection", "JpaQlInspection"})
public interface EmployeeRepositoryCustom {


    List<Address> findEmployeeAddresses(long employeeId);
    Address findEmployeeAddressById(long employeeId, long addressId);
    int deleteAddressFromEmployeeAddresses(long employeeId, long addressId);


}
