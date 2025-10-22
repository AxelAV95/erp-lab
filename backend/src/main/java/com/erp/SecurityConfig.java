package com.erp; // Asegúrate de que este sea tu paquete correcto

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // 1. Desactivar CSRF (Cross-Site Request Forgery)
            // Es necesario para que tu frontend (React) pueda hacer peticiones POST, PUT, DELETE
            .csrf(csrf -> csrf.disable())

            // 2. Permitir TODAS las peticiones
            // Esto hace que ningún endpoint requiera autenticación
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll()
            )

            // 3. Desactivar el formulario de login y la autenticación básica
            // Ya no los necesitamos si todo está permitido
            .formLogin(form -> form.disable())
            .httpBasic(basic -> basic.disable());

        return http.build();
    }
}