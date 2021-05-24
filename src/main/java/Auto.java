import java.util.Objects;

public class Auto {

    public Auto(){

    }

    public Auto(String znacka, Long rokVyroby, String rz, String barva) {
        this.znacka = znacka;
        this.rokVyroby = rokVyroby;
        this.rz = rz;
        this.barva = barva;
    }

    @VlastniAnotace(value = FormatEnum.UPPER, codes = {"abc", "xyz"})
    private String znacka;

    @VlastniAnotace(value = FormatEnum.UPPER, codes = {"rok_vyroby"}, fieldName = "rok_vyroby")
    private Long rokVyroby;

    @VlastniAnotace(value = FormatEnum.LOWER)
    private String rz;

    @VlastniAnotace(value = FormatEnum.NONE)
    private String barva;

    public String getZnacka() {
        return znacka;
    }

    public void setZnacka(String znacka) {
        this.znacka = znacka;
    }

    public Long getRokVyroby() {
        return rokVyroby;
    }

    public void setRokVyroby(Long rokVyroby) {
        this.rokVyroby = rokVyroby;
    }

    public String getRz() {
        return rz;
    }

    public void setRz(String rz) {
        this.rz = rz;
    }

    public String getBarva() {
        return barva;
    }

    public void setBarva(String barva) {
        this.barva = barva;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Auto auto = (Auto) o;
        return Objects.equals(znacka, auto.znacka) &&
                Objects.equals(rokVyroby, auto.rokVyroby) &&
                Objects.equals(rz, auto.rz) &&
                Objects.equals(barva, auto.barva);
    }

    @Override
    public int hashCode() {
        return Objects.hash(znacka, rokVyroby, rz, barva);
    }

    @Override
    public String toString() {
        return "Auto{" +
                "znacka='" + znacka + '\'' +
                ", rokVyroby=" + rokVyroby +
                ", rz='" + rz + '\'' +
                ", barva='" + barva + '\'' +
                '}';
    }
}
