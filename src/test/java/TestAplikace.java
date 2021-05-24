import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TestAplikace {

    @Test
    public void prvniTest(){

    }

    @Test
    public void testPolsaniSms(){

        //AplikaceNaOvereniZakaznika aplikaceNaOvereniZakaznika = new AplikaceNaOvereniZakaznika(new SmsService());
        AplikaceNaOvereniZakaznika aplikaceNaOvereniZakaznika = new AplikaceNaOvereniZakaznika(new SmsServiceMock(), new NacteniDatService());
        aplikaceNaOvereniZakaznika.start();

    }

    @Test
    public void testPolsaniSmsMockito(@Mock SmsServiceInterface smsServiceInterface){

        when(smsServiceInterface.posliSms("+420123456789")).thenReturn(true);


        //AplikaceNaOvereniZakaznika aplikaceNaOvereniZakaznika = new AplikaceNaOvereniZakaznika(new SmsService());
        //AplikaceNaOvereniZakaznika aplikaceNaOvereniZakaznika = new AplikaceNaOvereniZakaznika(new SmsServiceMock());
        AplikaceNaOvereniZakaznika aplikaceNaOvereniZakaznika = new AplikaceNaOvereniZakaznika(smsServiceInterface, new NacteniDatService());
        aplikaceNaOvereniZakaznika.start();

    }

    @Test
    public void testPolsaniSmsMockitoFail(@Mock SmsServiceInterface smsServiceInterface, @Mock NacteniDatInterface nacteniDatInterface){

        when(smsServiceInterface.posliSms("+420123")).thenReturn(false);

        Zaznam z1 = new Zaznam();
        z1.setTelefonniCislo("+420123");
        when(nacteniDatInterface.nactiSeznamDatZDatabaze()).thenReturn(List.of(z1));

        AplikaceNaOvereniZakaznika aplikaceNaOvereniZakaznika = new AplikaceNaOvereniZakaznika(smsServiceInterface, nacteniDatInterface);

        Assertions.assertThrows(RuntimeException.class, () -> {aplikaceNaOvereniZakaznika.start();});

    }

    @Test
    public void vygenerujTextTest(){

        SmsService smsService = new SmsService();
        String text = smsService.vygenerujText(null, "Jan");
        Assertions.assertEquals("Ahoj Jan, jak se mas?", text);

    }
}
