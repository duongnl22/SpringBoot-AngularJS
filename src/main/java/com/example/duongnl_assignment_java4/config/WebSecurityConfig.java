package com.example.duongnl_assignment_java4.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;


@Configuration
//@EnableWebSecurity
public class WebSecurityConfig {
//
//    @Bean
//    public static PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http.csrf().disable()
//                .authorizeHttpRequests()
//                .requestMatchers("/api/product/**", "/account").permitAll()
//                .and()
//                .authorizeHttpRequests()
//                .requestMatchers("/api/**").authenticated()
//                .and().httpBasic(Customizer.withDefaults())
//                .build();
//    }
//
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails user1 = User.builder()
//                .username("duongnl")
//                .password(passwordEncoder().encode("123"))
//                .roles("1")
//                .build();
//
//        UserDetails user2 = User.builder()
//                .username("danhnl")
//                .password(passwordEncoder().encode("123"))
//                .roles("0")
//                .build();
//
//        UserDetails user3 = User.builder()
//                .username("ngocnl")
//                .password(passwordEncoder().encode("123"))
//                .roles("0")
//                .build();
//        return new InMemoryUserDetailsManager(user1, user2, user3);
//    }


}
