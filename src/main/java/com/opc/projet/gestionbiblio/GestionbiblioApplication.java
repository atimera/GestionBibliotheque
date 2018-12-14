package com.opc.projet.gestionbiblio;


import com.opc.projet.gestionbiblio.business.contract.AuthorRepositoryCustom;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.Locale;

@SpringBootApplication
public class GestionbiblioApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    AuthorRepositoryCustom authorRepository;

    
	public static void main(String[] args) {
		ApplicationContext ctx =  SpringApplication.run(GestionbiblioApplication.class, args);

	}

	// For i18n
    @Bean
    public LocaleResolver localeResolver(){
        AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
        localeResolver.setDefaultLocale(Locale.FRANCE);
        //localeResolver.setDefaultLocale(Locale.US);

        return localeResolver;
    }


    @Override
    public void run(String... args) throws Exception {
        //logger.info("===> All Authors -> {}", authorRepository.findAll());
        //logger.info("===> Author with Id 300003 -> {}", authorRepository.findById(300003L));
        //Author author = authorRepository.findById(300003L).get();
        //logger.info("===> Author's books -> {}", authorRepository.getAuthorBooks(300000L));
        //logger.info("===> Author's book By Id -> {}", authorRepository.getAuthorBookById(3000000L, 400003L));
    }
}
