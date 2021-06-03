package com.aep.ProjetoConteudoProfessor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aep.ProjetoConteudoProfessor.entidades.DadosProfissional;

@Repository
public interface DadosProfissionalRepository extends JpaRepository<DadosProfissional, Long> {

}
