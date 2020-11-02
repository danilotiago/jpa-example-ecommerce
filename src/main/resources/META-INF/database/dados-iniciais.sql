INSERT INTO produtos (id, nome, descricao, preco) VALUES (1, 'Kindle', 'Conheça o novo kindle', 499.90);
	
INSERT INTO produtos (id, nome, descricao, preco) VALUES (2, 'Bicicleta Caloi', 'Muito veloz', 799.90);

INSERT INTO clientes (id, nome) VALUES (1, 'Danilo Tiago');

INSERT INTO clientes (id, nome) VALUES (2, 'Thai Santos');

INSERT INTO pedidos (id, data_pedido, data_conclusao, nota_fical_id, total, cep, logradouro, numero, complemento, bairro, cidade, estado, status, cliente_id) VALUES (1, '2020-10-01 17:42:20', NULL, NULL, 2700.00, '08257-065', 'Rua Oito', '100', NULL, 'Imar', 'João Paulo', 'São Paulo', 'AGUARDANDO', 1);
	
INSERT INTO itens_pedidos (id, produto_id, preco_produto, quantidade, pedido_id) VALUES (1, 1, 799.00, 12, 1);