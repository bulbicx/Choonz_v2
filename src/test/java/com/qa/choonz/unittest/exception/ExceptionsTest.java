package com.qa.choonz.unittest.exception;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import javax.persistence.PersistenceException;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.choonz.exception.AlbumNotFoundException;
import com.qa.choonz.exception.ArtistNotFoundException;
import com.qa.choonz.exception.GenreNotFoundException;
import com.qa.choonz.exception.PlaylistNotFoundException;
import com.qa.choonz.exception.SessionNotFoundException;
import com.qa.choonz.exception.TrackNotFoundException;
import com.qa.choonz.exception.UserNotFoundException;
import com.qa.choonz.persistence.repository.TrackRepository;

@SpringBootTest
public class ExceptionsTest {
	
	@MockBean
	private TrackRepository repo;
	
	
	@Test
	public void AlbumNotFoundTest() {
		assertThatThrownBy(() -> {throw new AlbumNotFoundException();})
						.isInstanceOf(PersistenceException.class)
						.hasMessage(null);
	}
	
	@Test
	public void ArtistNotFoundTest() {
		assertThatThrownBy(() -> {throw new ArtistNotFoundException();})
						.isInstanceOf(PersistenceException.class)
						.hasMessage(null);
	}
	
	@Test
	public void TrackNotFoundTest() {
		assertThatThrownBy(() -> {throw new TrackNotFoundException();})
						.isInstanceOf(PersistenceException.class)
						.hasMessage(null);
	}
	
	@Test
	public void GenreNotFoundTest() {
		assertThatThrownBy(() -> {throw new GenreNotFoundException();})
						.isInstanceOf(PersistenceException.class)
						.hasMessage(null);
	}
	
	@Test
	public void UserNotFoundTest() {
		assertThatThrownBy(() -> {throw new UserNotFoundException();})
						.isInstanceOf(PersistenceException.class)
						.hasMessage(null);
	}
	
	@Test
	public void SessionNotFoundTest() {
		assertThatThrownBy(() -> {throw new SessionNotFoundException();})
						.isInstanceOf(PersistenceException.class)
						.hasMessage(null);
	}
	
	@Test
	public void PlaylistNotFoundTest() {
		assertThatThrownBy(() -> {throw new PlaylistNotFoundException();})
						.isInstanceOf(PersistenceException.class)
						.hasMessage(null);
	}
}
