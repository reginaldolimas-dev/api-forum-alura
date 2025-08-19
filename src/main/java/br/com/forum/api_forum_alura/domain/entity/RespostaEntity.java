package br.com.forum.api_forum_alura.domain.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "resposta")
public class RespostaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mensagem;

    @ManyToOne
    @JoinColumn(name = "resposta_id")
    private TopicoEntity topico;
}
