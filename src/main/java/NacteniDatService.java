import java.util.ArrayList;
import java.util.List;

public class NacteniDatService implements NacteniDatInterface {

    public List<Zaznam> nactiSeznamDatZDatabaze(){
        Zaznam z1 = new Zaznam();
        z1.setJmenoZakaznika("Jan Novak");
        z1.setTelefonniCislo("+420123456789");
        List<Zaznam> list = new ArrayList<>();
        list.add(z1);
        return list;
    }
}
