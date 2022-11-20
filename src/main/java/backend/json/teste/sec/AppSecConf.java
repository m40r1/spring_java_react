package backend.json.teste.sec;

// import java.net.http.HttpHeaders;
// import java.net.http.HttpRequest;
// import java.util.UUID;
// import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
// FIXME refazer com filter_chain
public class AppSecConf {
@Bean
  SecurityFilterChain MainSec(HttpSecurity http) throws Exception {
  return http
          //TODO integrar com react?
          xs.csrf(csrf -> csrf.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
          .authorizeHttpRequests(request -> request.anyRequest().authenticated())
          .formLogin(form -> form
                  .successHandler((request, response, authentication) -> response.setStatus(HttpStatus.OK.value()))
                  .failureHandler((request, response, exception) -> response.setStatus(HttpStatus.UNAUTHORIZED.value()))
                  )
          .exceptionHandling(ex -> ex.authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)))
          .build();
}

@Bean
  UserDetailsService userDetailsService() {
  User.UserBuilder userBuilder = User.withDefaultPasswordEncoder();
}


  @Bean
  CorsConfigurationSource corsConfigurationSource() {
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    CorsConfiguration config = new CorsConfiguration();
    config.addAllowedHeader("*");
    config.addAllowedMethod("*");
//endereco servidor react
    config.addAllowedOrigin("http://localhost:4200");
 config.setAllowCredentials(true);
 source.registerCorsConfiguration("/**",config);
 return  source;
  }

}
