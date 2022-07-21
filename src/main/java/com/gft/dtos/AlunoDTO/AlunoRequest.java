package com.gft.dtos.AlunoDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlunoRequest {

    private String nome;
    private String email;
    private String cpf;

}
