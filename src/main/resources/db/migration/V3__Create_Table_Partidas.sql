CREATE TABLE partida
(
    id                INT not null AUTO_INCREMENT PRIMARY KEY,
    id_time_casa      INT not null,
    id_time_visitante INT not null,
    resultado         VARCHAR(20),
    data_hora_partida DATETIME,
    FOREIGN KEY (id_time_casa) REFERENCES `time` (id),
    FOREIGN KEY (id_time_visitante) REFERENCES `time` (id)
);