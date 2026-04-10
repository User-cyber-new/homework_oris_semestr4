package org.example.homework5.infrastructure.security.config;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.homework5.infrastructure.persistence.entity.UserEntity;
import org.example.homework5.infrastructure.persistence.repository.UserRepository;
import org.jspecify.annotations.Nullable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Collection;
import java.util.Collections;

import java.util.Set;

@Slf4j
@EnableWebSecurity
@Configuration
@AllArgsConstructor
public class SecurityConfig {

    private UserRepository userRepository;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity){
        return httpSecurity
                .csrf(csrf -> csrf.ignoringRequestMatchers("/user/**"))
                .authorizeHttpRequests(auth ->
                     auth
                    .requestMatchers("/user/register", "/user/enter").permitAll()
                    .anyRequest().authenticated())
                .formLogin(form ->
                    form
                    .loginPage("/user/enter")
                    .permitAll()
                    .usernameParameter("email")
                    .passwordParameter("my_password")
                    .defaultSuccessUrl("/user/success", true)
                    .failureUrl("/user/register")
                    .permitAll())
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        return new UserDetailsService() {
            @Override
            // UsernameNotFoundException обработается переходом на .failureUrl("/user/register")
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                UserEntity userEntity = userRepository
                        .findByEmail(username)
                        .orElseThrow(() -> new UsernameNotFoundException("пользователь не найден"));
                log.info("ИЗ БД ПОЛЬЗАК: " + userEntity.getName());
                return new UserDetails() {
                    @Override
                    public Collection<? extends GrantedAuthority> getAuthorities() {
                        Set<GrantedAuthority> set = Collections.singleton(userEntity.getRole().getRoleGrantedAuthority());
                        return set;
                    }

                    @Override
                    public @Nullable String getPassword() {
                        return userEntity.getPassword();
                    }

                    @Override
                    public String getUsername() {
                        return userEntity.getEmail();
                    }
                };
            }
        };
    }

}
