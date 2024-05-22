
/**
 * Author:  Pedro Gabriel
 * Created: 29 de out. de 2023
 */

CREATE DATABASE IF NOT EXISTS biositdb;

USE biositdb;

CREATE TABLE IF NOT EXISTS pacientes (
    nome VARCHAR(50) NOT NULL,
    cpf VARCHAR(11) PRIMARY KEY,
    endereco VARCHAR(100),
    dataNascimento VARCHAR(20),
    rg VARCHAR(20),
    telefone VARCHAR(20)
);

CREATE TABLE prontuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cpf CHAR(11) NOT NULL,
    titulo VARCHAR(20) NOT NULL,
    dataReg VARCHAR(20) NOT NULL,
    descricao VARCHAR(500) NOT NULL
);

CREATE TABLE IF NOT EXISTS consultas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nomePaciente VARCHAR(100),
    descricao VARCHAR(100),
    urgencia VARCHAR(100),
    medico VARCHAR(100),
    dataCon VARCHAR(10),
    horario VARCHAR(10)
);

CREATE TABLE IF NOT EXISTS Usuario (
    idUsuario INT AUTO_INCREMENT PRIMARY KEY,
    nomeUsuario VARCHAR(50),
    senhaUsuario VARCHAR(50),
    tipoUsuario VARCHAR(20)
);

CREATE TABLE Equipamento (
    nome VARCHAR(50),
    dia VARCHAR(10),
    quantidade INT,
    fornecedora VARCHAR(50),
    setor VARCHAR(50)
);

CREATE TABLE Medicamento (
    nome VARCHAR(50),
    validade VARCHAR(10),
    quantidade INT,
    fornecedora VARCHAR(50),
    lote VARCHAR(50)
);

CREATE TABLE Exame (
    exame VARCHAR(50),
    paciente VARCHAR(50),
    dataHora VARCHAR(10)
);


INSERT INTO Usuario (idUsuario, nomeUsuario, senhaUsuario, tipoUsuario)
VALUES
    (1, 'admin', '123', 'admin'),
    (2, 'medico', '123', 'medico'),
    (3, 'secretario','123','secretario'),
    (4, 'sec2','123','secretarioTriagem'),
    (5, 'enfermeiro','123','enfermeiro');6


CREATE TABLE profissional (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50),
    email VARCHAR(20),
    cpf VARCHAR(11),
    nascimento VARCHAR(20),
    registro VARCHAR(20),
    cargo VARCHAR(20),
    dataAdmissao VARCHAR(20),
    salario DOUBLE,
    especialidade VARCHAR(25),
    rg VARCHAR(20),
    instituicao VARCHAR(25),
    anoGrad VARCHAR(6),
    telefone VARCHAR(20),
    acess INT,
    UNIQUE(cpf)
);