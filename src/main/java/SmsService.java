import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import java.net.URI;
import java.util.List;

public class SmsService implements SmsServiceInterface{

    public String vygenerujText(String telefonniCislo, String jmenoUzivatele){
        String text = "Ahoj "+jmenoUzivatele+", jak se mas?";

        return text;
    }

    public boolean posliSms(String telefonniCislo){

        String auth = "AC0f0f7f4f4bcfce9df89ed54fb0b952ad";
        String token = "44cf6b4c502b0e451c392826bf04720e";

        Twilio.init(auth, token);


        PhoneNumber to = new PhoneNumber("+420721480235");
        PhoneNumber from = new PhoneNumber("+19366814181");
        String text = "Ahoj, pozdrav z kurzu Engeto!";
        Message message = Message.creator(to, from, text).create();

        if (message.getSid() != null){
            System.out.println("OK");

            return true;
        }

        return false;
    }



}
