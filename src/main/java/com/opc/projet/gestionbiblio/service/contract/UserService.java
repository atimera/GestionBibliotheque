package com.opc.projet.gestionbiblio.service.contract;

import com.opc.projet.gestionbiblio.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<User> getAll();
    User getById(long id);
    User save(User user);
    void deleteById(long id);

}
