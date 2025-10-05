package com.marcosviniciusdev.repository;

import com.marcosviniciusdev.model.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
    // Aqui podemos adicionar métodos de busca customizados no futuro, se necessário.
    // Ex: List<Agendamento> findByUsuario(Usuario usuario);
}