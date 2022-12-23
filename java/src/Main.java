import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = Files.newBufferedReader(Paths.get(System.getProperty("user.dir") + "/common/people.csv"))) {
            String DELIMITER = ",";
            String line;

            while ((line = br.readLine()) != null) {
                String[] columns = line.split(DELIMITER);
                System.out.println("User["+ String.join(", ", columns) +"]");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}