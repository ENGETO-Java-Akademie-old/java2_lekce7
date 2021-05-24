import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ZapisDoSouboru {

    public static void main(String[] args) throws IOException {

        ZapisDoSouboru zapisDoSouboru = new ZapisDoSouboru();
        zapisDoSouboru.start();
    }

    private void start() throws IOException {

        Auto auto1 = new Auto("Skoda", 2020L, "ABC1234", "Cervena");

        Student student1 = new Student("Jan", "Novak", 8L);

        File f = new File("out.csv");
        //Files.write(f.toPath(), List.of(autoToCsv(auto1)), StandardCharsets.UTF_8);

        this.zapisDoSouboru(f.toPath(), auto1);
        //this.zapisDoSouboru(f.toPath(), student1);
    }

    private String autoToCsv(Auto auto){
        return String.join(",", auto.getZnacka(), auto.getRokVyroby().toString(), auto.getRz(), auto.getBarva());
    }

    private void zapisDoSouboru(Path path, Object object) throws IOException {

        Field[] fields = object.getClass().getDeclaredFields();

        List<String> jmenaPoli = Arrays.stream(fields).map(field -> {
            VlastniAnotace anotace = field.getAnnotation(VlastniAnotace.class);
            if (anotace != null) {
                if (anotace.fieldName() != null && anotace.fieldName().length() > 0){
                    return anotace.fieldName();
                }
            }
            return field.getName();
        }).collect(Collectors.toList());

        List<String> hodnoty = Arrays.stream(fields).map(field -> {
            try {
                field.setAccessible(true);

                VlastniAnotace anotace = field.getAnnotation(VlastniAnotace.class);
                if (anotace != null) {
                    if (anotace.value() == FormatEnum.UPPER) {
                        return field.get(object).toString().toUpperCase();
                    } else if (anotace.value() == FormatEnum.LOWER) {
                        return field.get(object).toString().toLowerCase();
                    }
                }
                return field.get(object).toString();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            return "";
        }).collect(Collectors.toList());

        Files.write(path, List.of(String.join(",",jmenaPoli), String.join(",",hodnoty)), StandardCharsets.UTF_8);
    }


}
