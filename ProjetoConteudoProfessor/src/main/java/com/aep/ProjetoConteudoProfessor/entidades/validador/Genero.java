package com.aep.ProjetoConteudoProfessor.entidades.validador;

public enum Genero {
	
	MASCULINO('M'),
	FEMININO('F'),
	OUTROS('O');
	private char valor;
	
	Genero(char valor) {
		this.valor = valor;
	}
	public char getGenero() {
		return valor;
	}
	public static Genero valueOf(char valor) {
		if (valor == 'M') {
			return MASCULINO;
		}else if (valor == 'F') {
			return FEMININO;
		}else if (valor == 'O'){
			return OUTROS;
		}else {
			throw new IllegalArgumentException("Sexo invalido");
		}
	}
}
