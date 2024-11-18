CREATE TABLE categoria (
	id SERIAL PRIMARY KEY,
	nome_categoria VARCHAR(50) NOT NULL
);

CREATE TABLE estoque (
	id SERIAL PRIMARY KEY,
	nome_produto VARCHAR(100) NOT NULL,
	id_categoria INT NOT NULL,
	marca VARCHAR(50),
	quantidade FLOAT NOT NULL,
	valor_un FLOAT NOT NULL,
	valor_estoque FLOAT,
	FOREIGN KEY (id_categoria) REFERENCES categoria(id)
);

CREATE TABLE fornecedores (
	id SERIAL PRIMARY KEY, 
	razao_social VARCHAR(100) NOT NULL,
	cnpj VARCHAR(20) NOT NULL,
	endereco VARCHAR(150),
	pais VARCHAR(50),
	telefone VARCHAR(15),
	email VARCHAR(100)
);

CREATE TABLE produtos (
	id SERIAL PRIMARY KEY,
	nome_produto VARCHAR(100) NOT NULL,
	id_categoria INT NOT NULL,
	marca VARCHAR(50),
	id_fornecedor INT,
	estoque_min FLOAT,
	estoque_max FLOAT,
	prazo_reabastecimento INT,
	FOREIGN KEY (id_categoria) REFERENCES categoria(id),
	FOREIGN KEY (id_fornecedor) REFERENCES fornecedores(id)
);

CREATE TABLE requisicao_compra (
	id SERIAL PRIMARY KEY,
	id_produto INT NOT NULL,
	quantidade FLOAT NOT NULL,
	valor_un FLOAT NOT NULL,
	valor_total FLOAT NOT NULL,
	status_liberacao VARCHAR(50),
	FOREIGN KEY (id_produto) REFERENCES produtos(id)
);

CREATE TABLE pedidos (
	id SERIAL PRIMARY KEY, 
	id_requisicao_compra INT,
	qtd_itens INT NOT NULL,
	valor_total FLOAT NOT NULL,
	data TIMESTAMP NOT NULL,
	id_fornecedor INT,
	FOREIGN KEY (id_requisicao_compra) REFERENCES requisicao_compra(id),
	FOREIGN KEY (id_fornecedor) REFERENCES fornecedores(id)
);

CREATE TABLE clientes (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(11) NOT NULL,
    idade INT,
    telefone VARCHAR(15),
    email VARCHAR(100)
);

CREATE TABLE vendas (
    id SERIAL PRIMARY KEY,
    nota_fiscal VARCHAR(50),
    id_cliente INT NOT NULL,
    nome VARCHAR(100) NOT NULL,
    qtd_itens INT,
    id_produto INT NOT NULL,
    valor_total FLOAT NOT NULL,
    data TIMESTAMP NOT NULL,
    FOREIGN KEY (id_cliente) REFERENCES clientes(id),
    FOREIGN KEY (id_produto) REFERENCES produtos(id)
);

CREATE TABLE vendas_produtos (
    id_venda INT NOT NULL,
    id_produto INT NOT NULL,
    quantidade INT NOT NULL,
    PRIMARY KEY (id_venda, id_produto),
    FOREIGN KEY (id_venda) REFERENCES vendas(id),
    FOREIGN KEY (id_produto) REFERENCES produtos(id)
);

CREATE TABLE status_requisicao (
    id SERIAL PRIMARY KEY,
    descricao VARCHAR(50) NOT NULL
);

CREATE TABLE status_pedido (
	id SERIAL PRIMARY KEY,
	descricao VARCHAR(50)
);

ALTER TABLE pedidos
ADD COLUMN id_status INT;

ALTER TABLE pedidos
ADD CONSTRAINT fk_status_requisicao
FOREIGN KEY (id_status) REFERENCES pedidos(id);

ALTER TABLE requisicao_compra
ADD COLUMN id_status INT;

ALTER TABLE requisicao_compra
DROP COLUMN status_liberacao;

ALTER TABLE requisicao_compra
ADD CONSTRAINT fk_status_requisicao
FOREIGN KEY (id_status) REFERENCES status_requisicao(id);

INSERT INTO status_pedido (descricao) VALUES ('PEDIDO_CRIADO'), ('ENVIADO_AO_FORNECEDOR'), ('PEDIDO_FATURADO'), ('PEDIDO_CONCLUIDO');

INSERT INTO status_requisicao (descricao) VALUES ('REQUISICAO_CRIADA'), ('AGUARDANDO_APROVACAO'), ('PEDIDO_CRIADO');