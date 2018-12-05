//package com.opc.projet.gestionbiblio.config;
//
//import com.mchange.v2.c3p0.ComboPooledDataSource;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.core.env.Environment;
//import org.springframework.orm.hibernate5.HibernateTransactionManager;
//import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//import org.springframework.web.servlet.ViewResolver;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.springframework.web.servlet.view.InternalResourceViewResolver;
//
//import javax.sql.DataSource;
//import java.beans.PropertyVetoException;
//import java.util.Properties;
//import java.util.logging.Logger;
//
//@Configuration
//@EnableWebMvc // similar to <mvc:resources> in the XML set up
//@EnableTransactionManagement //
//@ComponentScan(basePackages = "com.opc.projet.gestionbiblio")
//@PropertySource({"classpath:/app.resources.properties"}) // for reading properties files
//public class ApplicationConfig implements WebMvcConfigurer {
//
//    // set up a variable to hold the properties
//    @Autowired
//    private Environment env; // springframework.core.env
//
//    // set up a logger for diagnostics
//    private Logger logger = Logger.getLogger(getClass().getName()); // java.util.logging.Logger
//
//    /**
//     * bean for ViewResolver
//     *
//     * @return the viewResolver
//     */
//    @Bean
//    public ViewResolver viewResolver(){
//        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//
//        viewResolver.setPrefix("/resources/templates/**");
//        viewResolver.setSuffix(".jsp");
//
//        return viewResolver;
//    }
//
//    /**
//     * Define a bean for the security datasource
//     *
//     * @return a javax.sql.DataSource object
//     */
//    @Bean
//    public DataSource myDatasource(){
//
//        // create a connection pool
//        ComboPooledDataSource myDatasource =
//                new ComboPooledDataSource();
//
//        // set up the jdbc driver class
//        try {
//            myDatasource.setDriverClass(env.getProperty("jdbc.driver"));
//        } catch (PropertyVetoException exc) {
//            throw new RuntimeException(exc);
//        }
//
//        // log the connections properties / for info
//        logger.info("\n\t>>> JDBC.URL = " + env.getProperty("jdbc.url"));
//        logger.info("\n\t>>> JDBC.USER = " + env.getProperty("jdbc.user"));
//
//        // set up the database connections properties
//        myDatasource.setJdbcUrl(env.getProperty("jdbc.url"));
//        myDatasource.setUser(env.getProperty("jdbc.user"));
//        myDatasource.setPassword(env.getProperty("jdbc.password"));
//
//        // set up connection pool properties
//        myDatasource.setInitialPoolSize(
//                getIntProperty("connection.pool.initialPoolSize"));
//
//        myDatasource.setMinPoolSize(
//                getIntProperty("connection.pool.minPoolSize"));
//
//        myDatasource.setMaxPoolSize(
//                getIntProperty("connection.pool.maxPoolSize"));
//
//        myDatasource.setMaxIdleTime(
//                getIntProperty("connection.pool.maxIdleTime"));
//
//        return myDatasource;
//
//    }
//
//    private Properties getHibernateProperties() {
//
//        // set hibernate properties
//        Properties props = new Properties();
//
//        props.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
//        props.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
//
//        return props;
//    }
//
//    @Bean
//    public LocalSessionFactoryBean sessionFactory(){
//
//        // create session factorys
//        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//
//        // set the properties
//        sessionFactory.setDataSource(myDatasource());
//        sessionFactory.setPackagesToScan(env.getProperty("hibernate.packagesToScan"));
//        sessionFactory.setHibernateProperties(getHibernateProperties());
//
//        return sessionFactory;
//    }
//
//    @Bean
//    @Autowired
//    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
//
//        // setup transaction manager based on session factory
//        HibernateTransactionManager txManager = new HibernateTransactionManager();
//        txManager.setSessionFactory(sessionFactory);
//
//        return txManager;
//    }
//
//
//
//    /**
//     * A helper method
//     * Read environment property and convert to int
//     * @param propertyName the property name
//     * @return the int value of the property
//     */
//    private int getIntProperty(String propertyName){
//        String propVal = env.getProperty(propertyName);
//        int intPropVal = Integer.parseInt(propVal);
//        return intPropVal;
//    }
//
//
//    // static resources
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
//    }
//}
