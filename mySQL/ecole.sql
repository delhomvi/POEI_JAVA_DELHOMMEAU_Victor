DROP TABLE classes;
DROP TABLE eleves;
DROP TABLE matiere;
DROP TABLE notes;



CREATE TABLE classes(
    id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
    nom VARCHAR(50)
);

CREATE TABLE eleves(
    id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
    nom VARCHAR(50),
    prenom VARCHAR(50),
    id_classe INT
);

CREATE TABLE matiere(
    id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
    nom VARCHAR(50),
    comments TEXT
);

CREATE TABLE notes(
    id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
    id_eleve INT,
    id_matière INT,
    value_note INT
);

INSERT INTO classes (nom) VALUES
('CP'),
('CE1'),
('CE2'),
('CM1'),
('CM2');

INSERT INTO eleves (nom,prenom,id_classe) VALUES
('toto','dodo',1),
('tata','dada',2),
('tute','dude',3),
('tutu','dudu',3),
('titi','didi',3);

INSERT INTO matiere(nom,comments) VALUES
('Math','Matière la plus detestée'),
('Français',NULL),
('Anglais',NULL),
('Histoire','Matière interessante'),
('Economie',NULL);

INSERT INTO notes(id_eleve,id_matière,value_note) VALUES
(3,1,10),
(4,1,15),
(5,1,19),
(3,2,10),
(4,2,16),
(5,2,20),
(3,3,9),
(4,3,14),
(5,3,18);

SELECT eleves.nom,eleves.prenom,classes.nom as classe
FROM eleves
JOIN classes ON eleves.id_classe=classes.id;

SELECT eleves.nom,eleves.prenom,classes.nom as Classe,matiere.nom as Matières,notes.value_note as Moyenne
FROM notes
JOIN eleves ON notes.id_eleve=eleves.id
JOIN matiere ON notes.id_matière=matiere.id
JOIN classes ON eleves.id_classe=classes.id
;


