package backend.json.teste.sec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;

import static backend.json.teste.sec.AppRoles.*;

@Configuration
@EnableWebSecurity
public class AppSecConf extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AppSecConf(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    // TODO usar apenas para teste local
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                /*.antMatchers("/destino**", "/ticket**", "/perfil**")
                .hasRole(ADMIN.name())
                .antMatchers("/ticket/*", "/destino**")
                .hasRole(AGENTE.name())
                .antMatchers("/perfil**", "/destino**")
                .hasRole(PERFIL.name())*/
                //TODO limitacao nos metodos em cada url
                .antMatchers("/perfil/cadastro", "/perfil/login", "/erro", "/destino", "/destino/*")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }


    //TODO jamais colocar senha no codigo caso ele for publico
    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("senha"))
                .roles(ADMIN.name())
                .build();

        UserDetails agente = User.builder()
                .username("agente")
                .password(passwordEncoder.encode("senha"))
                .roles(AGENTE.name())
                .build();

        UserDetails cliente = User.builder()
                .username("cliente")
                .password(passwordEncoder.encode("senha"))
                .roles(PERFIL.name())
                .build();

        return new InMemoryUserDetailsManager(admin, agente, cliente);
    }
}
