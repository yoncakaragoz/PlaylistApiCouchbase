package trendyol.bootcamp.playlist.domain;


import java.util.UUID;

public class Track {

    private String name;
    private String length;
    private String artist;
    private String id;

    public Track() { }

    public Track(String name, String length, String artist) {
        this.name = name;
        this.length = length;
        this.artist = artist;
        this.id = UUID.randomUUID().toString();
    }

    public String getName() {
        return name;
    }

    public String getLength() {
        return length;
    }
}
