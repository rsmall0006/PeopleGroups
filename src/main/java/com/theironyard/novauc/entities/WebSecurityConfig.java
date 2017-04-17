package com.theironyard.novauc.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by Merlin on 3/30/17.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                //this is programmatic security.... not declarative security...
                .authorizeRequests()
               // .antMatchers("/", "/index", "/index.jsp","*").permitAll()
                .antMatchers("/static/hd.html", "*").permitAll()
              //  .antMatchers("highlysecure.jsp").hasRole("SUPER_UNIQUE")
              //  .antMatchers("/filesForPres").hasRole("PRESDIENT")
                .anyRequest().authenticated()
                .and()
                .formLogin()
              //  .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();




    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("bob").password("pass").roles("USER");
        auth.inMemoryAuthentication().withUser("sally").password("pass").roles("USER");
        auth.inMemoryAuthentication().withUser("ross").password("pass").roles("SUPER_UNIQUE");
        auth.inMemoryAuthentication().withUser("pres").password("pass").roles("PRESIDENT");
    }
}
