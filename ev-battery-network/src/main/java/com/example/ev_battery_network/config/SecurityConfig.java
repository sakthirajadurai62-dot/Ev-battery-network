package com.example.ev_battery_network.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    // ================================
    // ADMIN + USER ACCOUNTS
    // ================================
    @Bean
    public UserDetailsService userDetailsService() {

        // Admin account
        UserDetails admin = User.withUsername("admin")
                .password("{noop}admin123")
                .roles("ADMIN")
                .build();

        // User account
        UserDetails user = User.withUsername("user")
                .password("{noop}user123")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(admin, user);
    }


    // ================================
    // SECURITY CONFIGURATION
    // ================================
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {

        http

                // Disable CSRF for this project/API testing
                .csrf(csrf -> csrf.disable())


                // ================================
                // PAGE / API ACCESS
                // ================================
                .authorizeHttpRequests(auth -> auth

                        // Login page must be accessible
                        .requestMatchers("/login").permitAll()

                        // Static resources
                        .requestMatchers(
                                "/css/**",
                                "/js/**",
                                "/images/**",
                                "/favicon.ico"
                        ).permitAll()

                        // APIs require login
                        .requestMatchers("/api/**").authenticated()

                        // Everything else requires login
                        .anyRequest().authenticated()
                )


                // ================================
                // CUSTOM LOGIN PAGE
                // ================================
                .formLogin(form -> form

                        // Our login.html
                        .loginPage("/login")

                        // After successful login
                        .defaultSuccessUrl("/", true)

                        // Allow everyone to access login
                        .permitAll()
                )


                // ================================
                // LOGOUT
                // ================================
                .logout(logout -> logout

                        // After logout
                        .logoutSuccessUrl("/login?logout")

                        // Invalidate session
                        .invalidateHttpSession(true)

                        // Delete session cookie
                        .deleteCookies("JSESSIONID")

                        .permitAll()
                );

        return http.build();
    }
}