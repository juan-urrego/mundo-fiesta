package com.udea.mundofiesta.utils;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/twilio")
@AllArgsConstructor
public class TwilioController {


    private final TwilioService service;

    @PostMapping("/send")
    public void smsSubmit(@RequestBody Mensaje mensaje) {

        service.send(mensaje);
    }

    @PostMapping(value = "/receive", produces = "application/xml")
    @ResponseBody
    public void receive(
            @RequestParam("From") String from,
            @RequestParam("Body") String body){

        Mensaje mensaje = new Mensaje(from, "este mensaje es leído por el back y respondido con el siguiente mensaje que acaban de enviar: " + body);
        service.send(mensaje);
    }
}
