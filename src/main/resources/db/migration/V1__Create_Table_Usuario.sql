create table usuario
(
    id                 BIGINT not null PRIMARY KEY AUTO_INCREMENT,
    nome               VARCHAR(100),
    cpf                BIGINT,
    data_de_nascimento DATE,
    email              VARCHAR(50),
    senha              VARCHAR(20),
    chave_pix          VARCHAR(60),
    saldo_usuario      FLOAT
);