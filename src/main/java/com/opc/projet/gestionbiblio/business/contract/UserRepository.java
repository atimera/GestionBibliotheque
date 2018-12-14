package com.opc.projet.gestionbiblio.business.contract;

import com.opc.projet.gestionbiblio.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

@SuppressWarnings({"JpaQueryApiInspection", "JpaQlInspection"})
public interface UserRepository extends JpaRepository<User, Long> {


}
