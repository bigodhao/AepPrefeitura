package com.aep.ProjetoConteudoProfessor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aep.ProjetoConteudoProfessor.entidades.NivelEnsino;

@Repository
public interface NivelEnsinoRepository extends JpaRepository<NivelEnsino, Long> {

}
