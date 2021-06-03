package com.aep.ProjetoConteudoProfessor.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Conteudo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String disciplina;
	private String descricao;
	private String titulo;
	
	@ManyToOne
	private NivelEnsino nivelEnsino;
	
	@OneToOne
	private Usuario usuario;
	
	public Conteudo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Conteudo(String disciplina, String descricao, String titulo, NivelEnsino nivelEnsino, Usuario usuario) {
		super();
		this.disciplina = disciplina;
		this.descricao = descricao;
		this.titulo = titulo;
		this.nivelEnsino = nivelEnsino;
		this.usuario = usuario;
	}
	public String getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public NivelEnsino getNivelEnsino() {
		return nivelEnsino;
	}
	public void setNivelEnsino(NivelEnsino nivelEnsino) {
		this.nivelEnsino = nivelEnsino;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public long getId() {
		return id;
	}
	
}
