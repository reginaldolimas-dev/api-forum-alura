CREATE TABLE resposta (
    id bigint NOT NULL AUTO_INCREMENT,
    mensagem text,
    topico_id bigint DEFAULT NULL,
    dataCriacao datetime NOT NULL,
    autor varchar(100) DEFAULT NULL,
    solucao tinyint(1) DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY fk_topico (topico_id),
    CONSTRAINT fk_topico FOREIGN KEY (topico_id) REFERENCES topico (id)
)