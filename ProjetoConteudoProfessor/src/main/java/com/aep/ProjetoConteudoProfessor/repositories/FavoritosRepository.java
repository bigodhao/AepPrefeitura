package com.aep.ProjetoConteudoProfessor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aep.ProjetoConteudoProfessor.entidades.Favoritos;

@Repository
public interface FavoritosRepository extends JpaRepository<Favoritos, Long> {

}
