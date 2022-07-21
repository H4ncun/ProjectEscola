package com.gft.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gft.entities.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

        Page<Aluno> findAll(Pageable page);

        Page<Aluno> findAllByNome(Pageable page, String nome);
}
