package br.com.forum.api_forum_alura.controller;

import br.com.forum.api_forum_alura.domain.dto.TopicoCadastroDTO;
import br.com.forum.api_forum_alura.domain.entity.CursoEntity;
import br.com.forum.api_forum_alura.domain.entity.TopicoEntity;
import br.com.forum.api_forum_alura.domain.entity.UsuarioEntity;
import br.com.forum.api_forum_alura.domain.repository.TopicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    public TopicoEntity cadastrar(@RequestBody @Valid TopicoCadastroDTO dados) {

        UsuarioEntity autorEntidade = new UsuarioEntity(dados.autorId());
        CursoEntity cursoEntidade = new CursoEntity(dados.cursoId());

        TopicoEntity topico = new TopicoEntity(dados.titulo(), dados.mensagem(), autorEntidade, cursoEntidade);
        return topicoRepository.save(topico);
    }
}
