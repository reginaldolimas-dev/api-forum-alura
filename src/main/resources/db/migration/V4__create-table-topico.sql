CREATE TABLE topico (
                        id BIGINT NOT NULL AUTO_INCREMENT,
                        titulo VARCHAR(100),
                        mensagem TEXT,
                        data_criacao DATETIME NOT NULL,
                        status VARCHAR(20),
                        autor_id BIGINT NOT NULL,
                        curso_id BIGINT,
                        PRIMARY KEY (id),
                        KEY fk_curso (curso_id),
                        CONSTRAINT fk_curso FOREIGN KEY (curso_id) REFERENCES curso (id),
                        CONSTRAINT fk_autor_id FOREIGN KEY (autor_id) REFERENCES usuario(id)
);
