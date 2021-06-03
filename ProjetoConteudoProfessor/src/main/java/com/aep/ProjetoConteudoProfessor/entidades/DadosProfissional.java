package com.aep.ProjetoConteudoProfessor.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class DadosProfissional {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String instituicaoProfissional;
	private String areaProfissional;
	
	@ManyToOne
	private NivelEnsino nivelEnsino;
	
	
	
	public DadosProfissional() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DadosProfissional(String instituicaoProfissional, String areaProfissional, NivelEnsino nivelEnsino) {
		super();
		this.instituicaoProfissional = instituicaoProfissional;
		this.areaProfissional = areaProfissional;
		this.nivelEnsino = nivelEnsino;
	}
	
	public String getInstituicaoProfissional() {
		return instituicaoProfissional;
	}
	public void setInstituicaoProfissional(String instituicaoProfissional) {
		this.instituicaoProfissional = instituicaoProfissional;
	}
	public String getAreaProfissional() {
		return areaProfissional;
	}
	public void setAreaProfissional(String areaProfissional) {
		this.areaProfissional = areaProfissional;
	}
	public NivelEnsino getNivelEnsino() {
		return nivelEnsino;
	}
	public void setNivelEnsino(NivelEnsino nivelEnsino) {
		this.nivelEnsino = nivelEnsino;
	}
	public long getId() {
		return id;
	}
}
