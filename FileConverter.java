import java.io.*;

public class FileConverter {
    public static void main(String[] args) {
        File inputFile = new File("input.txt");
        File outputFile = new File("output.txt");

        // Kontrollojm� n�se input.txt ekziston
        if (!inputFile.exists()) {
            try {
                if (inputFile.createNewFile()) {
                    System.out.println("Skedari 'input.txt' nuk u gjet. U krijua automatikisht si bosh.");
                }
            } catch (IOException e) {
                System.out.println("Gabim gjat� krijimit t� skedarit input.txt: " + e.getMessage());
                return;
            }
        }

        // Try-with-resources p�r lexim dhe shkrim
        try (
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line.toUpperCase());
                writer.newLine();
            }
            System.out.println("Konvertimi p�rfundoi me sukses.");
        } catch (IOException e) {
            System.out.println("Gabim gjat� leximit ose shkrimit: " + e.getMessage());
        }
    }
}
