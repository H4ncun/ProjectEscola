package com.gft.controllers;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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

import com.gft.dtos.AlunoDTO.AlunoMapper;
import com.gft.dtos.AlunoDTO.AlunoRequest;
import com.gft.dtos.AlunoDTO.AlunoResponse;
import com.gft.entities.Aluno;
import com.gft.services.AlunoService;

import net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.Resolution;

@RestController
@RequestMapping("v1/aluno")

public class AlunoController {

    private AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @PostMapping
    public ResponseEntity<AlunoResponse> salvarAluno(@RequestBody @Valid AlunoRequest dto) {

        Aluno aluno = alunoService.salvarAluno(AlunoMapper.fromDTO(dto));

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(aluno.getId()).toUri();

        return ResponseEntity.created(uri).body(AlunoMapper.fromEntity(aluno));
    }

    @GetMapping("{id}")
    public ResponseEntity<AlunoResponse> buscarAluno(@PathVariable Long id) throws Exception {

        Aluno aluno = alunoService.buscarAluno(id);

        return ResponseEntity.ok(AlunoMapper.fromEntity(aluno));
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<Page<AlunoResponse>> buscarAlunosPorNome(@PageableDefault(sort = "nome") Pageable page,
            String nome) throws Exception {

        return ResponseEntity.ok(alunoService.buscarAlunosPorNome(page, nome).map(AlunoMapper::fromEntity));
    }

    @GetMapping
    public ResponseEntity<Page<AlunoResponse>> listarAlunos(@PageableDefault(sort = "id") Pageable page) {

        return ResponseEntity.ok(alunoService.listarAlunos(page).map(AlunoMapper::fromEntity));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<AlunoResponse> deletarAluno(@PathVariable Long id) throws Exception {

        alunoService.deletarAluno(id);

        return ResponseEntity.ok().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<AlunoResponse> atualizarAluno(@RequestBody AlunoRequest dto, @PathVariable Long id) {

        Aluno aluno;
        try {
            aluno = alunoService.atualizarAluno(AlunoMapper.fromDTO(dto), id);
            return ResponseEntity.ok(AlunoMapper.fromEntity(aluno));
        } catch (Exception e) {

            return ResponseEntity.notFound().build();
        }

    }
}
