package com.aep.ProjetoConteudoProfessor.entidades;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Favoritos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@OneToMany
	private List<Conteudo> conteudo;
	
	public Favoritos() {
		super();
	}

	public long getId() {
		return id;
	}

	public List<Conteudo> getConteudo() {
		return conteudo;
	}

	public void setConteudo(Conteudo conteudo) {
		this.conteudo.add(conteudo);
	}

}
