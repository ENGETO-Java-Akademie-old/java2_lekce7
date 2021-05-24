import java.util.List;
import java.util.stream.Collectors;

public class AplikaceNaOvereniZakaznika {

    public AplikaceNaOvereniZakaznika(SmsServiceInterface smsService, NacteniDatInterface nacteniDatService){
        this.smsService = smsService;
        this.nacteniDatService = nacteniDatService;
    }

    public static void main(String[] args){

        AplikaceNaOvereniZakaznika aplikaceNaOvereniZakaznika = new AplikaceNaOvereniZakaznika(new SmsService(), new NacteniDatService());
        aplikaceNaOvereniZakaznika.start();

    }

    SmsServiceInterface smsService;
    NacteniDatInterface nacteniDatService;

    public void start() {
        //1. Nacteni dat
        //2. Overeni struktury
        //3. Poslani SMS
        //4. Ulozeni vysledku do Databaze



        List<Zaznam> data = nacteniDatService.nactiSeznamDatZDatabaze();


        List<Zaznam> vysledekList = data.stream().map(zaznam -> {
            boolean vysledek = smsService.posliSms(zaznam.getTelefonniCislo());

            if (!vysledek) {
                throw new RuntimeException("SMS se nepodarilo poslat");
            }
            zaznam.setSmsPoslana(vysledek);

            return zaznam;
        }).collect(Collectors.toList());

        System.out.println("Start Testovaci Aplikace");
    }
}
