package com.survey_app.survey_backend.security;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.survey_app.survey_backend.security.filter.JwtTokenValidator;
import com.survey_app.survey_backend.utils.JwtUtils;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

    @Autowired
    private JwtUtils jwtUtils;

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http
		.csrf(config -> config.disable())
		.cors(cors -> cors.configurationSource(corsConfigurationSource())) // Enable CORS
		.httpBasic(Customizer.withDefaults())
		.sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		.authorizeHttpRequests(authz -> {
			//configure public endpoints
			authz.requestMatchers(HttpMethod.POST, "/users/**").permitAll();
			authz.requestMatchers(HttpMethod.GET, "/users/**").hasRole("ADMIN");
			//configure private endpoints
			//authz.requestMatchers(HttpMethod.GET, "/users/create").hasRole("ADMIN");
			//configure remaining endpoints
			authz.anyRequest().denyAll();
		}).addFilterBefore(new JwtTokenValidator(jwtUtils), BasicAuthenticationFilter.class)
			.build();
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception{
		return authenticationConfiguration.getAuthenticationManager();
	}

	@Bean
	public AuthenticationProvider authenticationProvider(UserDetailsService userDetailsService){
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();        
		provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(userDetailsService);
        return provider;
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Collections.singletonList("http://localhost:5173")); 
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

}
