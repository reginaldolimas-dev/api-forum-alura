package br.com.forum.api_forum_alura.controller;

import br.com.forum.api_forum_alura.domain.dto.TopicoCadastroDTO;
import br.com.forum.api_forum_alura.domain.dto.TopicoDetalhadoDTO;
import br.com.forum.api_forum_alura.domain.entity.CursoEntity;
import br.com.forum.api_forum_alura.domain.entity.TopicoEntity;
import br.com.forum.api_forum_alura.domain.entity.UsuarioEntity;
import br.com.forum.api_forum_alura.domain.repository.TopicoRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topicos")
@SecurityRequirement(name = "bearer-key")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastrar(@RequestBody @Valid TopicoCadastroDTO dados) {

        var topicoExiste = topicoRepository.existsByTituloAndMensagem(dados.titulo(), dados.mensagem());

        if (topicoExiste) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body("Tópico já cadastrado com o mesmo título e mensagem.");
        }

        UsuarioEntity autorEntidade = new UsuarioEntity(dados.autorId());
        CursoEntity cursoEntidade = new CursoEntity(dados.cursoId());

        TopicoEntity topico = new TopicoEntity(dados.titulo(), dados.mensagem(), autorEntidade, cursoEntidade);
        TopicoEntity topicoSalvo = topicoRepository.save(topico);
        return ResponseEntity.status(HttpStatus.CREATED).body(topicoSalvo);
    }

    @GetMapping
    public ResponseEntity<?> listar(@PageableDefault(size = 10, sort = "dataCriacao", direction = Sort.Direction.ASC) Pageable pageable) {

        Page<TopicoEntity> topicosEntidade = topicoRepository.findAll(pageable);

        Page<TopicoDetalhadoDTO> modelos = topicosEntidade.map(TopicoDetalhadoDTO::new);

        return ResponseEntity.ok(modelos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        var topico = topicoRepository.findById(id);
        if (topico.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new TopicoDetalhadoDTO(topico.get()));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody @Valid TopicoCadastroDTO dados) {
        var topico = topicoRepository.findById(id);

        if (topico.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        topico.get().atualizarInformacoes(dados);

        return ResponseEntity.ok(new TopicoDetalhadoDTO(topico.get()));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        var topico = topicoRepository.findById(id);
        if (topico.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        topicoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
