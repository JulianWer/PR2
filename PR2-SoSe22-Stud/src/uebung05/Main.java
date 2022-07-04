package uebung05;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Main {
    public static void main(String[] args) throws IOException {
        CaesarWriter w = new CaesarWriter(new FileWriter("hallo.txt"),5);
        w.write("Hallo ich bins");
        w.close();
    }
}
