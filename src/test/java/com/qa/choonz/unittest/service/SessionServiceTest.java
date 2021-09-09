package com.qa.choonz.unittest.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.choonz.persistence.domain.AdminUser;
import com.qa.choonz.persistence.domain.PublicUser;
import com.qa.choonz.persistence.domain.Session;
import com.qa.choonz.persistence.repository.AdminUserRepository;
import com.qa.choonz.persistence.repository.PublicUserRepository;
import com.qa.choonz.persistence.repository.SessionRepository;
import com.qa.choonz.rest.dto.SessionDTO;
import com.qa.choonz.service.SessionService;
import com.qa.choonz.utils.PasswordAuthentication;
import com.qa.choonz.utils.SessionTokens;

@SpringBootTest
public class SessionServiceTest {
	
	@MockBean
	private SessionRepository repo;
	
	@MockBean
	private PublicUserRepository userRepo;
	
	@MockBean
	private AdminUserRepository adminUserRepo;
	
	@MockBean
	private ModelMapper mapper;
	
	@Autowired
	private SessionService service;
	
	private PublicUser user = new PublicUser(0L, "username", "real name", "password", new ArrayList<>(), new ArrayList<>());
	private AdminUser adminUser = new AdminUser(0L, "username", "real name", "password", new ArrayList<>());
	private Optional<PublicUser> optionalUser = Optional.of(new PublicUser(0L, "username", "real name", "password", new ArrayList<>(), new ArrayList<>()));
	private Optional<AdminUser> optionalAdminUser = Optional.of(new AdminUser(0L, "username", "real name", "password", new ArrayList<>()));
	private String token = "$31$11$Zhi4PT548-kYfpgwiOM8aE0EkCLkyHOQuKyUI_S1Fb0";
	private Session session = new Session(0L, user, token);
	private SessionDTO sessionDTO = new SessionDTO(0L, user, token);
	char[] pass = user.getPassword().toCharArray();
	private final PasswordAuthentication passwordAuth = new PasswordAuthentication(10);
	
	
	@Test
	public void SessionUserAuthTest() {
		Mockito.when(this.userRepo.findByUsername("username")).thenReturn(optionalUser);
		this.passwordAuth.authenticate(pass, token);
		Session session = new Session();
		session.setToken(token);
		session.setUser(user);
		Mockito.when(this.repo.save(session)).thenReturn(session);
		Mockito.when(this.mapper.map(session, SessionDTO.class)).thenReturn(sessionDTO);
		
		assertThat(sessionDTO).isEqualTo(service.authenticate(user));
		
		Mockito.verify(this.repo, Mockito.times(1)).save(session);
		Mockito.verify(this.userRepo, Mockito.times(1)).findByUsername("username");
		
	}
	
	@Test
	public void SessionAdminUserAuthTest() {
		Mockito.when(this.adminUserRepo.findByUsername("username")).thenReturn(optionalAdminUser);
		Mockito.when(this.repo.save(session)).thenReturn(session);
		Mockito.when(this.passwordAuth.authenticate(pass, adminUser.getPassword())).thenReturn(true);
		
		assertThat(service.authenticate(adminUser)).isEqualTo(session);
		
		Mockito.verify(this.repo, Mockito.times(1)).save(session);
		Mockito.verify(this.userRepo, Mockito.times(1)).findByUsername("username");
		
	}
	
	@Test
	public void CreateSessionPublicUserTest() {
//		String token = sessionToken.newSessionToken();
		Session session = new Session();
		session.setToken(token);
		session.setUser(user);
		SessionDTO sessionDTO = new SessionDTO(0L, user, token);
		
//		Mockito.when(this.repo.save(session)).thenReturn(session);
//		Mockito.when(this.mapper.map(session, SessionDTO.class)).thenReturn(sessionDTO);
		assertThat(service.createSession(user)).isEqualTo(null);
		
		Mockito.verify(this.repo, Mockito.times(1)).save(session);
	}
	
	@Test
	public void CreateSessionAdminUserTest() {
		Mockito.when(this.repo.save(session)).thenReturn(session);
		
		assertThat(service.createSession(adminUser)).isEqualTo(sessionDTO);
		
		Mockito.verify(this.repo, Mockito.times(1)).save(session);
	}
	
	@Test
	public void deleteSessionTest() {
		Mockito.when(this.repo.findByToken(token)).thenReturn(session);
		Mockito.when(this.repo.existsById(session.getId())).thenReturn(false);
		assertThat(service.delete(token)).isEqualTo(true);
		
		Mockito.verify(this.repo, Mockito.times(1)).findByToken(token);
		Mockito.verify(this.repo, Mockito.times(1)).existsById(session.getId());
	}

}
