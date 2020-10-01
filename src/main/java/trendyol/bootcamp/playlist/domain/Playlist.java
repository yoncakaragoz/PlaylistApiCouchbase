package trendyol.bootcamp.playlist.domain;


import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Getter
@Setter
public class Playlist {

    private String id;
    private String name;
    private String description;
    private int followersCount;
    private List<Track> tracks;
    private int trackCount;
    private String userId;



    public Playlist() {

        this.id = UUID.randomUUID().toString();
        this.name = "test";
        this.description = "test";
        this.followersCount = 0;
        this.tracks = new ArrayList<Track>();
        this.trackCount = 0;
        this.userId = "";

    }

    public String getId() {
        return id;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void addTrack(Track track) {
        this.tracks.add(track);
        this.trackCount++;
    }

    public void removeTrack(String index) {
        for(Track item: tracks ){
            if(item.getName().equals(index) && tracks.remove(item)){
                trackCount--;
            }
        }
    }



}
