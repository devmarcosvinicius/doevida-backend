package com.marcosviniciusdev.service;

import com.marcosviniciusdev.model.Agendamento;
import com.marcosviniciusdev.model.Instituicao;
import com.marcosviniciusdev.model.Usuario;
import com.marcosviniciusdev.model.dto.request.AgendamentoRequest;
import com.marcosviniciusdev.model.dto.response.AgendamentoResponse;
import com.marcosviniciusdev.repository.AgendamentoRepository;
import com.marcosviniciusdev.repository.InstituicaoRepository;
import com.marcosviniciusdev.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AgendamentoService {

    // Injetando todos os repositórios necessários
    private final AgendamentoRepository agendamentoRepository;
    private final UsuarioRepository usuarioRepository;
    private final InstituicaoRepository instituicaoRepository;

    public AgendamentoResponse salvar(AgendamentoRequest dto) {
        // Busca as entidades completas a partir dos IDs fornecidos no DTO
        Usuario usuario = usuarioRepository.findById(dto.idUsuario())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com o ID: " + dto.idUsuario()));

        Instituicao instituicao = instituicaoRepository.findById(dto.idInstituicao())
                .orElseThrow(() -> new RuntimeException("Instituição não encontrada com o ID: " + dto.idInstituicao()));

        // Cria a entidade Agendamento usando o método de conversão do DTO
        Agendamento agendamento = dto.toEntity(usuario, instituicao);

        // Salva a nova entidade no banco de dados
        Agendamento agendamentoSalvo = agendamentoRepository.save(agendamento);

        // Retorna o DTO de resposta
        return AgendamentoResponse.fromEntity(agendamentoSalvo);
    }

    public AgendamentoResponse buscarPorId(Long id) {
        Agendamento agendamento = agendamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agendamento não encontrado com o ID: " + id));
        return AgendamentoResponse.fromEntity(agendamento);
    }

    public Page<AgendamentoResponse> listar(Pageable pageable) {
        return agendamentoRepository.findAll(pageable).map(AgendamentoResponse::fromEntity);
    }

    public AgendamentoResponse atualizar(Long id, AgendamentoRequest dto) {
        // Busca o agendamento existente no banco
        Agendamento agendamentoExistente = agendamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agendamento não encontrado com o ID: " + id));

        // Busca as entidades de usuário e instituição (caso tenham sido alteradas)
        Usuario usuario = usuarioRepository.findById(dto.idUsuario())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com o ID: " + dto.idUsuario()));

        Instituicao instituicao = instituicaoRepository.findById(dto.idInstituicao())
                .orElseThrow(() -> new RuntimeException("Instituição não encontrada com o ID: " + dto.idInstituicao()));

        // Atualiza os campos do agendamento existente
        agendamentoExistente.setUsuario(usuario);
        agendamentoExistente.setInstituicao(instituicao);
        agendamentoExistente.setDataHora(dto.dataHora());
        agendamentoExistente.setTipoDoacao(dto.tipoDoacao());
        // O status não é atualizado aqui, pois pode ter uma lógica de negócio específica (ex: um método para "confirmar" ou "cancelar")

        Agendamento agendamentoAtualizado = agendamentoRepository.save(agendamentoExistente);

        return AgendamentoResponse.fromEntity(agendamentoAtualizado);
    }

    public void deletar(Long id) {
        Agendamento agendamento = agendamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agendamento não encontrado com o ID: " + id));

        agendamentoRepository.delete(agendamento);
    }
}