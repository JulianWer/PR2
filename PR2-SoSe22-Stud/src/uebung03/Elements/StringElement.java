package uebung03.Elements;


public class StringElement implements Element, Cloneable {

    private String key;

    public StringElement(String key) {
        this.key = key;
    }

    @Override
    public Object clone() {
        return new StringElement(this.key);
    }

    @Override
    public Object getKey() {
        return this.key;
    }

    @Override
    public int compareTo(Object o) {
        String comparisonString = (String) ((StringElement) o).getKey();

        for (int i = 0; (i < this.key.length() && i < comparisonString.length()); i++) {
            if (this.key.charAt(i) == comparisonString.charAt(i))
                continue;
            if (this.key.charAt(i) < comparisonString.charAt(i))
                return 1;
            if (this.key.charAt(i) > comparisonString.charAt(i))
                return -1;
        }
        //at this point both string are equal but one of them is longer
        if (this.key.length() < comparisonString.length())
            return -1;
        if (this.key.length() > comparisonString.length())
            return 1;
        return 0;   //equal strings
    }
}
