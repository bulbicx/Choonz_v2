package com.qa.choonz.unittest.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import com.qa.choonz.persistence.domain.Album;
import com.qa.choonz.persistence.domain.Artist;
import com.qa.choonz.persistence.domain.Genre;
import com.qa.choonz.persistence.domain.Image;
import com.qa.choonz.persistence.domain.Playlist;
import com.qa.choonz.persistence.domain.PublicUser;
import com.qa.choonz.persistence.domain.Session;
import com.qa.choonz.persistence.domain.Track;
import com.qa.choonz.persistence.domain.User;
import com.qa.choonz.persistence.repository.AdminUserRepository;
import com.qa.choonz.persistence.repository.AlbumRepository;
import com.qa.choonz.persistence.repository.ArtistRepository;
import com.qa.choonz.persistence.repository.GenreRepository;
import com.qa.choonz.persistence.repository.ImageRepository;
import com.qa.choonz.persistence.repository.SessionRepository;
import com.qa.choonz.persistence.repository.TrackRepository;
import com.qa.choonz.rest.dto.AlbumDTO;
import com.qa.choonz.service.AlbumService;

@SpringBootTest
public class AlbumServiceTest {

	@MockBean
	private AlbumRepository repo;
	
	@MockBean
	private ArtistRepository artistRepo;
	
	@MockBean 
	private GenreRepository genreRepo;
	
	@MockBean 
	private TrackRepository trackRepo;
	
	@MockBean
	private ImageRepository imageRepo;
	
	@MockBean
	private SessionRepository sessionRepo;
	
	@MockBean
	private AdminUserRepository adminRepo;
	
	@Autowired
	private AlbumService service;
	
	private Image image = new Image(0L, "image name", "image type", null);
	private Genre genre = new Genre(0L, "genre name", "genre desc", new ArrayList<>(), image);
	private Optional<Genre> optionalGenre = Optional.of(new Genre(0L, "genre name", "genre desc", new ArrayList<>(), image));
	private Artist artist = new Artist(0L, "artist name", new ArrayList<>(), image);
	private Optional<Artist> optionalArtist = Optional.of(new Artist(0L, "artist name", new ArrayList<>(), image));
	private Album album = new Album(0L, "album name",  new ArrayList<>(), artist, genre, image);
	private AlbumDTO albumDTO = new AlbumDTO(0L, "album name",  new ArrayList<>(), artist, genre, image);
	private Optional<Album> optionalAlbum = Optional.of(new Album(0L, "album name",  new ArrayList<>(), artist, genre, image));
	private Album newAlbum = new Album(0L, "new album name",  new ArrayList<>(), artist, genre, image);
	private AlbumDTO newAlbumDTO = new AlbumDTO(0L, "new album name",  new ArrayList<>(), artist, genre, image);
	private Track track = new Track(0L, "track name", album, new ArrayList<>(), 120, "lyrics");
	private Optional<Track> optionalTrack = Optional.of(new Track(0L, "track name", album, new ArrayList<>(), 120, "lyrics"));
	
	List<Track> tracklist = Stream.of(track).collect(Collectors.toList());
	private Album albumWithTrack = new Album(0L, "album name",  tracklist, artist, genre, image);
	private Optional<Album> optionalAlbumWithTrack = Optional.of(new Album(0L, "album name",  tracklist, artist, genre, image));
	private AlbumDTO albumWithTrackDTO = new AlbumDTO(0L, "album name",  tracklist, artist, genre, image);
	
	
//	@Test
//	public void AlbumCreateTest() throws Exception {
//		
//		String token = "$31$11$Zhi4PT548-kYfpgwiOM8aE0EkCLkyHOQuKyUI_S1Fb0";
//		PublicUser adam = new PublicUser(1L, "username", "name", "password", new ArrayList<>(), new ArrayList<>());
//		Session session = new Session(1L, adam, token);
//		Mockito.when(this.sessionRepo.findByToken(token)).thenReturn(session);
//		Mockito.when(this.adminRepo.existsById(1L)).thenReturn(true);
//		
//		Mockito.when(this.artistRepo.findById(0L)).thenReturn(optionalArtist);
//		Mockito.when(this.genreRepo.findById(0L)).thenReturn(optionalGenre);
//		Mockito.when(this.imageRepo.save(image)).thenReturn(image);
//		Mockito.when(this.repo.save(album)).thenReturn(album);
////		final MultipartFile mockFile = mock(MultipartFile.class);
////		Mockito.when(mockFile.getOriginalFilename()).thenReturn("CoolName");
////		Mockito.when(mockFile.getContentType()).thenReturn("CoolName");
//		byte[] byteImage2 = new byte[1];
//		MockMultipartFile firstFile = new MockMultipartFile("file", "testimage.png", MediaType.IMAGE_PNG_VALUE, byteImage2);
////		Mockito.when(mockFile.getBytes()).thenReturn(byteImage2);
//		assertThat(this.service.create(0L, 0L, firstFile, "album name", token)).isEqualTo(albumDTO);
//		
//		Mockito.verify(this.repo, Mockito.times(1)).save(album);
//		Mockito.verify(this.artistRepo, Mockito.times(1)).findById(0L);
//		Mockito.verify(this.genreRepo, Mockito.times(1)).findById(0L);
//	}
	
	@Test
	public void AlbumReadAllTest() {
		
		Mockito.when(this.repo.findAll()).thenReturn(new ArrayList<>());
		
		assertThat(new ArrayList<>()).isEqualTo(this.service.read());
		
		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}
	
	@Test
	public void AlbumReadByIdTest() {
		Mockito.when(this.repo.findById(0L)).thenReturn(optionalAlbum);
		
		assertThat(albumDTO).isEqualTo(this.service.read(0L));
		
		Mockito.verify(this.repo, Mockito.times(1)).findById(0L);
	}
	
	@Test
	public void AlbumUpdateTest() {
		Mockito.when(this.repo.findById(0L)).thenReturn(optionalAlbum);
		Mockito.when(this.repo.save(newAlbum)).thenReturn(newAlbum);
		Mockito.when(this.artistRepo.findById(0L)).thenReturn(optionalArtist);
		Mockito.when(this.genreRepo.findById(0L)).thenReturn(optionalGenre);
		
		assertThat(newAlbumDTO).isEqualTo(this.service.update(newAlbum, 0L, 0L, 0L));
		
		Mockito.verify(this.repo, Mockito.times(1)).findById(0L);
		Mockito.verify(this.repo, Mockito.times(1)).save(newAlbum);
		Mockito.verify(this.artistRepo, Mockito.times(1)).findById(0L);
		Mockito.verify(this.genreRepo, Mockito.times(1)).findById(0L);
	}
	
	@Test
	public void AlbumDeleteTest() {
		assertThat(true).isEqualTo(this.service.delete(0L));
	}
	
	@Test
	public void AlbumAddTrackTest() {
		
		Mockito.when(this.trackRepo.findById(0L)).thenReturn(optionalTrack);
		Mockito.when(this.repo.findById(0L)).thenReturn(optionalAlbum);
		Mockito.when(this.repo.save(albumWithTrack)).thenReturn(albumWithTrack);
		
		assertThat(albumWithTrackDTO).isEqualTo(this.service.addTrack(0L, 0L));
		
		Mockito.verify(this.trackRepo, Mockito.times(1)).findById(0L);
		Mockito.verify(this.repo, Mockito.times(1)).findById(0L);
		Mockito.verify(this.repo, Mockito.times(1)).save(albumWithTrack);
	}
	
	@Test
	public void AlbumRemoveTrackTest() {
		Mockito.when(this.trackRepo.findById(0L)).thenReturn(optionalTrack);
		Mockito.when(this.repo.findById(0L)).thenReturn(optionalAlbumWithTrack);
		Mockito.when(this.repo.save(album)).thenReturn(album);
		
		assertThat(albumDTO).isEqualTo(this.service.removeTrack(0L, 0L));
		
		Mockito.verify(this.trackRepo, Mockito.times(1)).findById(0L);
		Mockito.verify(this.repo, Mockito.times(1)).findById(0L);
		Mockito.verify(this.repo, Mockito.times(1)).save(album);
		
	}
}
