/**
 * 
 */
package com.shop.mvc.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Bhautik Bhanani
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	DataSource dataSource;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.config.annotation.web.configuration.
	 * WebSecurityConfigurerAdapter#configure(org.springframework.security.config.
	 * annotation.authentication.builders.AuthenticationManagerBuilder)
	 */
	@Override
	@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery("SELECT email,password,1 FROM jdbc_user WHERE email=?")
				.authoritiesByUsernameQuery("SELECT email,role FROM user_role WHERE email=?");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.config.annotation.web.configuration.
	 * WebSecurityConfigurerAdapter#configure(org.springframework.security.config.
	 * annotation.web.builders.HttpSecurity)
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// http.authorizeRequests().antMatchers("/resources/**").permitAll().antMatchers("/login").access("permitAll")
		// .antMatchers("/**").access("hasRole('ROLE_USER')").and().formLogin().loginPage("/login")
		// .loginProcessingUrl("//j_spring_security_check").defaultSuccessUrl("/authLogin",
		// true)
		// .failureUrl("/login?error=failed").usernameParameter("email").passwordParameter("password").and()
		// .logout().logoutUrl("/j_spring_security_logout").logoutSuccessUrl("/logout").and().csrf();
		http.authorizeRequests().antMatchers("/**").permitAll();
	}
}
