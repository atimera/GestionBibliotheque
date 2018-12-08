package com.opc.projet.gestionbiblio.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@SuppressWarnings("JpaQlInspection")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQueries({
        @NamedQuery(name = "find_all_users", query = "select u from User u")
})
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public abstract class User extends Person{

    protected String username;
    protected String password;
    @Column(insertable = false)
    protected String passwordConfirmation;
    protected Boolean enabled;
    @CreationTimestamp
    @Column(updatable = false)
    protected Date registeredAt;


}
