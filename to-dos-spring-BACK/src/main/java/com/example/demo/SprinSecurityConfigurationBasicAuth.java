package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SprinSecurityConfigurationBasicAuth extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable() //deshabilitar csrf
		.authorizeRequests((requests) -> //permite autenticar todas las peticiones excepto las que incluyen OPTIONS
			requests.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
			.anyRequest().authenticated());
		http.headers().frameOptions().disable();//corrige error de navegador para mostrar h2-console
		//http.formLogin();
		http.httpBasic();//use http basic
	}
}
