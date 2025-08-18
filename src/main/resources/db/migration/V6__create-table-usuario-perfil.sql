CREATE TABLE usuario_perfil (
                                usuario_id BIGINT NOT NULL,
                                perfil_id BIGINT NOT NULL,
                                PRIMARY KEY (usuario_id, perfil_id),
                                CONSTRAINT fk_usuario FOREIGN KEY (usuario_id) REFERENCES usuario(id),
                                CONSTRAINT fk_perfil FOREIGN KEY (perfil_id) REFERENCES perfil(id)
);