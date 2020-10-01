package trendyol.bootcamp.playlist.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trendyol.bootcamp.playlist.domain.Playlist;
import trendyol.bootcamp.playlist.domain.Track;
import trendyol.bootcamp.playlist.service.PlaylistService;

import java.util.List;

public class PlaylistController {

    private final PlaylistService playlistService;

    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    public ResponseEntity<Void> createPlaylistByUserId(@RequestParam String userId, @RequestBody Playlist playlist) {
        playlist.setUserId(userId);
        playlistService.insertPlaylist(playlist);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{playlistId}")
    public ResponseEntity<Playlist> findPlaylistById(@PathVariable("playlistId") String playlistId) {
        Playlist playlist = playlistService.findById(playlistId);
        return ResponseEntity.ok().body(playlist);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Playlist>> findAllPlaylistByUserId (@PathVariable("userId") String userId) {
        List<Playlist> playlists = playlistService.findAllByUserId(userId);
        return ResponseEntity.ok(playlistService.findAllByUserId(userId));
    }

    @DeleteMapping("/{playlistId}")
    public ResponseEntity<Void> deletePlayListByPlaylistId(@PathVariable String playlistId) {
        playlistService.deletePlaylist(playlistId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/tracks/{playlistId}")
    public ResponseEntity<Void> addTrackToPlaylistByPlaylistId(@PathVariable String playlistId, @RequestBody Track track) {
        playlistService.insertTrack(playlistId, track);
        return ResponseEntity.ok().build();
    }


    @DeleteMapping("/tracks/{playlistId}")
    public ResponseEntity<Void> removeTrackFromPlaylistByPlaylistId(@PathVariable String playlistId, @RequestBody String trackId) {
        playlistService.deleteTrack(playlistId, trackId);
        return ResponseEntity.ok().build();
    }
}