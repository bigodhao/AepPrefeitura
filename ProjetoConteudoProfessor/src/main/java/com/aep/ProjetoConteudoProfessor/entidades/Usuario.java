package com.aep.ProjetoConteudoProfessor.entidades;

import com.aep.ProjetoConteudoProfessor.entidades.validador.Genero;

public class Usuario {

		private long id;
		private String nome;
		private String sobrenome;
		private Genero genero;
		private String dataNascimento;
		private String email;
		private String senha;
		private String cpf;
		private DodosProfissional dadosProfissional;
		private Fovoritos favoritos;
		
}
