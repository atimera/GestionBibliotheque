package com.opc.projet.gestionbiblio.business.contract;

import com.opc.projet.gestionbiblio.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

@SuppressWarnings("JpaQueryApiInspection")
public interface AddressRepository extends JpaRepository<Address, Long> {


}
