//package com.opc.projet.gestionbiblio.webapp.security;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
//
//@Configuration
//@EnableWebSecurity
//public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//        // add ours users for in memory authentication (just for testing purpose)
//        User.UserBuilder users = User.withDefaultPasswordEncoder();
//
//        auth.inMemoryAuthentication()
//                .withUser(users.username("hamza").password("hamza").roles("ADMIN", "MANAGER"))
//                .withUser(users.username("test").password("test").roles("USER"))
//                .withUser(users.username("laenzo").password("laenzo").roles("ADMIN"));
//
//    }
//
//    // We override this method if we don't want the default login form provided by spring
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http.authorizeRequests()
//                .antMatchers("/").hasRole("USER")
//                .antMatchers("/showAdmins").hasRole("ADMIN")
//                .antMatchers("/showEmployees").hasRole("EMPLOYEE")
//                .antMatchers("/showManagers").hasRole("MANAGER")
//                .anyRequest().authenticated()
//            .and()
//            .formLogin()
//                .loginPage("/showMyLoginPage")
//                .loginProcessingUrl("/authenticateTheUser")
//                .permitAll()
//            .and()
//            .logout().permitAll()
//            .and()
//            .exceptionHandling().accessDeniedPage("/access-denied");
//
//    }
//}
