package uebung03.HashTable;
import scala.util.parsing.combinator.testing.Str;

import java.util.ArrayList;

import static gdi.MakeItSimple.*;

public class SongParser {

    //Test main
    public static void main(String args[]) throws Exception{
        HashTable h = new HashTable(20);
        SongImpl[] songs = SongParser.parseSongs("E:\\localGitRepos\\PR2-SoSe22-Stud\\src\\uebung03\\HashTable\\songs.txt");
        //output to console
        for(Song s : songs){
            println(s.toString());

        }
    }
    //Hilfsklasse
    public static SongImpl[]  parseSongs(String filename){
        ArrayList<SongImpl> songs = new ArrayList<>();
        Object file = openInputFile(filename);
        while(!isEndOfInputFile(file)){
            String line = readLine(file);
            String content[] = line.split(";");

            int numberOfArtists = content.length - 2;   //withdraw 2, for song and album name
            String artists[] = new String[numberOfArtists];
            for(int i = 0; i < numberOfArtists; i++)
                artists[i] = content[i + 2];
            SongImpl song = new SongImpl(content[0], content[1], artists);
            songs.add(song);
        }
        closeInputFile(file);

        return (songs.toArray(new SongImpl[songs.size()]));
    }
}
