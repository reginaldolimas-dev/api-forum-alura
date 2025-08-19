package br.com.forum.api_forum_alura.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class TopicoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String mensagem;

    private LocalDateTime dataCriacao = LocalDateTime.now();

    private String status;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private CursoEntity curso;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private UsuarioEntity autor;

    public TopicoEntity(String titulo, String mensagem, UsuarioEntity autor, CursoEntity curso) {
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.autor = autor;
        this.curso = curso;
    }
}
