package com.duoc.banco.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll()
                .requestMatchers("/api/v1/bff/web/**").hasRole("WEB")
                .requestMatchers("/api/v1/bff/mobile/**").hasRole("MOBILE")
                .requestMatchers("/api/v1/bff/atm/**").hasRole("ATM")
                .anyRequest().authenticated()
            )
            .httpBasic(withDefaults());

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails webUser = User.withUsername("user_web")
                .password("{noop}web123")
                .roles("WEB")
                .build();

        UserDetails mobileUser = User.withUsername("user_mobile")
                .password("{noop}mobile123")
                .roles("MOBILE")
                .build();

        UserDetails atmUser = User.withUsername("user_atm")
                .password("{noop}atm123")
                .roles("ATM")
                .build();

        return new InMemoryUserDetailsManager(webUser, mobileUser, atmUser);
    }
}
