package com.aep.ProjetoConteudoProfessor.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.aep.ProjetoConteudoProfessor.entidades.Conteudo;
import com.aep.ProjetoConteudoProfessor.entidades.DadosProfissional;
import com.aep.ProjetoConteudoProfessor.entidades.Favoritos;
import com.aep.ProjetoConteudoProfessor.entidades.NivelEnsino;
import com.aep.ProjetoConteudoProfessor.entidades.Usuario;
import com.aep.ProjetoConteudoProfessor.entidades.validador.Genero;
import com.aep.ProjetoConteudoProfessor.repositories.DadosProfissionalRepository;
import com.aep.ProjetoConteudoProfessor.repositories.FavoritosRepository;
import com.aep.ProjetoConteudoProfessor.repositories.NivelEnsinoRepository;
import com.aep.ProjetoConteudoProfessor.repositories.UsuarioRepository;

@Configuration
public class testConfig  implements CommandLineRunner{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private NivelEnsinoRepository nivelEnsinoRepository;
	
	@Autowired
	private DadosProfissionalRepository dadosProfissionalRepository;
	
	@Autowired
	private FavoritosRepository favoritosRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		NivelEnsino nivelEnsino1 = new NivelEnsino("SEGUNDO ANO");
		
		nivelEnsinoRepository.save(nivelEnsino1);
		
		DadosProfissional profissional = new DadosProfissional();
		profissional.setNivelEnsino(nivelEnsino1);
		
		dadosProfissionalRepository.save(profissional);
		
		Favoritos favoritos = new Favoritos();
		
		favoritosRepository.save(favoritos);
		
		
//		Usuario usuario1 = new Usuario("João ", "Carvalho", Genero.MASCULINO, "27/07/2001",
//				"JOAO@GMAIL.COM", "123", "04529447910", profissional, favoritos);
		Usuario usuario2 = new Usuario("Paulo ", "França", Genero.MASCULINO, "20/05/1995",
				"PAULO@GMAIL.COM", "12345", "10026219840", profissional, favoritos);
		
		usuarioRepository.saveAll(Arrays.asList(usuario2));
		
	}
}
