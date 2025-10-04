package com.marcosviniciusdev.controller;

import com.marcosviniciusdev.model.dto.request.InstituicaoRequest;
import com.marcosviniciusdev.model.dto.response.InstituicaoResponse;
import com.marcosviniciusdev.service.InstituicaoService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/instituicoes")
@AllArgsConstructor
public class InstituicaoController {

    private final InstituicaoService instituicaoService;

    @PostMapping
    public ResponseEntity<InstituicaoResponse> criar(@RequestBody InstituicaoRequest dto) {
        InstituicaoResponse response = instituicaoService.criar(dto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InstituicaoResponse> buscarPorId(@PathVariable Long id) {
        InstituicaoResponse response = instituicaoService.buscarPorId(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Page<InstituicaoResponse>> buscaPaginada(@PageableDefault(size = 20)Pageable pageable) {
        Page<InstituicaoResponse> response = instituicaoService.buscaPaginada(pageable);
        return ResponseEntity.ok(response);
    }

}
