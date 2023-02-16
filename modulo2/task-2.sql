-- CRIANDO TABELA PAIS
CREATE TABLE VEM_SER.PAIS(
	id_pais INT PRIMARY KEY NOT NULL,
	nome VARCHAR(200) NOT NULL
);

-- CRIANDO TABELA ESTADO
CREATE TABLE VEM_SER.ESTADO(
    id_estado INT PRIMARY KEY NOT NULL,
    id_pais INT NOT NULL,
    nome VARCHAR2(50) UNIQUE NOT NULL,
    CONSTRAINT FK_PAIS FOREIGN KEY ( id_pais ) REFERENCES PAIS( id_pais )
);

-- CRIANDO TABELA CIDADE
CREATE TABLE VEM_SER.CIDADE(
	id_cidade INT NOT NULL,
	id_estado INT NOT NULL,
	nome VARCHAR2(50) UNIQUE NOT NULL,
	PRIMARY KEY (id_cidade, id_estado),
	CONSTRAINT FK_ESTADO FOREIGN KEY ( id_estado ) REFERENCES ESTADO ( id_estado )
);

-- CRIANDO TABELA BAIRRO
CREATE TABLE VEM_SER.BAIRRO(
	id_bairro INT NOT NULL,
	id_cidade INT NOT NULL,
	id_estado INT NOT NULL,
	nome VARCHAR(50) UNIQUE NOT NULL,
	PRIMARY KEY (id_bairro, id_cidade),
	CONSTRAINT FK_BAIRRO_CIDADE FOREIGN KEY ( id_cidade, id_estado ) REFERENCES CIDADE ( id_cidade, id_estado )
);

-- CRIANDO TABLE ENDERECO
CREATE TABLE VEM_SER.ENDERECO(
	id_endereco INT PRIMARY KEY NOT NULL,
	id_bairro INT NOT NULL,
	id_cidade INT NOT NULL,
	logradourdo VARCHAR(255) NOT NULL,
	numero INT NOT NULL,
	complemento VARCHAR(100),
	cep CHAR(9) NOT NULL,
	CONSTRAINT FK_ENDERECO_BAIRRO FOREIGN KEY ( id_bairro, id_cidade ) REFERENCES BAIRRO ( id_bairro, id_cidade )
);

-- INSERINDO DADOS NAS TABELAS
/*
INSERT INTO VEM_SER.PAIS (ID_PAIS, NOME)
VALUES(SEQ_PAIS.NEXTVAL, 'ARGENTINA');
*/

/*
INSERT INTO VEM_SER.ESTADO (ID_ESTADO, ID_PAIS, NOME)
VALUES(SEQ_ESTADO.NEXTVAL, 2, 'ARIZONA');
*/

/*
INSERT INTO VEM_SER.CIDADE (ID_CIDADE, ID_ESTADO, NOME)
VALUES(SEQ_CIDADE.NEXTVAL, 4, 'TUCSON');
*/

/*
INSERT INTO VEM_SER.BAIRRO (ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME)
VALUES(SEQ_BAIRRO.NEXTVAL, 8, 4, 'JOESLER VILLAGE');
*/

/*
INSERT INTO VEM_SER.ENDERECO
(ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES(SEQ_ENDERECO.NEXTVAL, 19, 8, 'AV. ESTRADA DA POSSE', 15, 'FUNK DAS ANTIGAS', '08259-101');
*/

SELECT * FROM VEM_SER.ENDERECO e ORDER BY e.ID_BAIRRO , e.ID_CIDADE; 

---------------- Exercio TASK02 ---------------
-- selecionar todos os paises por ordem decrescente
SELECT * FROM VEM_SER.PAIS p ORDER BY p.ID_PAIS DESC;
--------------------------------------------
-- selecionar logradouro e cep dos endereços porém somente os logradouros que comecem com a letra 'a' minusculo ou maiusculo
SELECT LOGRADOURO, CEP FROM VEM_SER.ENDERECO e WHERE e.LOGRADOURO LIKE UPPER ('a%');
--ALTER TABLE VEM_SER.ENDERECO RENAME COLUMN LOGRADOURDO TO LOGRADOURO;
--------------------------------------------
-- selecionar todos os endereços que tenham 0 no final do CEP
SELECT * FROM VEM_SER.ENDERECO e WHERE e.CEP LIKE '%0';
--------------------------------------------
-- selecionar todos os endereços que tenham numeros entre 1 e 100 (coloquei entre 1 e 200 pois nao tenho menores que 100).
SELECT * FROM VEM_SER.ENDERECO e WHERE e.NUMERO BETWEEN '1' AND '200'; -- vai aparecer somente 1 endereco
--------------------------------------------
-- selecionar todos os endereços que comecem por RUA e ordernar pelo CEP de forma DESC
SELECT * FROM VEM_SER.ENDERECO e WHERE e.LOGRADOURO LIKE UPPER('rua%') ORDER BY e.CEP DESC;
--------------------------------------------
-- selecionar a quantidade de enderecos cadastrados na tabela
SELECT COUNT (*) FROM VEM_SER.ENDERECO e;
--------------------------------------------
-- selecionar a quantidade de enderecos cadastrados agrupados pelo ID_CIDADE
SELECT COUNT (*) FROM VEM_SER.ENDERECO e GROUP BY e.ID_CIDADE;
--------------------------------------------
-----------------------------------------------------------------------------
----------- DELETE 2 PAISES QUE CRIEI PARA EXECUTAR ALGUNS TESTES -----------
--DELETE FROM VEM_SER.PAIS p WHERE p.ID_PAIS = 4;
-----------------------------------------------------------------------------
-- CRIANDO SEQUENCES
/* 
CREATE SEQUENCE VEM_SER.SEQ_ENDERECO
	START WITH 1
	INCREMENT BY 1
	NOCACHE NOCYCLE;
*/
-----------------------------------------------------------------------------
-- DROP TABLE VEM_SER.PAIS  
-- DROP SEQUENCE VEM_SER.SEQ_PAIS
-----------------------------------------------------------------------------