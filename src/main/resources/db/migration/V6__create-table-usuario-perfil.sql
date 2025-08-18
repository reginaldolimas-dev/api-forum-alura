CREATE TABLE usuario_perfil (
                                id bigint NOT NULL AUTO_INCREMENT,
                                usuario_id BIGINT NOT NULL,
                                perfil_id BIGINT NOT NULL,
                                PRIMARY KEY (id),
                                CONSTRAINT fk_usuario FOREIGN KEY (usuario_id) REFERENCES usuario(id),
                                CONSTRAINT fk_perfil FOREIGN KEY (perfil_id) REFERENCES perfil(id)
);