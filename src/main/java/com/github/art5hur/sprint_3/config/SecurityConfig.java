package com.github.art5hur.sprint_3.config;

//src/main/java/com/github/acnaweb/mvc_rh/config/SecurityConfig.java


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

 @Bean
 public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
     http
         .authorizeHttpRequests(auth -> auth
             .requestMatchers("/login", "/css/**", "/images/**").permitAll()
             .anyRequest().authenticated()
         )
         .formLogin(form -> form
             .loginPage("/login")
             .failureUrl("/login?error=true") // Redireciona para /login com o parâmetro de erro
             .defaultSuccessUrl("/dashboard", true)
             .permitAll()
         )
         .logout(logout -> logout
        		 .logoutUrl("/logout")
                 .logoutSuccessUrl("/login?logout=true")
             .permitAll()
         );

     return http.build();
 }

 @Bean
 public UserDetailsService userDetailsService() {
     UserDetails user = User.builder()
         .username("joaosantos@eurofarma.com.br")
         .password(passwordEncoder().encode("password"))
         .roles("USER")
         .build();

     return new InMemoryUserDetailsManager(user);
 }

 @Bean
 public PasswordEncoder passwordEncoder() {
     return new BCryptPasswordEncoder();
 }
}
