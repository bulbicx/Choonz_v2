package com.qa.choonz.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RouteController {
    @GetMapping(value = "/")
    public String index() {
        return "index.html";
    }

    @GetMapping(value = "/home")
    public String home() {
        return "index.html";
    }


    @GetMapping(value = "/tracks")
    public String tracks() {
        return "tracks.html";
    }
    
    @GetMapping(value = "/albums")
    public String albums() {
        return "albums.html";
    }
    
    @GetMapping(value = "/albumsingle")
    public String albumSingle() {
        return "albumsingle.html";
    }
    
    @GetMapping(value = "/artists")
    public String artists() {
    	return "artists.html";
    }
    
    @GetMapping(value = "/artistsingle")
    public String artistSingle() {
    	return "artistsingle.html";
    }
    
    @GetMapping(value = "/genres")
    public String genres() {
    	return "genres.html";
    }
    
    @GetMapping(value = "/genresingle")
    public String genreSingle() {
    	return "genresingle.html";
    }
    
    @GetMapping(value = "/playlists")
    public String playlists() {
    	return "playlists.html";
    }
    
    @GetMapping(value = "/playlistsingle")
    public String playlistSingle() {
    	return "playlistsingle.html";
    }

    @GetMapping(value = "/track")
    public String track() {
        return "track.html";
    }
    
    @GetMapping(value = "/admindashboard")
    public String adminDashboard() {
        return "admindashboard.html";
    }
    
    @GetMapping(value = "/adminlogin")
    public String adminLogin() {
        return "adminlogin.html";
    }
    
    @GetMapping(value = "/artistCrud")
    public String artistCrud() {
    	return "artistCrud.html";
    }
    
    @GetMapping(value = "/albumCrud")
    public String albumCrud() {
        return "albumCrud.html";
    }
    
    @GetMapping(value = "/genreCrud")
    public String genreCrud() {
        return "genreCrud.html";
    }
    
    @GetMapping(value = "/trackCrud")
    public String trackCrud() {
        return "trackCrud.html";
    }
    
    @GetMapping(value = "/login")
    public String login() {
    	return "login.html";
    }
}
