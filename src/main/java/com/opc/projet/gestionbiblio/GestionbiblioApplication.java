package com.opc.projet.gestionbiblio;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class GestionbiblioApplication {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
//    @Autowired
//    private BookCopyRepository repository;

    
	public static void main(String[] args) {
		ApplicationContext ctx =  SpringApplication.run(GestionbiblioApplication.class, args);

//        System.out.println("*************** Beans ******************");
//        System.out.println(ctx.getBeanDefinitionCount());
//        for (String beanName: ctx.getBeanDefinitionNames()) {
//            System.out.println(beanName);
//        }
//        System.out.println("*************** Beans ******************");
	}


//    // === execute a command line on start up
//    @Override
//    public void run(String... args) throws Exception {
//
//        logger.info("\n====> All Copies -> {}");
//        repository.findAll().forEach(System.out::println);
//        //Book book = repository.findById(400000);
//        //logger.info("\n====> BOOK with ID 400002 -> {}", book);
//
//        //logger.info("== > All copies -> {} ", book.getCopies());
//
//        //System.out.println(member.getLendedCopies());
//
//
//        //logger.info("==-> Saved Author -> {}", bookRepository.save(book));
//
//        //bookRepository.deletById(400002L);
//
//        //logger.info("\n====> All Books -> {}", bookRepository.findAll());
//
//        //logger.info("Deleting author .....");
//        //authorRepository.deletById(1);
//
//    }


}
