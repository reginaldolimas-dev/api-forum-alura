CREATE TABLE usuario (
    id bigint NOT NULL AUTO_INCREMENT,
    nome varchar(100) DEFAULT NULL,
    email varchar(200) DEFAULT NULL,
    senha varchar(100) DEFAULT NULL,
    perfis varchar(100) DEFAULT NULL,
    PRIMARY KEY (`id`)
)