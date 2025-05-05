package com.example.chatapp.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import com.example.chatapp.service.AuthenticationService;
import com.example.chatapp.service.CustomerUserDetailService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private CustomerUserDetailService customerUserDetailService;

	@Autowired
	private JwtAuthenticationFilter jwtAuthenticationFilter;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(requests -> requests.requestMatchers("/ws/**", "/topic/**", "/app/**")
						.permitAll().requestMatchers("/auth/**", "/error/**")
						.permitAll().anyRequest().authenticated())
				.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
			.cors(cors -> cors.configurationSource(request -> {
	            CorsConfiguration config = new CorsConfiguration();
	            config.setAllowedOriginPatterns(List.of("*")); // ✅ Angular frontend
	            config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE"));
	            config.setAllowedHeaders(List.of("*"));
	            config.setAllowCredentials(true);
	            return config;
	        }));
//				.logout(logout -> logout.logoutUrl("/logout").logoutSuccessUrl("/login") // Đăng xuất xong về login
//						.permitAll());
		return http.build();
	}

//	@Bean
//	public AuthenticationManager authenticationManager() {
//		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//		authProvider.setUserDetailsService(customerUserDetailService);
//		authProvider.setPasswordEncoder(passwordEncoder());
//		return new ProviderManager(List.of(authProvider));
//	}
}
