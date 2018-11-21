package com.opc.projet.gestionbiblio.webapp.bootstrap;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ComponentScan("com.opc.projet.gestionbiblio")
@ImportResource("classpath:/bootstrapContext.xml")
public class SpringConfiguration {

}
