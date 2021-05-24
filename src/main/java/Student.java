import java.util.Objects;

public class Student {

    public String jmeno;
    public String prijmeni;
    public Long stupen;

    public Student(){

    }

    public Student(String jmeno, String prijmeni, Long stupen) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.stupen = stupen;
    }

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }

    public Long getStupen() {
        return stupen;
    }

    public void setStupen(Long stupen) {
        this.stupen = stupen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(jmeno, student.jmeno) &&
                Objects.equals(prijmeni, student.prijmeni) &&
                Objects.equals(stupen, student.stupen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jmeno, prijmeni, stupen);
    }
}
