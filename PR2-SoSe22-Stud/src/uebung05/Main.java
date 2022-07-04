package uebung05;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        CaesarWriter w = new CaesarWriter(new FileWriter("hallo.txt"),5);

        w.write("Hallo ich bins");
        w.close();
        Reader r = new CaesarReader(new FileReader("C:\\Users\\School\\IdeaProjects\\PR2\\hallo.txt"),5);
        System.out.println((char)r.read());
        System.out.println((char)r.read());

        r.close();
    }
}
