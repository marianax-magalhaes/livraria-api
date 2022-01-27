package com.livrariaapi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Data
@EqualsAndHashCode(of="id")
@NoArgsConstructor @AllArgsConstructor
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_user;

    @NotEmpty(message="Campo NOME é obrigatório")
    @Length(min=3,max=50, message="Campo NOME deve ter entre 3 e 50 caracteres")
    private String nome;

    @NotEmpty(message="Campo EMAIL é obrigatório")
    @Length(min=3,max=50, message="Campo EMAIL deve ter entre 3 e 50 caracteres")
    private String email;

    @NotEmpty(message="Campo SENHA é obrigatório")
    @Length(min=3,max=50, message="Campo SENHA deve ter entre 6 e 50 caracteres")
    private String senha;
}
