package br.com.forum.api_forum_alura.domain.repository;

import br.com.forum.api_forum_alura.domain.entity.TopicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<TopicoEntity, Long> {
    boolean existsByTituloAndMensagem(String titulo, String mensagem);
}
