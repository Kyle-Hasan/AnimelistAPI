package com.example.animelist.Animelist.security;

import com.example.animelist.Animelist.security.TokenAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                // Public endpoints, no authentication required
                                .requestMatchers("/api/users/login", "/api/users/signup", "/api/users/signout", "/error", "/login", "/logout").permitAll()
                                .requestMatchers("/api/admin/**").hasRole("ADMIN")
                                // User endpoints, require USER role
                                .requestMatchers("/api/characters/**").hasRole("USER")
                                // Other endpoints, require authentication
                                .anyRequest().authenticated()



                )
                // Add your custom authentication filter
                .addFilterBefore(tokenAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                // Disable CSRF if needed
                .csrf(csrf -> csrf.disable());

        return http.build();
    }

    @Bean
    public TokenAuthenticationFilter tokenAuthenticationFilter() {
        return new TokenAuthenticationFilter();
    }
}
