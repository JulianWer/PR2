package uebung03.HashTable.ProbingAlgorithms;

import uebung03.HashTable.HashTable;
import uebung03.HashTable.SongImpl;
import uebung03.HashTable.SongParser;

public class HashTableTestClass {

    public static void main(String args[]){
        HashTable h = new HashTable(20, new LinearProbing());
        SongImpl s[] = SongParser.parseSongs("E:\\localGitRepos\\PR2-SoSe22-Stud\\src\\uebung03\\HashTable\\songs.txt");

        h.put(s[0].getSongName(), s[0]);
        h.put(s[0].getSongName(), s[0]);
        h.put(s[0].getSongName(), s[0]);
        h.put(s[0].getSongName(), s[0]);
    }
}
