package org.projet.projetWeb.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class ProjectSecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("userPwd")
                .roles("USER")
                .build();
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("AdminPwd")
                .roles("USER", "ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // Disable CSRF
                .csrf(csrf -> csrf.disable())
                // Configure headers
                .headers(headers -> {
                    headers.frameOptions(frameOptionsConfig -> frameOptionsConfig.sameOrigin());  // Permit frames on same origin, particularly for H2 console
                })
                // Configure URL authorization
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/h2-console/**", "/byEmail", "/users/byEmailAndPassword").permitAll()  // Allow H2 console access
                        .anyRequest().authenticated()  // All other requests require authentication
                )
                // Configure form login
                .formLogin(form -> form
                        .defaultSuccessUrl("/homepage", true)
                )
                // Configure HTTP Basic authentication
                .httpBasic(withDefaults());

        return http.build();
    }
}
