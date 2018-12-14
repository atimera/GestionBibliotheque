package com.opc.projet.gestionbiblio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@SuppressWarnings("JpaQlInspection")

@ApiModel("L'entité User qui étend l'entend Person")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User extends Person{


    @Email
    protected String email;

    @ApiModelProperty("Obligatoire et doit avoir au moins 2 caractères")
    @NotBlank(message = "Obligatoire")
    @Size(min = 2, message = "Doit avoir au moins 2 caractères")
    protected String username;

    @JsonIgnore
    protected String password;

    @JsonIgnore
    @Column(insertable = false)
    protected String passwordConfirmation;

    @JsonIgnore
    protected Boolean enabled;

    @CreationTimestamp
    @Column(updatable = false)
    protected Date registeredAt;


}
