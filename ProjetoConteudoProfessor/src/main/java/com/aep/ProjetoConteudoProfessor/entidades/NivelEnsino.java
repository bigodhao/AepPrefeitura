package com.aep.ProjetoConteudoProfessor.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class NivelEnsino {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String descricao;
	
	public NivelEnsino() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NivelEnsino(String descricao) {
		super();
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public long getId() {
		return id;
	}
}
