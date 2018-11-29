package com.opc.projet.gestionbiblio.webapp.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opc.projet.gestionbiblio.webapp.entity.Member;

import java.io.File;

public class JacksonDemo {

    public static void main(String[] args) {

        File file = new File("data/sample-lite.json");

        System.out.println(file.exists());


        try {

            // create object mapper
            ObjectMapper objectMapper = new ObjectMapper();


            // read JSON file and map/convert to java POJO
            // file: data/sample-lite.json
            Member theMember = objectMapper.readValue(file, Member.class);

            // print object attributes or use the object
            System.out.println(
                    "Id : "+ theMember.getId()
                    +"\nPrénom : "+ theMember.getFirstName()
                    +"\nNom : "+ theMember.getLastName()
                    +"\nEmail : "+ theMember.getEmail()
                    +"\nMot de passe : "+ theMember.getPassword()

            );


        }catch (Exception exc){
            exc.printStackTrace();
        }

    }

}
