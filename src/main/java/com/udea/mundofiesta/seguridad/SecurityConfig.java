package com.udea.mundofiesta.seguridad;

import com.udea.mundofiesta.jwt.AuthenticationFilter;
import com.udea.mundofiesta.jwt.AuthorizationFilter;
import com.udea.mundofiesta.usuario.RolNombre;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    final private UserDetailsService usuarioService;
    final private PasswordEncoder passwordEncoder;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        AuthenticationFilter authenticationFilter = new AuthenticationFilter(authenticationManagerBean());
        authenticationFilter.setFilterProcessesUrl("/login");
        AuthorizationFilter authorizationFilter = new AuthorizationFilter();
        http
                .cors()
                .and()
                .csrf().disable()
                .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(authenticationFilter)
                .addFilterAfter(authorizationFilter, AuthenticationFilter.class)
                .authorizeRequests()
                    .antMatchers(HttpMethod.GET, "/categorias/**").permitAll()
                    .antMatchers(HttpMethod.GET, "/imagenes/**").permitAll()
                    .antMatchers(HttpMethod.GET, "/pedidos/**").permitAll()
                    .antMatchers(HttpMethod.GET, "/personajes/**").permitAll()
                    .antMatchers(HttpMethod.GET, "/productos/**").permitAll()
                    .antMatchers(HttpMethod.GET, "/tiposProductos/**").permitAll()
                    .antMatchers("/twilio/**").permitAll()
                    .antMatchers("/login/**").permitAll()
                    .antMatchers("/usuarios/**").hasAuthority(RolNombre.ROLE_ADMIN.name())
                    .anyRequest().authenticated();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(usuarioService);
        return provider;
    }
}
