DROP TABLE animal;
DROP TABLE espece;
DROP TABLE nouriture;
DROP TABLE pays;
DROP TABLE animal_nouriture;
DROP TABLE animal_pays;


CREATE TABLE espece(
    id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
    nom VARCHAR(255)
);
CREATE TABLE animal(
    id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
    nom VARCHAR(255),
    id_espece INTEGER
);
ALTER TABLE animal 
ADD CONSTRAINT id_espece FOREIGN KEY(id_espece) REFERENCES espece(id);


CREATE TABLE nouriture(
    id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
    nom VARCHAR(255)
);

CREATE TABLE animal_nouriture(
    id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
    id_animal INTEGER,
    id_nouriture INTEGER
);
ALTER TABLE animal_nouriture
ADD CONSTRAINT id_animal FOREIGN KEY(id_animal) REFERENCES animal(id);
ALTER TABLE animal_nouriture
ADD CONSTRAINT id_nouriture FOREIGN KEY(id_nouriture) REFERENCES nouriture(id);

CREATE TABLE pays(
    id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
    nom VARCHAR(255)
);

CREATE TABLE animal_pays(
    id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
    id_animal INTEGER,
    id_pays INTEGER
);

ALTER TABLE animal_pays
ADD CONSTRAINT id_animal FOREIGN KEY(id_animal) REFERENCES animal(id);
ALTER TABLE animal_pays
ADD CONSTRAINT id_pays FOREIGN KEY(id_pays) REFERENCES pays(id);

INSERT INTO espece (nom) VALUES 
('Poisson'),
('Canidés'),
('Felins'),
('Oiseau'),
('Mamifère'),
('Insecte');

INSERT INTO animal (nom,id_espece) VALUES
('Pigeon',4),
('Bar',1),
('Chien',2),
('Tigre',3),
('Rouge Gorge',4),
('Combatant',1),
('Loup',2),
('Chat domestique',3),
('Oie',4),
('Carpe',1),
('Chacal',2),
('Elephant',5),
('Fourmis',6),
('Humain',5),
('Scarabé',6),
('Guepar',3);


INSERT INTO nouriture (nom) VALUES
('Herbivore'),
('Carnivore'),
('Omnivore'),
('Graine');

INSERT INTO pays(nom) VALUES
('Europe'),
('Asie'),
('Amerique du nord'),
('Amerique du Sud'),
('Afrique'),
('Oceanie');

INSERT INTO animal_nouriture (id_animal,id_nouriture) VALUES
(1,4),
(2,3),
(3,3),
(4,2),
(5,4),
(6,3),
(7,2),
(8,3),
(9,3),
(10,3),
(11,3),
(12,1),
(13,1),
(14,3),
(15,1),
(16,2);

INSERT INTO animal_pays (id_animal,id_pays) VALUES
(1,1),(1,2),(1,3),(1,4),
(2,1),(2,3),
(3,1),(3,2),(3,3),(3,4),(3,5),(3,6),
(4,2),(4,4),(4,5),
(5,1),
(6,1),
(7,1),(7,2),(7,3),(7,4),(7,5),(7,6),
(8,1),(8,2),(8,3),(8,4),(8,5),(8,6),
(9,1),(9,2),
(10,1),
(11,5),
(12,2),(12,5),
(13,1),(13,2),(13,3),(13,4),(13,5),(13,6),
(14,1),(14,2),(14,3),(14,4),(14,5),(14,6),
(15,5),
(16,5);


SELECT * FROM animal;
SELECT * FROM espece;
SELECT * FROM nouriture;
SELECT * FROM pays;
SELECT * FROM animal_pays;
SELECT * FROM animal_nouriture;


SELECT animal.nom , espece.nom
FROM animal
JOIN espece ON animal.id_espece=espece.id;

SELECT animal.nom , nouriture.nom as Nouriture
FROM animal
JOIN animal_nouriture ON animal_nouriture.id_animal=animal.id
JOIN nouriture ON animal_nouriture.id_nouriture=nouriture.id;

SELECT animal.nom , pays.nom
FROM animal
JOIN animal_pays ON animal_pays.id_animal=animal.id
JOIN pays ON animal_pays.id_pays=pays.id;




SELECT animal.nom as animal, espece.nom as espece, nouriture.nom as régime_alimentaire,pays.nom as zone_geographique
FROM animal
JOIN espece ON animal.id_espece=espece.id
JOIN animal_nouriture ON animal_nouriture.id_animal=animal.id
JOIN nouriture ON animal_nouriture.id_nouriture=nouriture.id
JOIN animal_pays ON animal_pays.id_animal=animal.id
JOIN pays ON animal_pays.id_pays=pays.id
;


SELECT DISTINCT animal.nom as animal, espece.nom as espece, nouriture.nom as régime_alimentaire,pays.nom as zone_geographique
FROM animal
JOIN espece ON animal.id_espece=espece.id
JOIN animal_nouriture ON animal_nouriture.id_animal=animal.id
JOIN nouriture ON animal_nouriture.id_nouriture=nouriture.id
JOIN animal_pays ON animal_pays.id_animal=animal.id
JOIN pays ON animal_pays.id_pays=pays.id
;


SELECT animal.nom as animal, espece.nom as espece, COUNT(pays.nom) as NbPays
FROM animal
JOIN espece ON animal.id_espece=espece.id
JOIN animal_nouriture ON animal_nouriture.id_animal=animal.id
JOIN nouriture ON animal_nouriture.id_nouriture=nouriture.id
JOIN animal_pays ON animal_pays.id_animal=animal.id
JOIN pays ON animal_pays.id_pays=pays.id
WHERE animal.nom='Pigeon'
;
