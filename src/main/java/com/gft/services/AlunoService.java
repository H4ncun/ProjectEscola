package com.gft.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gft.entities.Aluno;
import com.gft.repositories.AlunoRepository;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public Aluno salvarAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public Aluno buscarAluno(Long id) throws Exception {
        Optional<Aluno> aluno = alunoRepository.findById(id);
        if (aluno.isEmpty()) {
            throw new Exception("Aluno não encontrado");
        }
        return aluno.get();
    }

    public Page<Aluno> buscarAlunosPorNome(Pageable page, String nome) throws Exception {
        Page<Aluno> alunos = alunoRepository.findAllByNome(page, nome);

        if (alunos.isEmpty()) {
            throw new Exception("Nenhum Aluno encontrado");
        }
        return alunos;
    }

    public Page<Aluno> listarAlunos(Pageable page) {
        return alunoRepository.findAll(page);
    }

    public void deletarAluno(Long id) throws Exception {
        Aluno aluno = this.buscarAluno(id);

        alunoRepository.delete(aluno);
    }

    public Aluno atualizarAluno(Aluno aluno, Long id) throws Exception {

        Aluno alunoAntigo = this.buscarAluno(id);

        aluno.setId(alunoAntigo.getId());

        return alunoRepository.save(aluno);
    }
}
