CREATE TABLE apostas
(
    id             INT PRIMARY KEY AUTO_INCREMENT not null,
    id_usuario     BIGINT                         not null,
    id_partida     INT                            not null,
    tipo_de_aposta VARCHAR(20),
    valor_apostado FLOAT,
    FOREIGN KEY (id_usuario) REFERENCES `usuario` (id),
    FOREIGN KEY (id_partida) REFERENCES `partida` (id)
);