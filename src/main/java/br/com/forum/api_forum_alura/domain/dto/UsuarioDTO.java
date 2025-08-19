package br.com.forum.api_forum_alura.domain.dto;

import br.com.forum.api_forum_alura.domain.entity.UsuarioEntity;

public record UsuarioDTO(Long id, String nome) {
    public UsuarioDTO(UsuarioEntity autor) {
        this(autor.getId(), autor.getNome());
    }
}
