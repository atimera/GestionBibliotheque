package com.opc.projet.gestionbiblio.webapp.dao.contract;

import com.opc.projet.gestionbiblio.webapp.entity.Person;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Named;
import java.util.List;

@Named
public interface PersonDao {

    @Transactional
    public void add(Person person);

    @Transactional
    public int getPerson(Integer personId);

    @Transactional
    public List<Person> getPersons();

}
