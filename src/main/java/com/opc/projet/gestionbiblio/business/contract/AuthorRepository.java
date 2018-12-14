package com.opc.projet.gestionbiblio.business.contract;

import com.opc.projet.gestionbiblio.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

@SuppressWarnings({"JpaQueryApiInspection", "JpaQlInspection"})
public interface AuthorRepository extends JpaRepository<Author, Long> {



}
