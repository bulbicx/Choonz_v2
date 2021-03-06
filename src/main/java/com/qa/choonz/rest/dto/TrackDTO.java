package com.qa.choonz.rest.dto;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.qa.choonz.persistence.domain.Album;
import com.qa.choonz.persistence.domain.Playlist;

public class TrackDTO {

    private Long id;
    private String name;
    private Album album;
    private List<Playlist> playlist;
    private Integer duration;
    private String lyrics;

    public TrackDTO() {
        super();
    }
    public TrackDTO(Long id, String name, Album album, List<Playlist> playlist, Integer duration,
            String lyrics) {
        super();
        this.id = id;
        this.name = name;
        this.album = album;
        this.playlist = playlist;
        this.duration = duration;
        this.lyrics = lyrics;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public List<Playlist> getPlaylist() {
        return playlist;
    }

    public void setPlaylist(List<Playlist> playlist) {
        this.playlist = playlist;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("TrackDTO [id=").append(id).append(", name=").append(name).append(", album=").append(album)
                .append(", playlist=").append(playlist).append(", duration=").append(duration).append(", lyrics=")
                .append(lyrics).append("]");
        return builder.toString();
    }

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
            return true;
        }
        if (!(obj instanceof TrackDTO)) {
            return false;
        }
		TrackDTO other = (TrackDTO) obj;
		return Objects.equals(album, other.album) && duration == other.duration && id == other.id
				&& Objects.equals(lyrics, other.lyrics) && Objects.equals(name, other.name)
				&& Objects.equals(playlist, other.playlist);
	}

}
