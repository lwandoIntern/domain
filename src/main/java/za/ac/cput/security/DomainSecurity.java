package za.ac.cput.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class DomainSecurity extends WebSecurityConfigurerAdapter {
    private static final String USER_ROLE = "USER";
    private static final String ADMIN_ROLE = "ADMIN";


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user")
                .password(passwordEncoder().encode("staff"))
                .roles(USER_ROLE)
                .and()
                .withUser("admin")
                .password(passwordEncoder().encode("admin"))
                .roles(USER_ROLE,ADMIN_ROLE);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(HttpMethod.POST,"/domain/**/create").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.PUT,"/domain/**/update").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.DELETE,"/domain/**/delete").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.GET,"/domain/**/getAll").hasAnyRole(ADMIN_ROLE,USER_ROLE)
                .antMatchers(HttpMethod.GET,"/domain/**/read").hasAnyRole(ADMIN_ROLE,USER_ROLE)
                .antMatchers("/domain/author/hello").hasRole(USER_ROLE)
                .antMatchers("/").permitAll()
                .and()
                .formLogin();

    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
