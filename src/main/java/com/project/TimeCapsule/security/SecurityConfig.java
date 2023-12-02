package com.project.TimeCapsule.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.project.TimeCapsule.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	 private final CustomSuccessHandler customSuccessHandler;
	    private final CustomUserDetailsService customUserDetailsService;
	    private final PasswordEncoder passwordEncoder;

	    @Autowired
	    public SecurityConfig(CustomSuccessHandler customSuccessHandler, CustomUserDetailsService customUserDetailsService,
	                          PasswordEncoder passwordEncoder) {
	        this.customSuccessHandler = customSuccessHandler;
	        this.customUserDetailsService = customUserDetailsService;
	        this.passwordEncoder = passwordEncoder;
	    }

	    @SuppressWarnings("deprecation")
		@Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        http.csrf().disable()
	        		.authorizeRequests(authorizeRequests ->
	        				authorizeRequests
	        						.requestMatchers("/admin-page").hasAuthority("ADMIN")
	        						.requestMatchers("/user-page").hasAuthority("USER")
	        						.requestMatchers("/login", "/register", "/error", "/css/**").permitAll()
	        						.requestMatchers("/", "/index").authenticated()
	        						.anyRequest().authenticated()
	        		)
	                .formLogin(form ->
	                        form
	                                .loginPage("/login")
	                                .loginProcessingUrl("/login")
	                                .successHandler(new CustomSuccessHandler())
	                                .permitAll()
	                )
	                .logout(logout ->
	                        logout
	                                .invalidateHttpSession(true)
	                                .clearAuthentication(true)
	                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
	                                .logoutSuccessUrl("/login?logout")
	                                .permitAll()
	                );

	        return http.build();
	    }

	    @Autowired
	    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	        auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder);
	    }

}