package br.com.forum.api_forum_alura.domain.dto;

import br.com.forum.api_forum_alura.domain.entity.TopicoEntity;

public record TopicoDetalhadoDTO(
        String titulo,
        String mensagem,
        String dataCriacao,
        String status,
        UsuarioDTO autor,
        CursoDTO curso) {

    public TopicoDetalhadoDTO(TopicoEntity entity) {
        this(
                entity.getTitulo(),
                entity.getMensagem(),
                entity.getDataCriacao().toString(),
                entity.getStatus(),
                new UsuarioDTO(entity.getAutor()),
                new CursoDTO(entity.getCurso())
        );
    }
}
