package uebung05;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        CaesarWriter w = new CaesarWriter(new FileWriter("hallo.txt"),5);

        w.write("HÖrt");
        w.close();
        Reader r ;
        int c;
//        while((c = r.read()) != -1){
//            System.out.println((char)c);
//        }
        try {
            r= new CaesarReader(new FileReader("C:\\Users\\School\\IdeaProjects\\PR2\\hallo.txt"),5);
            while ((c = r.read()) != -1) { System.out.print((char)c); }
            r.close();
        } catch (IOException e) {
            System.out.println("Fehler beim Lesen der Datei");
        }

    }
}
