package com.udea.mundofiesta.utils;

import lombok.Data;

@Data
public class Mensaje {

    private final String numero;
    private final String mensaje;
    private final String token;
    private final Integer id;
    private final boolean valid;

    public Mensaje(String mensaje, String token, Integer id, boolean valid) {
        this.token = token;
        this.id = id;
        this.numero = null;
        this.mensaje = mensaje;
        this.valid = valid;
    }

    public Mensaje(String numero, String mensaje, String token, Integer id) {
        this.numero = numero;
        this.mensaje = mensaje;
        this.token = token;
        this.id = id;
        this.valid = false;
    }
}
