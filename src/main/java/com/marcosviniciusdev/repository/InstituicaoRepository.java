package com.marcosviniciusdev.repository;

import com.marcosviniciusdev.model.Instituicao;
import com.marcosviniciusdev.model.dto.request.InstituicaoRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InstituicaoRepository extends JpaRepository<Instituicao, Long> {

    Optional<InstituicaoRequest> findByNome(String nome);

}
