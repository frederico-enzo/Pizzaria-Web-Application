INSERT INTO tb_Atributo (tamanho, descricao, preco) VALUES ('Pequeno', 'Tamanho pequeno', 10.99);
INSERT INTO tb_Atributo (tamanho, descricao, preco) VALUES ('Médio', 'Tamanho médio', 12.99);
INSERT INTO tb_Atributo (tamanho, descricao, preco) VALUES ('Grande', 'Tamanho grande', 15.99);
INSERT INTO tb_Atributo (tamanho, descricao, preco) VALUES ('Extra Grande', 'Tamanho extra grande', 18.99);
INSERT INTO tb_Atributo (tamanho, descricao, preco) VALUES ('Família', 'Tamanho família', 21.99);

INSERT INTO tb_Endereços (rua, bairro, numero) VALUES ('Rua das Flores', 'Centro', 123);
INSERT INTO tb_Endereços (rua, bairro, numero) VALUES ('Avenida Principal', 'Bairro Novo', 456);
INSERT INTO tb_Endereços (rua, bairro, numero) VALUES ('Rua das Palmeiras', 'Jardim América', 789);
INSERT INTO tb_Endereços (rua, bairro, numero) VALUES ('Travessa das Oliveiras', 'Vila Esperança', 1011);
INSERT INTO tb_Endereços (rua, bairro, numero) VALUES ('Rua dos Pinheiros', 'Loteamento São Pedro', 1314);

-- Inserção de Clientes
INSERT INTO tb_Clientes (nome, telefone, email, senha) VALUES ('João Silva', '1234567890', 'joao@example.com', 'senha123');
INSERT INTO tb_Clientes (nome, telefone, email, senha) VALUES ('Maria Santos', '9876543210', 'maria@example.com', 'senha456');
INSERT INTO tb_Clientes (nome, telefone, email, senha) VALUES ('Carlos Oliveira', '5555555555', 'carlos@example.com', 'senha789');
INSERT INTO tb_Clientes (nome, telefone, email, senha) VALUES ('Ana Pereira', '9999999999', 'ana@example.com', 'senhaabc');
INSERT INTO tb_Clientes (nome, telefone, email, senha) VALUES ('Pedro Alves', '7777777777', 'pedro@example.com', 'senhaxyz');

-- Inserção de Vínculos Cliente-Endereço
INSERT INTO tb_clientes_enderecos (cliente_id, enderecos_id) VALUES (1, 1);
INSERT INTO tb_clientes_enderecos (cliente_id, enderecos_id) VALUES (2, 2);
INSERT INTO tb_clientes_enderecos (cliente_id, enderecos_id) VALUES (3, 3);
INSERT INTO tb_clientes_enderecos (cliente_id, enderecos_id) VALUES (4, 4);
INSERT INTO tb_clientes_enderecos (cliente_id, enderecos_id) VALUES (5, 5);
-- Inserção de Ingredientes
INSERT INTO tb_Ingredientes (ingrediente) VALUES ('Queijo');
INSERT INTO tb_Ingredientes (ingrediente) VALUES ('Presunto');
INSERT INTO tb_Ingredientes (ingrediente) VALUES ('Tomate');
INSERT INTO tb_Ingredientes (ingrediente) VALUES ('Molho de Tomate');
INSERT INTO tb_Ingredientes (ingrediente) VALUES ('Azeitonas');

-- Inserção de Atributos
INSERT INTO tb_Atributo (tamanho, descricao, preco) VALUES ('Pequeno', 'Tamanho pequeno', 10.99);
INSERT INTO tb_Atributo (tamanho, descricao, preco) VALUES ('Médio', 'Tamanho médio', 12.99);
INSERT INTO tb_Atributo (tamanho, descricao, preco) VALUES ('Grande', 'Tamanho grande', 15.99);
INSERT INTO tb_Atributo (tamanho, descricao, preco) VALUES ('Extra Grande', 'Tamanho extra grande', 18.99);
INSERT INTO tb_Atributo (tamanho, descricao, preco) VALUES ('Família', 'Tamanho família', 21.99);

-- Inserção de Produtos
INSERT INTO tb_Produto (nome, categoria, disponivel, tempo_preparo, atributo_id) 
VALUES ('Pizza de Queijo', 'Pizza', true, 30, 1);

-- Associação de Ingredientes ao Produto 1
INSERT INTO produto_ingredientes (produto_id, ingrediente_id) VALUES (1, 1); -- Queijo
INSERT INTO produto_ingredientes (produto_id, ingrediente_id) VALUES (1, 5); -- Azeitonas

-- Inserção de Produtos
INSERT INTO tb_Produto (nome, categoria, disponivel, tempo_preparo, atributo_id) 
VALUES ('Pizza de Presunto', 'Pizza', true, 30, 2);

-- Associação de Ingredientes ao Produto 2
INSERT INTO produto_ingredientes (produto_id, ingrediente_id) VALUES (2, 2); -- Presunto
INSERT INTO produto_ingredientes (produto_id, ingrediente_id) VALUES (2, 3); -- Tomate
INSERT INTO produto_ingredientes (produto_id, ingrediente_id) VALUES (2, 4); -- Molho de Tomate

-- Inserção de Produtos
INSERT INTO tb_Produto (nome, categoria, disponivel, tempo_preparo, atributo_id) 
VALUES ('Pizza Vegetariana', 'Pizza', true, 35, 3);

-- Associação de Ingredientes ao Produto 3
INSERT INTO produto_ingredientes (produto_id, ingrediente_id) VALUES (3, 3); -- Tomate
INSERT INTO produto_ingredientes (produto_id, ingrediente_id) VALUES (3, 4); -- Molho de Tomate

-- Inserção de Produtos
INSERT INTO tb_Produto (nome, categoria, disponivel, tempo_preparo, atributo_id) 
VALUES ('Pizza Especial', 'Pizza', true, 40, 4);

-- Associação de Ingredientes ao Produto 4
INSERT INTO produto_ingredientes (produto_id, ingrediente_id) VALUES (4, 1); -- Queijo
INSERT INTO produto_ingredientes (produto_id, ingrediente_id) VALUES (4, 2); -- Presunto
INSERT INTO produto_ingredientes (produto_id, ingrediente_id) VALUES (4, 5); -- Azeitonas

-- Inserção de Produtos
INSERT INTO tb_Produto (nome, categoria, disponivel, tempo_preparo, atributo_id) 
VALUES ('Pizza Especial Vegana', 'Pizza', true, 45, 5);

-- Associação de Ingredientes ao Produto 5
INSERT INTO produto_ingredientes (produto_id, ingrediente_id) VALUES (5, 3); -- Tomate
INSERT INTO produto_ingredientes (produto_id, ingrediente_id) VALUES (5, 4); -- Molho de Tomate
