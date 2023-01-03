package com.delhomvi.demoSecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecureConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .requestMatchers("/acc","/balance","/loans","cards").authenticated()
                .requestMatchers("/notices","/contacts").permitAll()
                .and().formLogin()
                .and().httpBasic();
        return http.build();
    }
}
