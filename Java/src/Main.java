
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    private static BufferedReader buffer;

    private static String PATH = "prog.txt";

   
    public static void main(String[] args) {
        read(PATH);
    }

    public static void setup() {
        Reader reader = new Reader();
        buffer = reader.setupFilePath(PATH);
    }


    public static void read(String path) {

        setup();


        try {
            File myObj = new File(path);

            while (true) {
                String line = buffer.readLine();
                if (line != null)
                    System.out.println(line);
                else
                    break;
            }

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}