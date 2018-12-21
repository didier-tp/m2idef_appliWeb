create database if not exists baseProd;
use baseProd;

drop table if exists produit;
drop table if exists categorie;
drop table if exists blague;

create table categorie(
id integer primary key auto_increment,
label VARCHAR(64)
);

describe categorie;

create table produit(
numero integer primary key auto_increment,
label VARCHAR(64),
prix double,
ref_categorie integer ,
foreign key (ref_categorie) references categorie(id)
);

describe produit;

create table blague(
id integer primary key auto_increment,
titre VARCHAR(64),
texte VARCHAR(256),
note double,
nbVotes integer
);

describe blague;

INSERT INTO categorie(id,label) VALUES (1,'papeterie');
INSERT INTO categorie(id,label) VALUES (2,'livre');
INSERT INTO categorie(id,label) VALUES (3,'CD');

INSERT INTO produit(numero,label,prix,ref_categorie) VALUES (1,'cahier',1.5,1);
INSERT INTO produit(numero,label,prix,ref_categorie) VALUES (2,'stylo',2.5,1);
INSERT INTO produit(numero,label,prix,ref_categorie) VALUES (3,'trousse',4.5,1);
INSERT INTO produit(numero,label,prix,ref_categorie) VALUES (4,'classeur',5.5,1);

INSERT INTO produit(numero,label,prix,ref_categorie) VALUES (5,'livre1',6.5,2);
INSERT INTO produit(numero,label,prix,ref_categorie) VALUES (6,'livre2',7.5,2);

INSERT INTO produit(numero,label,prix,ref_categorie) VALUES (7,'CD1',8.5,3);
INSERT INTO produit(numero,label,prix,ref_categorie) VALUES (8,'CD2',9.5,3);

INSERT INTO blague(id,titre,texte,note,nbVotes) VALUES (1,'blague pourrie','JSP=Je Sais Pas',2.0,1);
INSERT INTO blague(id,titre,texte,note,nbVotes) VALUES (2,'blague pour sans cervelle','Cervelet ou Servlet?',2.0,1);
INSERT INTO blague(id,titre,texte,note,nbVotes) VALUES (3,'blague de la chaise','elle est pliante',2.0,1);

SELECT * FROM categorie;
SELECT * FROM produit;
SELECT * FROM blague;
