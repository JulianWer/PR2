package uebung05;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;

public class CaesarWriter extends FilterWriter {


    private final int verscheibungen;
    private final char[] alphabet = new char[58];
    protected CaesarWriter(Writer out, int verschiebungen) {
        super(out);
        this.verscheibungen = verschiebungen;
        createAlphabet();
    }

    public void write(int c) throws IOException {
        c = calcNextLetter(c);
        System.out.println((char)c);
        super.write(c);
    }

    public void write(char[] cbuf, int off, int len) throws IOException{
        for (int i = 0; i < len; i++) {
            write(cbuf[i+off]);
        }
    }

    public void write(String str, int off, int len) throws
            IOException {
        write(str.toCharArray(), off, len);
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
        if (c == ' ') return ' ';
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] == c) {
                if (i + verscheibungen >= alphabet.length) {
                    int tamp = verscheibungen- (alphabet.length-i);
                    return alphabet[tamp];
                }
                else
                    return alphabet[i+verscheibungen];

            }
        }
     return 0;
    }


}
