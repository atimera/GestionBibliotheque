package com.opc.projet.gestionbiblio.webapp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    // Add reference to our security data source
    @Autowired
    DataSource securityDataSource;



    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        // use the jdbc authentication
        auth.jdbcAuthentication().dataSource(securityDataSource);

    }

    // We override this method if we don't want the default login form provided by spring
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                // roles management
                .antMatchers("/").hasRole("USER")
                .antMatchers("/").hasRole("EMPLOYEE")
                .antMatchers("/systems/**").hasRole("ADMIN")
                .antMatchers("/management/**").hasRole("MANAGER")
                .anyRequest().authenticated()

                // login form
                .and()
                .formLogin()
                .loginPage("/showMyLoginPage")
                .loginProcessingUrl("/authenticateTheUser")
                .permitAll()

                // logout
                .and()
                .logout().permitAll()

                // access denied page
                .and()
                .exceptionHandling().accessDeniedPage("/access-denied");

    }

}
