package br.com.forum.api_forum_alura.domain.usuario;

import br.com.forum.api_forum_alura.domain.perfil.PerfilEntity;
import br.com.forum.api_forum_alura.domain.usuarioPerfil.UsuarioPerfilEntity;
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

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<UsuarioPerfilEntity> usuarioPerfis = new ArrayList<>();

    public List<PerfilEntity> getPerfis() {
        return usuarioPerfis.stream()
                .map(UsuarioPerfilEntity::getPerfil)
                .toList();
    }

    public void adicionarPerfil(PerfilEntity perfil) {
        UsuarioPerfilEntity usuarioPerfil = new UsuarioPerfilEntity(this, perfil);
        this.usuarioPerfis.add(usuarioPerfil);
    }
}
