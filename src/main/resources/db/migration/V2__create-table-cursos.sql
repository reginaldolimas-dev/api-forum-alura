CREATE TABLE curso (
    id bigint NOT NULL AUTO_INCREMENT,
    nome varchar(100) NOT NULL,
    categoria varchar(100) DEFAULT NULL,
    PRIMARY KEY (`id`)
)