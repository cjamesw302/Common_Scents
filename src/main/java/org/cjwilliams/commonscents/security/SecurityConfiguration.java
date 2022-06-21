package org.cjwilliams.commonscents.security;

import org.cjwilliams.commonscents.model.Users;
import org.cjwilliams.commonscents.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//Security configuration file for spring security

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
   @Autowired
   private UserService userService;
   
   Users user = new Users();
   
   //Specifies available files for unauthenticated users, login configuration, and logout configuration
   
   @Override
   protected void configure(HttpSecurity http) throws Exception{
	   http
	   .authorizeRequests().antMatchers("/", "/registration", "/js/**","/css/**","/img/**").permitAll().anyRequest().authenticated()
       .and().formLogin().loginPage("/login").defaultSuccessUrl("/payment").permitAll()         
       .and().logout().logoutSuccessUrl("/").permitAll();
   }
   
   //Password encoder for user passwords
   
   @Bean
   public BCryptPasswordEncoder passwordEncoder(){
       return new BCryptPasswordEncoder();
   }
   
   //Retrieves user details for UserDetailsService
   
   @Bean
   public DaoAuthenticationProvider authenticationProvider(){
       DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
       auth.setUserDetailsService(userService);
       auth.setPasswordEncoder(passwordEncoder());
       return auth;
   }
   
   //Configures authenticationProvider based on instance of AuthenticationManagerBuilder
   
   @Override
   protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.authenticationProvider(authenticationProvider());
   }
}