package com.aep.ProjetoConteudoProfessor.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aep.ProjetoConteudoProfessor.entidades.Conteudo;
import com.aep.ProjetoConteudoProfessor.repositories.ConteudoRepository;

@Service
public class ConteudoService {
	
	@Autowired
	private ConteudoRepository repository;
	
	public List<Conteudo> findAll(){
		return repository.findAll();
	}
	
	public Conteudo findById(long id) {
		Optional<Conteudo> obj = repository.findById(id);
		return obj.orElse(null);
	}
	
	public Conteudo insert (Conteudo obj) {
		return repository.save(obj); // realizar melhorias para validar
	}
	
	public boolean delete (long id) {
		Optional<Conteudo> obj = repository.findById(id);
		if (!obj.isPresent()) {
			return false;
		}
		repository.deleteById(id);
		return true;
	}
	
	public Conteudo update(long id, Conteudo obj) {
		Optional<Conteudo> valid = repository.findById(id);
		if(!valid.isPresent()) {
			return null;
		}
		return repository.save(update(valid.get(), obj));
	}
	
	private Conteudo update(Conteudo entity, Conteudo obj) {
		entity.setTitulo(obj.getTitulo());
		entity.setDescricao(obj.getDescricao());
		entity.setDisciplina(obj.getDisciplina());
		entity.setNivelEnsino(obj.getNivelEnsino());
		entity.setUsuario(obj.getUsuario());
		return entity;
	}
}
