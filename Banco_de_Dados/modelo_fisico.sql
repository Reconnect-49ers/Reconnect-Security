CREATE DATABASE Reconnect;

USE Reconnect;

-- Não é necessário executar o código abaixo --

CREATE DATABASE Reconnect;

USE Reconnect;

-- Não é necessário executar o código abaixo --

CREATE TABLE `usuario` (
  `data_nascimento` date NOT NULL,
  `id` bigint NOT NULL AUTO_INCREMENT,
  `bio` varchar(255) DEFAULT NULL,
  `cpf` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `endereco` varchar(255) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `profissao` varchar(255) NOT NULL,
  `senha` varchar(255) NOT NULL,
  `telefone` varchar(255) NOT NULL,
  `capa` longblob,
  `imagem` longblob,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_5171l57faosmj8myawaucatdw` (`email`),
  UNIQUE KEY `UK_692bsnqxa8m9fmx7m1yc6hsui` (`cpf`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `servico` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `usuario_id` bigint NOT NULL,
  `descricao` varchar(255) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `imagem` longblob,
  PRIMARY KEY (`id`),
  KEY `FK3uw8e0wahiecte74b5qj8exmn` (`usuario_id`),
  CONSTRAINT `FK3uw8e0wahiecte74b5qj8exmn` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `contrato` (
  `concluido` tinyint(1) DEFAULT '0',
  `data_hora` datetime(6) NOT NULL,
  `id` bigint NOT NULL AUTO_INCREMENT,
  `servico_id` bigint NOT NULL,
  `usuario_id` bigint NOT NULL,
  `endereco` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKs6gns4t2srirg88k9u9mqmbwk` (`servico_id`),
  KEY `FKjk83wy5pq0a7hufodligiop2k` (`usuario_id`),
  CONSTRAINT `FKjk83wy5pq0a7hufodligiop2k` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`),
  CONSTRAINT `FKs6gns4t2srirg88k9u9mqmbwk` FOREIGN KEY (`servico_id`) REFERENCES `servico` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `contato` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `servico_id` bigint NOT NULL,
  `email` varchar(255) NOT NULL,
  `mensagem` varchar(255) DEFAULT NULL,
  `nome` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKoik6ny143egs93hxxqqp9tew` (`servico_id`),
  CONSTRAINT `FKoik6ny143egs93hxxqqp9tew` FOREIGN KEY (`servico_id`) REFERENCES `servico` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `fale_conosco` (
  `status` bit(1) DEFAULT NULL,
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `mensagem` varchar(255) NOT NULL,
  `nome` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;