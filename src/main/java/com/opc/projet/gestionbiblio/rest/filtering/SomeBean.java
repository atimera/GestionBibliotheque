package com.opc.projet.gestionbiblio.rest.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
//@JsonIgnoreProperties(value = {"field1"}) // 1 way to do
@JsonFilter("SomeBeanFilter")
public class SomeBean {

    private String field1;
    private String field2;

    //@JsonIgnore // another way to do
    private String field3;

}
