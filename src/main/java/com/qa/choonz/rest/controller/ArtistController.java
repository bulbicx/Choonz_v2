package com.qa.choonz.rest.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.qa.choonz.persistence.domain.Artist;
import com.qa.choonz.rest.dto.ArtistDTO;
import com.qa.choonz.rest.dto.GenreDTO;
import com.qa.choonz.service.ArtistService;

@RestController
@RequestMapping("/artists")
@CrossOrigin
public class ArtistController {

    private ArtistService service;

    public ArtistController(ArtistService service) {
        super();
        this.service = service;
    }
    
    @PostMapping("/create")
    public ResponseEntity<ArtistDTO> create( 
    		@RequestParam("file") MultipartFile file,
    		@RequestParam("name") String name,
    		@RequestParam("token") String token
    		) throws Exception {
        return new ResponseEntity<ArtistDTO>(this.service.create(file, name, token), HttpStatus.CREATED);
    }

    @GetMapping("/read")
    public ResponseEntity<List<ArtistDTO>> read() {
        return new ResponseEntity<List<ArtistDTO>>(this.service.read(), HttpStatus.OK);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<ArtistDTO> read(@PathVariable long id) {
        return new ResponseEntity<ArtistDTO>(this.service.read(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ArtistDTO> update(@RequestBody Artist artist, @PathVariable long id) {
        return new ResponseEntity<ArtistDTO>(this.service.update(artist, id), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ArtistDTO> delete(@PathVariable Long id) {
        return this.service.delete(id) ? new ResponseEntity<ArtistDTO>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<ArtistDTO>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
