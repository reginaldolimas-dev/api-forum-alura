package br.com.forum.api_forum_alura.domain.usuarioPerfil;

import br.com.forum.api_forum_alura.domain.perfil.PerfilEntity;
import br.com.forum.api_forum_alura.domain.usuario.UsuarioEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuario_perfil")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class UsuarioPerfilEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UsuarioEntity usuario;

    @ManyToOne
    @JoinColumn(name = "perfil_id")
    private PerfilEntity perfil;

    public UsuarioPerfilEntity(UsuarioEntity usuario, PerfilEntity perfil) {
        this.usuario = usuario;
        this.perfil = perfil;
    }

}
