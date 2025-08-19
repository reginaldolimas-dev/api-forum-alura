package br.com.forum.api_forum_alura.domain.dto;

import br.com.forum.api_forum_alura.domain.entity.CursoEntity;

public record CursoDTO(Long id, String nome, String categoria) {
    public CursoDTO(CursoEntity curso) {
        this(curso.getId(), curso.getNome(), curso.getCategoria());
    }
}
