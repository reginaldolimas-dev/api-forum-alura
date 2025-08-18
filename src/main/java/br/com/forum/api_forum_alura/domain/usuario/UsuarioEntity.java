package br.com.forum.api_forum_alura.domain.usuario;

import br.com.forum.api_forum_alura.domain.perfil.PerfilEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usuario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private String senha;

    @ManyToMany(fetch = FetchType.EAGER)
    List<PerfilEntity> perfis = new ArrayList<>();
}
