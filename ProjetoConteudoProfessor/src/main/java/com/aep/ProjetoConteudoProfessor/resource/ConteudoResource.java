package com.aep.ProjetoConteudoProfessor.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.aep.ProjetoConteudoProfessor.entidades.Conteudo;
import com.aep.ProjetoConteudoProfessor.service.ConteudoService;

@RestController
@RequestMapping(value = "/conteudos")
public class ConteudoResource {
	
	@Autowired
	private ConteudoService service;
	
	@GetMapping
	public ResponseEntity<List<Conteudo>> findAll(){
		List<Conteudo> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Conteudo> findById(@PathVariable long id){
		Conteudo obj = service.findById(id);
		if (obj!=null) {
			return ResponseEntity.ok().body(obj);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	public ResponseEntity<Conteudo> insert(@RequestBody Conteudo obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete (@PathVariable long id){
		if (service.delete(id)) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Conteudo> update (@PathVariable long id, @RequestBody Conteudo obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
