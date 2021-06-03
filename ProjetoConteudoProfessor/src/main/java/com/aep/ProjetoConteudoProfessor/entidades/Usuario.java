package com.aep.ProjetoConteudoProfessor.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.aep.ProjetoConteudoProfessor.entidades.validador.Cpf;
import com.aep.ProjetoConteudoProfessor.entidades.validador.Genero;
import com.sun.istack.NotNull;

@Entity
public class Usuario {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		
		@NotNull
		private String nome;
		
		@NotNull
		private String sobrenome;
		
		@NotNull
		private char genero;
		
		@NotNull
		private String dataNascimento;
		
		@NotNull
		private String email;
		
		@NotNull
		private String senha;
		
		@NotNull
		private String cpf;
		
		@NotNull
		@OneToOne
		private DadosProfissional dadosProfissional;
		
		@OneToOne
		private Favoritos favoritos;
		
		public Usuario() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Usuario(String nome, String sobrenome, Genero genero, String dataNascimento, String email,
				String senha, String cpf, DadosProfissional dadosProfissional, Favoritos favoritos) {
			super();
			this.nome = nome;
			this.sobrenome = sobrenome;
			setGenero(genero);
			this.dataNascimento = dataNascimento;
			this.email = email;
			this.senha = senha;
			setCpf(cpf);
			this.dadosProfissional = dadosProfissional;
			this.favoritos = favoritos;
		}
		
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getSobrenome() {
			return sobrenome;
		}
		public void setSobrenome(String sobrenome) {
			this.sobrenome = sobrenome;
		}
		public Genero getGenero() {
			return Genero.valueOf(genero);
		}
		public void setGenero(Genero genero) {
			this.genero = genero.getGenero();
		}
		public String getDataNascimento() {
			return dataNascimento;
		}
		public void setDataNascimento(String dataNascimento) {
			this.dataNascimento = dataNascimento;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getSenha() {
			return senha;
		}
		public void setSenha(String senha) {
			this.senha = senha;
		}
		public String getCpf() {
			return cpf;
		}
		public void setCpf(String cpf) {
			try {
				this.cpf = Cpf.validar(cpf);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public DadosProfissional getDadosProfissional() {
			return dadosProfissional;
		}
		public void setDadosProfissional(DadosProfissional dadosProfissional) {
			this.dadosProfissional = dadosProfissional;
		}
		public Favoritos getFavoritos() {
			return favoritos;
		}
		public void setFavoritos(Favoritos favoritos) {
			this.favoritos = favoritos;
		}
		public long getId() {
			return id;
		}
		@Override
		public String toString() {
			return "Usuario [nome=" + nome + ", sobrenome=" + sobrenome + ", genero=" + genero + ", dataNascimento="
					+ dataNascimento + ", email=" + email + ", senha=" + senha + ", cpf=" + cpf + ", dadosProfissional="
					+ dadosProfissional + ", favoritos=" + favoritos + "]";
		}
		
}
