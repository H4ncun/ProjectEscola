package com.gft.dtos.AlunoDTO;

import com.gft.entities.Aluno;

public class AlunoMapper {

    public static Aluno fromDTO(AlunoRequest dto) {
        return new Aluno(dto.getId(), dto.getNome(), dto.getEmail(), dto.getCpf());
    }

    public static AlunoResponse fromEntity(Aluno aluno) {
        return new AlunoResponse(aluno.getNome(), aluno.getEmail(), aluno.getCpf());
    }
}
