import java.util.Objects;

public class Zaznam {

    private String telefonniCislo;
    private String jmenoZakaznika;
    private Boolean smsPoslana;

    public String getTelefonniCislo() {
        return telefonniCislo;
    }

    public void setTelefonniCislo(String telefonniCislo) {
        this.telefonniCislo = telefonniCislo;
    }

    public String getJmenoZakaznika() {
        return jmenoZakaznika;
    }

    public void setJmenoZakaznika(String jmenoZakaznika) {
        this.jmenoZakaznika = jmenoZakaznika;
    }

    public Boolean getSmsPoslana() {
        return smsPoslana;
    }

    public void setSmsPoslana(Boolean smsPoslana) {
        this.smsPoslana = smsPoslana;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Zaznam zaznam = (Zaznam) o;
        return Objects.equals(telefonniCislo, zaznam.telefonniCislo) &&
                Objects.equals(jmenoZakaznika, zaznam.jmenoZakaznika) &&
                Objects.equals(smsPoslana, zaznam.smsPoslana);
    }

    @Override
    public int hashCode() {
        return Objects.hash(telefonniCislo, jmenoZakaznika, smsPoslana);
    }
}
