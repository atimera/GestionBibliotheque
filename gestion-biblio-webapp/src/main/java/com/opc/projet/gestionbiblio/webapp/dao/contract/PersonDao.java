package com.opc.projet.gestionbiblio.webapp.dao.contract;

import com.opc.projet.gestionbiblio.webapp.entity.Person;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PersonDao {

    @Transactional
    public void add(Person person);

    @Transactional
    public int getPerson(Integer personId);

    @Transactional
    public List<Person> getPersons();

}
