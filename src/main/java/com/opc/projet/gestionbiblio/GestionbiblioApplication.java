package com.opc.projet.gestionbiblio;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(
        exclude = { HibernateJpaAutoConfiguration.class }
)
public class GestionbiblioApplication {

	public static void main(String[] args) {
		ApplicationContext ctx =  SpringApplication.run(GestionbiblioApplication.class, args);

//        System.out.println("*************** Beans ******************");
//        System.out.println(ctx.getBeanDefinitionCount());
//        for (String beanName: ctx.getBeanDefinitionNames()) {
//            System.out.println(beanName);
//        }
//        System.out.println("*************** Beans ******************");
	}


}
