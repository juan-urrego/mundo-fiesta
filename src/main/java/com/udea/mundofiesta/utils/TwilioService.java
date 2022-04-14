package com.udea.mundofiesta.utils;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

@Service
@Slf4j
public class TwilioService {

    private final String ACCOUNT_SID="AC5ece2c4f23434a37c6ed6c80192103d7";
    private final String AUTH_TOKEN="84dbf401ea698e2015cd2105ea093d75";

    public void send(Mensaje mensaje) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        for (int i=0; i<2; i++) {
            Message message = Message.creator(new PhoneNumber("whatsapp:+57"+mensaje.getNumero()), new PhoneNumber("whatsapp:+14155238886"), mensaje.getMensaje())
                    .create();
        }
        log.info("estamos done");

    }

    public void receive( MultiValueMap<String, String> map) {

    }
}
