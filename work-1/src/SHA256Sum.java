import java.io.ByteArrayOutputStream;
import java.io.File;
import java.nio.file.Files;

public class SHA256Sum {
    public static void main(String[] args) {
        try {
            if (args.length > 0) {
                for (String arg : args) {
                    File file = new File(arg);
                    if (file.exists()) {
                        System.out.printf("%s *%s\n", HashSummer.getHash(Files.readAllBytes(file.toPath()), "SHA-256", 64), file.getName());
                    } else {
                        System.err.printf("File %s not found\n", file.getName());
                    }
                }
            } else {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024 * 32];

                int bytesRead;
                while ((bytesRead = System.in.read(buffer)) > 0) {
                    baos.write(buffer, 0, bytesRead);
                }
                System.out.printf("%s *-\n", HashSummer.getHash(baos.toByteArray(), "SHA-256", 64));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}