package org.example.springsecurity.security.config;

import org.example.springsecurity.security.jwt.JwtAuthenticationEntryPoint;
import org.example.springsecurity.security.jwt.JwtRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests((authorize) -> authorize
                       // .anyRequest().authenticated() //denyAll(), permitAll()
                        //.requestMatchers(HttpMethod.POST,"*").authenticated()
                        /*.requestMatchers("/api/products").permitAll()
                        .requestMatchers("/api/products/admin/post").authenticated()
                        .requestMatchers("/api/products/{id}").authenticated()*/
                        .requestMatchers("/api/auth/login").permitAll()
                        .anyRequest().authenticated()
                )
                .exceptionHandling(exception->exception.authenticationEntryPoint(jwtAuthenticationEntryPoint))
                .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class)
                .httpBasic(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults());

        return http.build();
    }
    /*@Bean
    public  UserDetailsService userDetailsService (DataSource dataSource){
       return  new JdbcUserDetailsManager(dataSource);
    }*/


   /* @Bean
    public UserDetailsService userDetailsService() {
       // UserDetails userDetails = User.withDefaultPasswordEncoder()
        UserDetails userDetails = User.builder()
                .username("user")
                //.password("password")
                .password("{noop}password")
                .roles("USER")
                .build();
        UserDetails userDetails1 = User.builder()
                .username("user1")
                .password("{noop}password1")
                .roles("USER")
                .build();

       // return new InMemoryUserDetailsManager(userDetails);
        return new InMemoryUserDetailsManager(userDetails,userDetails1);
    }*/
    @Bean
    public PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }

    @Autowired
    private AuthenticationConfiguration authenticationConfiguration;

    @Bean
    public AuthenticationManager authenticationManager()throws  Exception{
        return authenticationConfiguration.getAuthenticationManager();
    }

}