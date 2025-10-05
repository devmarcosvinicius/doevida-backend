package com.marcosviniciusdev.repository;

import com.marcosviniciusdev.model.Instituicao;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

// A anotação @Repository é opcional aqui, mas é uma boa prática
public interface InstituicaoRepository extends JpaRepository<Instituicao, Long> {

    // CORRIGIDO: O método deve retornar a Entidade, não o DTO
    Optional<Instituicao> findByNome(String nome);

}