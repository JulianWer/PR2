package uebung03.HashTable.ProbingAlgorithms;

import uebung03.HashTable.HashTable;
import uebung03.HashTable.SongImpl;
import uebung03.HashTable.SongParser;

import static gdi.MakeItSimple.println;

public class HashTableTestClass {

    public static void main(String args[]){
        HashTable h = new HashTable(20, new LinearesSondierenExtended(1, false));
        SongImpl s[] = SongParser.parseSongs("E:\\localGitRepos\\PR2-SoSe22-Stud\\src\\uebung03\\HashTable\\songs.txt");

        h.put(s[0].getSongName(), s[0]);
        h.put(s[1].getSongName(), s[1]);
        h.put(s[2].getSongName(), s[2]);
        h.put(s[3].getSongName(), s[3]);

        h.printToConsole();


        println(h.remove(s[1].getSongName()));
        println();
        h.printToConsole();

    }
}
