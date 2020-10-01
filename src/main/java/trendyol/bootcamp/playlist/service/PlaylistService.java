package trendyol.bootcamp.playlist.service;


import org.springframework.stereotype.Service;
import trendyol.bootcamp.playlist.domain.Playlist;
import trendyol.bootcamp.playlist.domain.Track;
import trendyol.bootcamp.playlist.repository.PlaylistRepository;

import java.util.List;

@Service
public class PlaylistService {

    private final PlaylistRepository playlistRepository;

    public PlaylistService(PlaylistRepository playlistRepository) {

        this.playlistRepository = playlistRepository;
    }

    public void insertPlaylist(Playlist playlist) {
        playlistRepository.insert(playlist);
    }

    public void deletePlaylist(String id) {
        playlistRepository.delete(id);
    }

    public Playlist findById(String playlistId) {
        return playlistRepository.findById(playlistId);
    }

    public List<Playlist> findAllByUserId(String userId) {
        return playlistRepository.findAllByUserId(userId);
    }

    public void insertTrack(String playlistId, Track track){
        playlistRepository.insertTrack(playlistId,track);
    }

    public void deleteTrack(String playlistId, String trackId){
        playlistRepository.deleteTrack(playlistId,trackId);
    }

}