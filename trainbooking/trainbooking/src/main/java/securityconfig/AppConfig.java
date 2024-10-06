package securityconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
@EnableWebSecurity
public class AppConfig {

    @Bean
     SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable()) // Disable CSRF protection for testing
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers("/", "/seat-map","/book","/api/**").permitAll() // Allow access to specific paths
                        .anyRequest().authenticated()); // Require authentication for any other request
        return http.build();
    }
  
}
