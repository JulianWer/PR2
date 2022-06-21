package uebung03.HashTable;

public class SongImplementation implements Song {
    private String songName, albumName;
    private String[] artists;

    public SongImplementation(String songName, String albumName, String[] artists) { // sets all Attributes
        this.songName = songName;
        this.albumName = albumName;
        this.artists = artists;
    }

    public String toString() { // returns the title Album and Interpreter as String
        boolean firstArtistFlag = true;
        String str = "Titel: " + this.songName + "\n" + "Album: " + this.albumName + "\n" + "Interpreten: ";
        for (String interpret : this.artists) { // loops throw the artists and adds them
            if (firstArtistFlag) {
                str += interpret;
                firstArtistFlag = false;
            } else {
                str += ", " + interpret;
            }
        }
        return str;
    }


    @Override
    public String getSongName() {
        return this.songName;
    } // gets the Song name

    @Override
    public String getAlbumName() {
        return this.albumName;
    } // gets the name of the Album

    @Override
    public String[] getArtists() {
        return this.artists;
    } // gets Artist

    @Override
    public int compareTo(Object o) {
        //ToDo: kontrollieren
        String comparisonString = ((SongImplementation)o).getSongName();
        String key = this.songName;
        for (int i = 0; (i < key.length() && i < comparisonString.length()); i++) {
            if (key.charAt(i) == comparisonString.charAt(i))
                continue;
            if (key.charAt(i) < comparisonString.charAt(i))
                return 1;
            if (key.charAt(i) > comparisonString.charAt(i))
                return -1;
        }
        //at this point both string are equal but one of them is longer
        if (key.length() < comparisonString.length())
            return 1;
        if (key.length() > comparisonString.length())
            return -1;
        return 0;   //equal strings
    } // set compare to to 0
}
