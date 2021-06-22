package com.backend_estudantes.repository;

import com.backend_estudantes.entities.Estudante;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudanteRepository extends JpaRepository<Estudante, Long> {

}
 