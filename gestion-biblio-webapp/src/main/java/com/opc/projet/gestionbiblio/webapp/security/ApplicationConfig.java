package com.opc.projet.gestionbiblio.webapp.security;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.logging.Logger;

@Configuration
@EnableWebMvc // similar to <mvc:resources> in the XML set up
@ComponentScan(basePackages = "com.opc.projet.gestionbiblio.webapp")
@PropertySource("classpath:config/persistence-mysql.properties") // for reading properties files
public class ApplicationConfig {

    // set up a variable to hold the properties
    @Autowired
    private Environment env; // springframework.core.env

    // set up a logger for diagnostics
    private Logger logger = Logger.getLogger(getClass().getName()); // java.util.logging.Logger

    /**
     * bean for ViewResolver
     *
     * @return the viewResolver
     */
    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }

    /**
     * Define a bean for the security datasource
     *
     * @return a javax.sql.DataSource object
     */
    @Bean
    public DataSource securityDataSource(){

        // create a connection pool
        ComboPooledDataSource securityDataSource =
                                new ComboPooledDataSource();

        // set up the jdbc driver class
        try {
            securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));
        } catch (PropertyVetoException exc) {
            throw new RuntimeException(exc);
        }

        // log the connections properties / for info
        logger.info("\n\t>>> JDBC.URL = " + env.getProperty("jdbc.url"));
        logger.info("\n\t>>> JDBC.USER = " + env.getProperty("jdbc.user"));

        // set up the database connections properties
        securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
        securityDataSource.setUser(env.getProperty("jdbc.user"));
        securityDataSource.setPassword(env.getProperty("jdbc.password"));

        // set up connection pool properties
        securityDataSource.setInitialPoolSize(
                getIntProperty("connection.pool.initialPoolSize"));

        securityDataSource.setMinPoolSize(
                getIntProperty("connection.pool.minPoolSize"));

        securityDataSource.setMaxPoolSize(
                getIntProperty("connection.pool.maxPoolSize"));

        securityDataSource.setMaxIdleTime(
                getIntProperty("connection.pool.maxIdleTime"));

        return securityDataSource;

    }


    /**
     * A helper method
     * Read environment property and convert to int
     * @param propertyName the property name
     * @return the int value of the property
     */
    private int getIntProperty(String propertyName){
        String propVal = env.getProperty(propertyName);
        int intPropVal = Integer.parseInt(propVal);
        return intPropVal;
    }
}
