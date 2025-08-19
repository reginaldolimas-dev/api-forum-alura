package br.com.forum.api_forum_alura.controller;

import br.com.forum.api_forum_alura.domain.dto.TopicoCadastroDTO;
import br.com.forum.api_forum_alura.domain.entity.TopicoEntity;
import br.com.forum.api_forum_alura.domain.repository.TopicoRepository;
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
    public TopicoEntity cadastrar(@RequestBody TopicoCadastroDTO dados) {
        TopicoEntity topico = new TopicoEntity();
        return topicoRepository.save(topico);
    }
}
