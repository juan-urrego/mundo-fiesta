package com.udea.mundofiesta.utils;

import com.twilio.Twilio;
import com.twilio.exception.ApiException;
import com.twilio.rest.verify.v2.service.Verification;
import com.twilio.rest.verify.v2.service.VerificationCheck;
import com.udea.mundofiesta.jwt.JwtService;
import com.udea.mundofiesta.usuario.Usuario;
import com.udea.mundofiesta.usuario.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TwilioService {

    private final static String ACCOUNT_SID="AC5ece2c4f23434a37c6ed6c80192103d7";
    private final static String AUTH_TOKEN="84dbf401ea698e2015cd2105ea093d75";
    private final UsuarioService usuarioService;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;



    public Mensaje startVerification(String telefono) {
        try {
            Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
            Verification verification = Verification.creator("VA0c8a8c142190d4de024f815e56334ea9", telefono, "whatsapp").create();
            if ("approved".equals(verification.getStatus()) || "pending".equals(verification.getStatus())) {
                return new Mensaje(verification.getSid(), null, true);
            }
        } catch (ApiException exception) {
            return new Mensaje(exception.getMessage(), null, false);
        }
        return null;
    }

    public Mensaje verificationOtp(String telefono, String otp) {
        try {
            Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
            VerificationCheck verificationCheck = VerificationCheck.creator(
                            "VA0c8a8c142190d4de024f815e56334ea9",
                            otp)
                    .setTo("+57"+telefono).create();
            if ("approved".equals(verificationCheck.getStatus())) {
                Usuario usuario = usuarioService.getByTelefono(telefono);

                Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(usuario.getEmail(), "@fhjq7cbjv4@^mqUHr4Qum6"));
                SecurityContextHolder.getContext().setAuthentication(authentication);
                String jwt = jwtService.generateToken(authentication);
                return new Mensaje(verificationCheck.getTo(), jwt, true);
            }
        } catch (ApiException exception) {
            return new Mensaje(exception.getMessage(), null , false);
        }
        return null;
    }
}
