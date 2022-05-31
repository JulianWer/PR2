package uebung03.HashTable;

import java.util.ArrayList;

import static gdi.MakeItSimple.*;
import static gdi.MakeItSimple.closeInputFile;

public class SongsHashTable {

    public static String[] getAllSongsFromFile(String filename) {
        ArrayList<String> songs = new ArrayList<>();
        Object file = openInputFile(filename);
        while (!isEndOfInputFile(file)) {
            String line = readLine(file);
            songs.add(line);

        }
        closeInputFile(file);
        return (songs.toArray(new String[songs.size()]));
    }

    public static String[] split(String song, char rj) {
        return song.split(Character.toString(rj));
    }
}
