CREATE TABLE treinamento (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    descricao TEXT,
    data DATE,
    instrutor VARCHAR(255),
    area VARCHAR(255),
    icone VARCHAR(255)  -- Caminho para o ícone
);


INSERT INTO treinamento (nome, descricao, data, instrutor, area, icone) VALUES
('Curso de Farmácia Industrial', 'Treinamento especializado em práticas da indústria farmacêutica.', '2024-10-10', 'Dr. Ana Souza', 'Farmacêutica', '/css/images/farmacia-icon.png'),
('Curso de Gestão de Performance com Indicadores KPIs', 'Como gerir e monitorar indicadores de performance na indústria.', '2024-11-15', 'Carlos Silva', 'Gestão', '/css/images/kpi-icon.png'),
('Curso de ITIL Foundation', 'Curso sobre as melhores práticas em gerenciamento de TI.', '2024-12-05', 'Maria Fernandes', 'Tecnologia', '/css/images/itil-icon.png');
