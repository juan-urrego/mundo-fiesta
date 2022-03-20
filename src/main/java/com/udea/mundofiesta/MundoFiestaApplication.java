package com.udea.mundofiesta;

import com.udea.mundofiesta.usuario.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.*;

@SpringBootApplication
public class MundoFiestaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MundoFiestaApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedMethods("GET", "PUT", "POST", "PATCH", "DELETE", "OPTIONS");
            }
        };
    }

    @Bean
    CommandLineRunner run(UsuarioService usuarioService, RolService rolService) {
        return args -> {
            boolean existsAdmin = rolService.existsAdmin();
            if (!existsAdmin) {
                rolService.save(new Rol(null, RolNombre.ROLE_ADMIN));
            }
            Rol rolAdmin = rolService.getRolAdmin();
            List<Usuario> usuarios = usuarioService.getAllAdmins();
            Set<Rol> roles = new HashSet<>();
            roles.add(rolAdmin);
            if (usuarios.isEmpty()){
                usuarioService.save(new Usuario(null,
                        "cc",
                        999999999,
                        "admin",
                        "admin",
                        "admin",
                        123,
                        "direccion",
                        "admin",
                        roles));
            }
        };
    }
}
