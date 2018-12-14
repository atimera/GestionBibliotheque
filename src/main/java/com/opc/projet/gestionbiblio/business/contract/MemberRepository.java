package com.opc.projet.gestionbiblio.business.contract;

import com.opc.projet.gestionbiblio.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

@SuppressWarnings({"JpaQueryApiInspection", "JpaQlInspection"})
public interface MemberRepository extends JpaRepository<Member, Long> {

}
