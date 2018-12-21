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
INSERT INTO blague(id,titre,texte,note,nbVotes) VALUES (4,'ni queue ni tete','connais tu la blague de eunuque qui sait fait decapiter ? Non . Tu perds rien elle a ni queue ni tete',2.0,1);
INSERT INTO blague(id,titre,texte,note,nbVotes) VALUES (5,'Halloween','allo win , ici trouille',2.0,1);
INSERT INTO blague(id,titre,texte,note,nbVotes) VALUES (6,'prenom nom','Jean Bon , Axelle Aire , Alex Therieur, ...',2.0,1);
INSERT INTO blague(id,titre,texte,note,nbVotes) VALUES (7,'blonde devant ascenseur','Appelle ascenseur STP . Ascenseur, ascenseur ! Non , pas comme ca avec le doigt . assssr , assc (avec doigt dans la bouche)!',2.0,1);
INSERT INTO blague(id,titre,texte,note,nbVotes) VALUES (8,'blague de grande surface','une blague qui a pas super marche',2.0,1);
INSERT INTO blague(id,titre,texte,note,nbVotes) VALUES (9,'pingouin','un pingouin respirait par les fesses. il se est assi . il en est mort',2.0,1);

SELECT * FROM categorie;
SELECT * FROM produit;
SELECT * FROM blague;
