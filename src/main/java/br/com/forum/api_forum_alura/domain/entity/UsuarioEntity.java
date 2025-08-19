package br.com.forum.api_forum_alura.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "usuario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class UsuarioEntity implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String login;

    private String email;

    private String senha;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<UsuarioPerfilEntity> usuarioPerfis = new ArrayList<>();

    public UsuarioEntity(Long id) {
        this.id = id;
    }

    public List<PerfilEntity> getPerfis() {
        return usuarioPerfis.stream()
                .map(UsuarioPerfilEntity::getPerfil)
                .toList();
    }

    public void adicionarPerfil(PerfilEntity perfil) {
        UsuarioPerfilEntity usuarioPerfil = new UsuarioPerfilEntity(this, perfil);
        this.usuarioPerfis.add(usuarioPerfil);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
