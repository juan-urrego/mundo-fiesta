package com.udea.mundofiesta.utils;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/twilio")
@AllArgsConstructor
@Slf4j
public class TwilioController {


    private final TwilioService service;

    @PostMapping("/sendotp")
    public ResponseEntity<?> sendotp(@RequestParam("telefono") String telefono){
        Mensaje mensaje = service.startVerification("+57"+telefono);
        if (mensaje.isValid()){
            return new ResponseEntity<>("Codigo OTP enviado", HttpStatus.OK);
        }
        return new ResponseEntity<>("Error al enviar el código ", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("/verify")
    public ResponseEntity<?> verifyOtp(@RequestParam("telefono") String telefono, @RequestParam("otp") String otp){
        Mensaje mensaje = service.verificationOtp(telefono, otp);
        if (mensaje.isValid()){
            return new ResponseEntity<>(mensaje, HttpStatus.OK);
        }
        return new ResponseEntity<>("Codigo erroneo ", HttpStatus.BAD_REQUEST);
    }
}
