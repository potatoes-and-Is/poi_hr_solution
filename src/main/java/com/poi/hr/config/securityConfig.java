package com.poi.hr.config;

import com.poi.hr.config.handler.AuthFailHandler;
import com.poi.hr.domain.common.Role;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class securityConfig {

    private AuthFailHandler authFailHandler;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return web -> web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(auth -> auth
                .requestMatchers("/", "/common/login", "/common/fail").permitAll()
                .requestMatchers("/poihr/*").hasAnyAuthority(
                        Arrays.stream(Role.values())
                                .map(Role::name)
                                .toArray(String[]::new))
                .anyRequest().authenticated()

    ).formLogin(login -> login
                .loginPage("/common/login")
                .usernameParameter("employeeNumber")
                .passwordParameter("password")
                .defaultSuccessUrl("/poihr", true)
                .failureUrl("/common/login")
                .failureHandler(authFailHandler)

    ).logout(logout -> logout
                .logoutRequestMatcher(new AntPathRequestMatcher("/common/logout"))
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true)
                .logoutSuccessUrl("/")

    ).sessionManagement(session -> {
                session.maximumSessions(1);
                session.invalidSessionUrl("/");

    }).csrf(csrf -> csrf.disable());

    return http.build();
    }
}
