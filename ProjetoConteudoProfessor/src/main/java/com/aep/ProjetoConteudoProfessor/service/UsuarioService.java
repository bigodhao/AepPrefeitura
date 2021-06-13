package com.aep.ProjetoConteudoProfessor.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aep.ProjetoConteudoProfessor.entidades.Usuario;
import com.aep.ProjetoConteudoProfessor.repositories.UsuarioRepository;


@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	public List<Usuario> findAll(){
		return repository.findAll();
	}
	
	public Usuario findById(long id) {
		Optional<Usuario> obj = repository.findById(id);
		return obj.orElse(null);
	}
	
	public Usuario insert (Usuario obj) {
		return repository.save(obj); // realizar melhorias para validar
	}
	
	public boolean delete (long id) {
		Optional<Usuario> obj = repository.findById(id);
		if (!obj.isPresent()) {
			return false;
		}
		repository.deleteById(id);
		return true;
	}
	
	public Usuario update(long id, Usuario obj) {
		Optional<Usuario> valid = repository.findById(id);
		if(!valid.isPresent()) {
			return null;
		}
		return repository.save(update(valid.get(), obj));
	}
	
	private Usuario update(Usuario entity, Usuario obj) {
		entity.setNome(obj.getNome());
		entity.setSobrenome(obj.getSobrenome());
		entity.setCpf(obj.getCpf());
		entity.setDataNascimento(obj.getDataNascimento());
		entity.setDadosProfissional(obj.getDadosProfissional());
		entity.setEmail(obj.getEmail());
		entity.setSenha(obj.getSenha());
		entity.setGenero(obj.getGenero());
		entity.setFavoritos(obj.getFavoritos());
		return entity;
	}
}
