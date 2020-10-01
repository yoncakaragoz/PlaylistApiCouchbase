package trendyol.bootcamp.playlist.repository;


import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.Collection;
import com.couchbase.client.java.kv.GetResult;
import com.couchbase.client.java.query.QueryResult;
import org.springframework.stereotype.Repository;
import trendyol.bootcamp.playlist.domain.Playlist;
import trendyol.bootcamp.playlist.domain.Track;

import java.util.List;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Repository
public class PlaylistRepository {


    private final Cluster cluster;
    private final Collection collection;


    public PlaylistRepository(Cluster couchbaseCluster, Collection playlistCollection) {
        this.cluster = couchbaseCluster;
        this.collection = playlistCollection;
    }

    public void insert(Playlist playlist) {
        collection.insert(playlist.getId(), playlist);
    }

    public void update(Playlist playlist) {
        collection.replace(playlist.getId(), playlist);
    }

    public void delete(String playlistId){
        collection.remove(playlistId);
    }

    public Playlist findById(String id) {
        GetResult getResult = collection.get(id);
        Playlist playlist = getResult.contentAs(Playlist.class);
        return playlist;
    }

    public List<Playlist> findAllByUserId(String userId) {
        String statement = String.format("Select id, name, description, followersCount, tracks, userId from playlist WHERE playlist.userId = '%s';", userId);
        QueryResult query = cluster.query(statement);
        return query.rowsAs(Playlist.class);
    }

    public void insertTrack(String playlistId, Track addingTrack){
        Playlist playlist =  findById(playlistId);
        playlist.addTrack(addingTrack);
        collection.replace(playlist.getId(),playlist);
    }
    public void deleteTrack(String playlistId, String trackId){
        Playlist playlist =  findById(playlistId);
        playlist.removeTrack(trackId);
        collection.replace(playlist.getId(),playlist);
    }
}
