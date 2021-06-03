package com.aep.ProjetoConteudoProfessor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aep.ProjetoConteudoProfessor.entidades.Conteudo;

@Repository
public interface ConteudoRepository extends JpaRepository<Conteudo, Long> {

}
