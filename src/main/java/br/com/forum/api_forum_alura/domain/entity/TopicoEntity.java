package br.com.forum.api_forum_alura.domain.entity;

import br.com.forum.api_forum_alura.domain.dto.TopicoCadastroDTO;
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

    @ManyToOne(optional = false)
    @JoinColumn(name = "curso_id")
    private CursoEntity curso;

    @ManyToOne(optional = false)
    @JoinColumn(name = "autor_id")
    private UsuarioEntity autor;

    public TopicoEntity(String titulo, String mensagem, UsuarioEntity autor, CursoEntity curso) {
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.autor = autor;
        this.curso = curso;
    }

    public void atualizarInformacoes(TopicoCadastroDTO dados) {
        if (dados.titulo() != null) {
            this.titulo = dados.titulo();
        }
        if (dados.mensagem() != null) {
            this.mensagem = dados.mensagem();
        }
        if (dados.autorId() != null) {
            this.autor = new UsuarioEntity(dados.autorId());
        }

        if (dados.cursoId() != null) {
            this.curso = new CursoEntity(dados.cursoId());
        }

    }
}
