package uebung05;

import java.io.FilterReader;
import java.io.Reader;

public class CaesarReader extends FilterReader {
    /**
     * Creates a new filtered reader.
     *
     * @param in a Reader object providing the underlying stream.
     * @throws NullPointerException if {@code in} is {@code null}
     */
    protected CaesarReader(Reader in) {
        super(in);
    }
}
