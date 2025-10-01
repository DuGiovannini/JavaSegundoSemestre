CREATE TABLE moto (
    id_moto BIGINT AUTO_INCREMENT PRIMARY KEY,
    modelo VARCHAR(100) NOT NULL,
    placa VARCHAR(20) NOT NULL,
    patio_id BIGINT,
    CONSTRAINT fk_patio FOREIGN KEY (patio_id) REFERENCES patio(id_patio)
);
