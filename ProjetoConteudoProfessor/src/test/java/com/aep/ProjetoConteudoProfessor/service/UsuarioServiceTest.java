package com.aep.ProjetoConteudoProfessor.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.runner.RunWith;


import org.mockito.junit.MockitoJUnitRunner;

import com.aep.ProjetoConteudoProfessor.entidades.DadosProfissional;
import com.aep.ProjetoConteudoProfessor.entidades.Favoritos;
import com.aep.ProjetoConteudoProfessor.entidades.NivelEnsino;
import com.aep.ProjetoConteudoProfessor.entidades.Usuario;
import com.aep.ProjetoConteudoProfessor.entidades.validador.Genero;
import com.aep.ProjetoConteudoProfessor.repositories.DadosProfissionalRepository;
import com.aep.ProjetoConteudoProfessor.repositories.FavoritosRepository;
import com.aep.ProjetoConteudoProfessor.repositories.NivelEnsinoRepository;
import com.aep.ProjetoConteudoProfessor.repositories.UsuarioRepository;

@RunWith(MockitoJUnitRunner.class)
public class UsuarioServiceTest {
	
	@Mock
	private UsuarioRepository repository;
	
	@Mock
	private NivelEnsinoRepository nivelEnsinoRepository;
	
	@Mock
	private DadosProfissionalRepository dadosProfissionalRepository;
	
	@Mock
	private FavoritosRepository favoritosRepository;
	
	@InjectMocks
	private UsuarioService service;
	
	@Before
	public void Setup() {
		service = new UsuarioService(repository, nivelEnsinoRepository, dadosProfissionalRepository, favoritosRepository);
	}
	
	@Test
	public void findById() {
		
		NivelEnsino nivelEnsino1 = new NivelEnsino("SEGUNDO ANO");		
		DadosProfissional profissional = new DadosProfissional();
		profissional.setNivelEnsino(nivelEnsino1);				
		Favoritos favoritos = new Favoritos();				
		Usuario usuario1 = new Usuario("João ", "Carvalho", Genero.MASCULINO, "27/07/2001",
				"JOAO@GMAIL.COM", "123", "04529447910", profissional, favoritos);
		
		when(repository.findById(100L)).thenReturn(Optional.of(usuario1));
		
		Usuario result = service.findById(100L);
		
		assertThat(result.getId()).isNotNull();
		
	}
	
	@Test
	public void save() {
		NivelEnsino nivelEnsino1 = new NivelEnsino("SEGUNDO ANO");		
		DadosProfissional profissional = new DadosProfissional();
		profissional.setNivelEnsino(nivelEnsino1);				
		Favoritos favoritos = new Favoritos();
		Usuario usuario1 = new Usuario("João ", "Carvalho", Genero.MASCULINO, "27/07/2001",
				"JOAO@GMAIL.COM", "123", "04529447910", profissional, favoritos);
		
		when(nivelEnsinoRepository.save(nivelEnsino1)).thenReturn(null);
		when(dadosProfissionalRepository.save(profissional)).thenReturn(null);
		
		
		when(repository.save(usuario1)).thenReturn(usuario1);
		
		Usuario result = service.insert(usuario1);
		
		assertThat(result.getId()).isNotNull();
	}
	
	@Test
	public void update() {
		NivelEnsino nivelEnsino1 = new NivelEnsino("SEGUNDO ANO");		
		DadosProfissional profissional = new DadosProfissional();
		profissional.setNivelEnsino(nivelEnsino1);				
		Favoritos favoritos = new Favoritos();
		Usuario usuario1 = new Usuario("João ", "Carvalho", Genero.MASCULINO, "27/07/2001",
				"JOAO@GMAIL.COM", "123", "04529447910", profissional, favoritos);

		
		when(repository.save(usuario1)).thenReturn(usuario1);
		when(repository.findById(100L)).thenReturn(Optional.of(usuario1));
		
		usuario1.setNome("paulo");
		
		Usuario result = service.update(100L, usuario1);
		
		assertThat(result.getId()).isNotNull();
		assertThat(result.getNome()).isEqualTo(usuario1.getNome());
	}
	
	@Test
	public void delete() {
		NivelEnsino nivelEnsino1 = new NivelEnsino("SEGUNDO ANO");		
		DadosProfissional profissional = new DadosProfissional();
		profissional.setNivelEnsino(nivelEnsino1);				
		Favoritos favoritos = new Favoritos();
		Usuario usuario1 = new Usuario("João ", "Carvalho", Genero.MASCULINO, "27/07/2001",
				"JOAO@GMAIL.COM", "123", "04529447910", profissional, favoritos);
		
		when(repository.findById(100L)).thenReturn(Optional.of(usuario1));
		
		Boolean result = service.delete(100L);
		
		assertThat(result).isTrue();
	}
	
	@Test
	public void deleteError() {
		NivelEnsino nivelEnsino1 = new NivelEnsino("SEGUNDO ANO");		
		DadosProfissional profissional = new DadosProfissional();
		profissional.setNivelEnsino(nivelEnsino1);				
		Favoritos favoritos = new Favoritos();
		Usuario usuario1 = new Usuario("João ", "Carvalho", Genero.MASCULINO, "27/07/2001",
				"JOAO@GMAIL.COM", "123", "04529447910", profissional, favoritos);
		
		when(repository.findById(100L)).thenReturn(Optional.ofNullable(null));
		
		Boolean result = service.delete(100L);
		
		assertThat(result).isFalse();
	}
	
}
