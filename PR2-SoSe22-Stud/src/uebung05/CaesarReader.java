package uebung05;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

public class CaesarReader extends FilterReader {
    private final int verscheibungen;
    private final char[] alphabet = new char[58];

    protected CaesarReader(Reader in, int verscheibungen) {
        super(in);
        this.verscheibungen = verscheibungen;
        createAlphabet();
    }

    public int read() throws IOException {
        return calcNextLetter(super.read());
    }

    private void createAlphabet(){
        char firstLetter = 'A';
        int cnt = 0 ;
        while(firstLetter <= 'Z'){
            alphabet[cnt] = firstLetter;
            cnt++;
            firstLetter++;
        }
        firstLetter = 'a';
        while(firstLetter <= 'z'){
            alphabet[cnt] = firstLetter;
            cnt++;
            firstLetter++;
        }
        alphabet[cnt++] = 'Ä';
        alphabet[cnt++] = 'Ö';
        alphabet[cnt++] = 'Ü';
        alphabet[cnt++] = 'ä';
        alphabet[cnt++] = 'ö';
        alphabet[cnt] = 'ü';
    }

    private int calcNextLetter(int c){
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] == c) {
                if (i - verscheibungen < 0) {
                    int tamp =(i-verscheibungen)% alphabet.length;
                    if(tamp <0)
                        return alphabet[alphabet.length + tamp];
                    return alphabet[tamp];
                }
                else
                    return alphabet[i-verscheibungen];

            }
        }
        return c;
    }
}
