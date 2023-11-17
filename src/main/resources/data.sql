INSERT INTO usuario (nome, email, senha, imagem, capa, telefone, profissao, cpf, endereco, data_nascimento, bio) 
VALUES ('Irineu Júnior','irineu@com', '123', 'src/main/resources/static/images/perfis/perfil00.jpg', 'images/perfis/capa02.jpg', '(85)9 71512-5252', 'Motorista Particular', '123.456.789-12', 'Rua Sob Nova Direção, n.154, Vice City', '1990-08-10', 'Faço transporte particular para eventos, viagens e empresas.');
INSERT INTO usuario (nome, email, senha, imagem, capa, telefone, profissao, cpf, endereco, data_nascimento, bio) 
VALUES ('Tony Stark','tony@com', '123', '|/images/perfis/perfil00.jpg|', 'images/perfis/capa02.jpg', '(85)9 71512-5252', 'Mecânico', '123.456.789-13', 'Rua do Motor, n.10, San Andreas', '1983-08-20', 'Sou profissional de motos, mais de 20 anos de experiência.');
INSERT INTO usuario (nome, email, senha, imagem, capa, telefone, profissao, cpf, endereco, data_nascimento, bio) 
VALUES ('Pietra Maria','pietra@com', '123', LOAD_FILE('src/main/resources/static/images/perfis/perfil00.jpg'), LOAD_FILE('classpath:images/perfis/perfil10.jpg'), '(85)9 71512-5252', 'Diarista', '123.456.789-14', 'Rua da Limpeza, n.11, Vice City', '1995-02-15', 'Limpo de tudo. Agenda livre para fins de semana!');


INSERT INTO contrato (nome, email, endereco, data_hora, concluido, usuario_id)
VALUES ('Steve Rogers','capamerica@com', 'Rua 100 nome', '2023-11-16 15:30:00', false, 1);