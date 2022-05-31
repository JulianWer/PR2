package uebung03.HashTable;

public class SongImplementation implements Song {
    private String songName, albumName;
    private String[] artists;

    public SongImplementation(String songName, String albumName, String[] artists) {
        this.songName = songName;
        this.albumName = albumName;
        this.artists = artists;
    }

    public String toString() {
        boolean firstArtistFlag = true;
        String str = "Titel: " + this.songName + "\n" + "Album: " + this.albumName + "\n" + "Interpreten: ";
        for (String interpret : this.artists) {
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
    }

    @Override
    public String getAlbumName() {
        return this.albumName;
    }

    @Override
    public String[] getArtists() {
        return this.artists;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
