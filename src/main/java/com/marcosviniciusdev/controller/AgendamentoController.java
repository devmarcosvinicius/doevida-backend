package com.marcosviniciusdev.controller;

import com.marcosviniciusdev.model.dto.request.AgendamentoRequest;
import com.marcosviniciusdev.model.dto.response.AgendamentoResponse;
import com.marcosviniciusdev.service.AgendamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/agendamentos") // Rota base para os endpoints de agendamento
@RequiredArgsConstructor
public class AgendamentoController {

    private final AgendamentoService agendamentoService;

    @PostMapping
    public ResponseEntity<AgendamentoResponse> agendar(@RequestBody AgendamentoRequest dto) {
        AgendamentoResponse response = agendamentoService.salvar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgendamentoResponse> buscarPorId(@PathVariable Long id) {
        AgendamentoResponse response = agendamentoService.buscarPorId(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Page<AgendamentoResponse>> buscaPaginada(@PageableDefault(size = 10) Pageable pageable) {
        return ResponseEntity.ok(agendamentoService.listar(pageable));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AgendamentoResponse> atualizar(@PathVariable Long id, @RequestBody AgendamentoRequest dto) {
        AgendamentoResponse response = agendamentoService.atualizar(id, dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelar(@PathVariable Long id) {
        agendamentoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}