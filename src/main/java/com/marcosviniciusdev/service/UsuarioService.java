package com.marcosviniciusdev.service;

import com.marcosviniciusdev.model.Usuario;
import com.marcosviniciusdev.model.dto.request.UsuarioRequest;
import com.marcosviniciusdev.model.dto.response.UsuarioResponse;
import com.marcosviniciusdev.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioResponse salvar(UsuarioRequest dto) {
        Usuario usuario = dto.toEntity();

        usuario.setSenhaHash(passwordEncoder.encode(dto.senha()));

        Usuario salvo = usuarioRepository.save(usuario);

        return UsuarioResponse.fromEntity(salvo);
    }

    public UsuarioResponse buscarPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        return UsuarioResponse.fromEntity(usuario);
    }

    public Page<UsuarioResponse> listar(Pageable pageable) {
        return usuarioRepository.findAll(pageable).map(UsuarioResponse::fromEntity);
    }

    public UsuarioResponse atualizar(Long id, UsuarioRequest dto) {
        // 1. Busca o usuário que já existe no banco
        Usuario usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        // 2. ATUALIZA os campos do usuário existente com os dados do DTO
        //    (Não atualizamos CPF nem senha aqui por segurança e regra de negócio)
        usuarioExistente.setNome(dto.nome());
        usuarioExistente.setEmail(dto.email());
        usuarioExistente.setPerfil(dto.perfil());
        usuarioExistente.setTelefone(dto.telefone());
        usuarioExistente.setEndereco(dto.endereco());
        usuarioExistente.setTipoSanguineo(dto.tipoSanguineo());

        // 3. Salva o usuário com os dados atualizados
        Usuario atualizado = usuarioRepository.save(usuarioExistente);

        // 4. Retorna o DTO de resposta
        return UsuarioResponse.fromEntity(atualizado);
    }

    public void deletar(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        usuarioRepository.delete(usuario);
    }
}