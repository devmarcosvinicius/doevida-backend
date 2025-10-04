package com.marcosviniciusdev.service;

import com.marcosviniciusdev.model.Instituicao;
import com.marcosviniciusdev.model.dto.request.InstituicaoRequest;
import com.marcosviniciusdev.model.dto.response.InstituicaoResponse;
import com.marcosviniciusdev.repository.InstituicaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InstituicaoService {

    private final InstituicaoRepository instituicaoRepository;

    public InstituicaoResponse criar(InstituicaoRequest dto) {
        Instituicao instituicao = dto.toEntity();
        return InstituicaoResponse.fromEntity(instituicaoRepository.save(instituicao));
    }

    public InstituicaoResponse buscarPorId(Long id) {
        Instituicao instituicao = instituicaoRepository.findById(id).orElseThrow(() -> new RuntimeException("Instituição não encontrada"));
        return InstituicaoResponse.fromEntity(instituicao);
    }

    public Page<InstituicaoResponse> buscaPaginada(Pageable pageable) {
        return instituicaoRepository.findAll(pageable).map(InstituicaoResponse::fromEntity);
    }
}
