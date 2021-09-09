package com.qa.choonz.unittest.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;

import com.qa.choonz.persistence.domain.Artist;
import com.qa.choonz.persistence.domain.Image;
import com.qa.choonz.persistence.domain.PublicUser;
import com.qa.choonz.persistence.domain.Session;
import com.qa.choonz.persistence.repository.AdminUserRepository;
import com.qa.choonz.persistence.repository.ArtistRepository;
import com.qa.choonz.persistence.repository.SessionRepository;
import com.qa.choonz.rest.dto.ArtistDTO;
import com.qa.choonz.service.ArtistService;

@SpringBootTest
public class ArtistServiceTest {
	
	@MockBean
	private ArtistRepository repo;
	
	@MockBean
	private AdminUserRepository adminRepo;
	
	@MockBean
	private SessionRepository sessionRepo;
	
	@Autowired
	private ArtistService service;
	
	private Image image = new Image(0L, "image name", "image type", null);
	private Artist artist = new Artist(0L, "artist name", new ArrayList<>(), image);
	private ArtistDTO artistDTO = new ArtistDTO(0L, "artist name", new ArrayList<>(), image);
	private Optional<Artist> optionalArtist = Optional.of(new Artist(0L, "artist name", new ArrayList<>(), image));
	private Artist newArtist = new Artist(0L, "new artist name", new ArrayList<>(), image);
	private ArtistDTO newArtistDTO = new ArtistDTO(0L, "new artist name", new ArrayList<>(), image);
	
//	@Test
//	public void ArtistCreateTest() throws Exception {
//		
//		Mockito.when(this.repo.save(artist)).thenReturn(artist);
//		byte[] byteImage2 = new byte[1];
//		MockMultipartFile firstFile = new MockMultipartFile("file", "testimage.png", MediaType.IMAGE_PNG_VALUE, byteImage2);
//		String token = "$31$11$Zhi4PT548-kYfpgwiOM8aE0EkCLkyHOQuKyUI_S1Fb0";
//		assertThat(artistDTO).isEqualTo(this.service.create(firstFile, "artist name", token));
//		
//		Mockito.verify(this.repo, Mockito.times(1)).save(artist);
//	}
	
	@Test
	public void ArtistReadAllTest() {
		
		Mockito.when(this.repo.findAll()).thenReturn(new ArrayList<>());
		
		assertThat(new ArrayList<>()).isEqualTo(this.service.read());
		
		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}
	
	@Test
	public void ArtistReadByIdTest() {
		Mockito.when(this.repo.findById(0L)).thenReturn(optionalArtist);
		
		assertThat(this.service.read(0L)).isEqualTo(artistDTO);
		
		Mockito.verify(this.repo, Mockito.times(1)).findById(0L);
	}
	
	@Test
	public void ArtistUpdateTest() {
		Mockito.when(this.repo.findById(0L)).thenReturn(optionalArtist);
		Mockito.when(this.repo.save(newArtist)).thenReturn(newArtist);
		
		assertThat(newArtistDTO).isEqualTo(this.service.update(newArtist, 0L));
		
		Mockito.verify(this.repo, Mockito.times(1)).findById(0L);
		Mockito.verify(this.repo, Mockito.times(1)).save(newArtist);
	}
	
	@Test
	public void ArtistDeleteTest() {
		assertThat(true).isEqualTo(this.service.delete(0L));
	}

}
