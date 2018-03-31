import java.io.*;
import java.nio.file.Files;

public class CalcMD5 {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));

            String line = reader.readLine();
            while (line != null) {
                File file = new File(line);
                if (file.exists()) {
                    System.out.printf("%s\n", HashSummer.getHash(Files.readAllBytes(file.toPath()), "MD5", 32));
                }
                else {
                    System.err.printf("File \"%s\" not found\n", file.getName());
                }
                line = reader.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}