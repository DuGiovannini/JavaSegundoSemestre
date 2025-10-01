-- Tabela de roles
CREATE TABLE roles (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL UNIQUE
);

-- Tabela de usuarios
CREATE TABLE usuarios (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

-- Tabela de relacionamento N:N
CREATE TABLE usuarios_roles (
    usuario_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id),
    FOREIGN KEY (role_id) REFERENCES roles(id),
    PRIMARY KEY (usuario_id, role_id)
);

-- Inserindo perfis
INSERT INTO roles (nome) VALUES ('ROLE_ADMIN'), ('ROLE_USER');

-- Criando usuários iniciais (senha em texto plano por enquanto: "1234")
INSERT INTO usuarios (username, password) VALUES ('admin', '{noop}1234');
INSERT INTO usuarios (username, password) VALUES ('user', '{noop}1234');

-- Associando papéis
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (1, 1); -- admin -> ROLE_ADMIN
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (2, 2); -- user -> ROLE_USER
