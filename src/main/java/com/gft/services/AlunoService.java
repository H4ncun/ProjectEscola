package com.gft.services;

import com.gft.entities.Aluno;
import com.gft.repositories.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    private AlunoRepository alunoRepository;


    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public void salvarAluno(Aluno aluno) {
        alunoRepository.save(aluno);
    }

    public Aluno buscarAluno(Long id) throws Exception {
        Optional<Aluno> aluno = alunoRepository.findById(id);
        if (aluno.isEmpty()) {
            throw new Exception("Aluno não encontrado");
        }
        return aluno.get();
    }

    public List<Aluno> buscarAlunosPorNome(String nome) throws Exception {

        List<Aluno> aluno = alunoRepository.findAllByName(nome);

        if (aluno.isEmpty()) {
            throw new Exception("Nenhum Aluno encontrado");
        }
        return aluno;
    }

    public List<Aluno> listarAlunos() {
        return alunoRepository.findAll();
    }

    public void deletarAluno(Long id) {
        alunoRepository.deleteById(id);
    }
}
