package secutrity.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class AppConfig {
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/manage").hasRole("ADMIN")
                .antMatchers("/use").hasRole("USER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/showMyLoginPage")
                .loginProcessingUrl("/authenticateUser")
                .permitAll()
                .and()
                .logout()
                .permitAll();
        return http.build();
    }
    @Bean
    UserDetailsService userDetailsService() {
        UserDetails admin = User.withUsername("admin").password("{noop}admin").roles("ADMIN").build();
        UserDetails user = User.withUsername("user").password("{noop}user").roles("USER").build();
        return new InMemoryUserDetailsManager(admin,user);
    }
}
