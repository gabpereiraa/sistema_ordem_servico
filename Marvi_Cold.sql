/**
* Cold
* @author Gabriel Anastacio
*/
create database dbcold;
use dbcold;
show tables;

create table usuarios ( 
	iduser int primary key auto_increment,
	nome varchar(30) not null,
	login varchar(20) not null unique, 
	senha varchar(250) not null,
    perfil varchar(5) not null
);

insert into usuarios(nome,login,senha,perfil) values ('Administrador','admin',md5('admin'),'admin');

create table clientes (
	idcli int primary key auto_increment,
	nome varchar(30) not null,
	cpf varchar(14) not null unique,
	endereco varchar(200) not null,
    numeroendereco varchar(5) not null,
    bairro varchar(50) not null,
	cidade varchar(50) not null,
    cep varchar(8) not null,
    uf varchar(2) not null,
    complemento varchar(50),
    telefone1 varchar(11) not null,
    telefone2 varchar(11),
    email varchar(100) not null
);

create table tecnicos ( 
	idtec int primary key auto_increment,
	nome varchar(30) not null,
	fone varchar (15) unique not null
);

create table fornecedores (
	idforn int primary key auto_increment,
	razao varchar(50) not null, 
	cnpj varchar(18) not null unique,
	endereco varchar(100) not null,
    numeroendereco varchar(5) not null,
    bairro varchar(50) not null,
	cidade varchar(50) not null,
    cep varchar(9) not null,
    uf varchar(2) not null,
    complemento varchar(50),
    telefone1 varchar(11) not null,
    telefone2 varchar(11) not null,
    email varchar(100) not null,
    site varchar(100)
);

create table servicos(
	os int primary key auto_increment,
    idcli int not null,
    defeito varchar(200),
    diagnostico varchar(200),
    statusOS varchar(40) not null,
    valor decimal(10,2),
    dataOS timestamp default current_timestamp,
    dataOSsaida date,
    marcaOS varchar(15) not null,
    modeloOS varchar(20) not null,
    serie varchar(50), /* Vira numero de serie */
    idtec int,
    usuario varchar (30) not null,
    nomecli varchar (50) not null,
    nometec varchar (50) not null,
    tiposervico varchar (30) not null,
    observacao varchar (100),
    codbarra1 varchar (13),
    produto1 varchar (70),
    quant1 varchar (3),
    codbarra2 varchar (13),
    produto2 varchar (70),
    quant2 varchar (3),
    codbarra3 varchar (13),
    produto3 varchar (70),
    quant3 varchar (3),
    codbarra4 varchar (13),
    produto4 varchar (70),
    quant4 varchar (3),
    codbarra5 varchar (13),
    produto5 varchar (70),
    quant5 varchar (3),
    codbarra6 varchar (13),
    produto6 varchar (70),
    quant6 varchar (3),
    totalpeca decimal(10,2),
    total decimal(10,2),
    tipoOS varchar(10),
	totalp01 decimal(10,2),
    totalp02 decimal(10,2),
    totalp03 decimal(10,2),
    totalp04 decimal(10,2),
    totalp05 decimal(10,2),
    totalp06 decimal(10,2),
    tipopagamento varchar(25),
	totalpago decimal(10,2),
    troco decimal(10,2),
    foreign key(idcli) references clientes(idcli),
    foreign key(idtec) references tecnicos(idtec)
);

create table estoques (
	idprodut int primary key auto_increment,
    idforn int,
    produto varchar(70) not null,
	codebarra varchar(13) not null unique,
	unimedida varchar(10),
    localarm varchar(50),
    estoque int not null,
    estoquemin int not null,
	descricao varchar(200),
    validade date not null,
    valor decimal(10,2) not null,
	dataEntrada timestamp default current_timestamp,
	foto longblob not null, /* Foto */
	valordig decimal(10,2) not null,
	lucro decimal(10,2) not null,
    foreign key(idforn) references fornecedores(idforn)
);
