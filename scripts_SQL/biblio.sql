/*
Initialisation de la BDD
*/
DROP TABLE compte;
DROP TABLE emprunt;
DROP TABLE livres;
DROP TABLE auteur;
DROP TABLE editeur;
DROP TABLE genre;
DROP TABLE livres_auteurs;
DROP TABLE livres_genre;


/*
Creation des tables
*/
CREATE TABLE compte(
    id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
    nom VARCHAR(255) NOT NULL,
    prenom VARCHAR(255) NOT NULL,
    adresse TEXT,
    contacts TEXT,
    notes TEXT
);


CREATE TABLE emprunt(
    id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
    id_account INT NOT NULL,
    id_livre INT NOT NULL,
    date_emprunt VARCHAR(255),
    date_retour VARCHAR(255),
    notes TEXT
);

CREATE TABLE livres(
    id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
    titre VARCHAR(255) NOT NULL,
    id_editeur INT NOT NULL,
    quantité INT NOT NULL,
    id_genre INT,
    date_parution VARCHAR(255),
    resumee TEXT,
    localisation TEXT,
    etats TEXT,
    notes TEXT
);


CREATE TABLE auteur(
    id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
    nom VARCHAR(255) NOT NULL,
    prenom VARCHAR(255),
    comments TEXT
);

CREATE TABLE livres_auteurs(
    id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
    id_livre INT NOT NULL,
    id_auteur INT NOT NULL
);

CREATE TABLE editeur(
    id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
    nom VARCHAR(255) NOT NULL,
    comments TEXT
);

CREATE TABLE genre(
    id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
    nom VARCHAR(255) NOT NULL,
    notes TEXT
);

CREATE TABLE livres_genre(
    id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
    id_livre INT NOT NULL,
    id_genre INT NOT NULL
);

/*
ALTER TABLE emprunt
ADD CONSTRAINT id_account FOREIGN KEY(id_account) REFERENCES compte(id);
ALTER TABLE emprunt
ADD CONSTRAINT id_livre FOREIGN KEY(id_livre) REFERENCES livres(id);
ALTER TABLE livres_auteurs
ADD CONSTRAINT id_auteur FOREIGN KEY(id_auteur) REFERENCES auteur(id);
ALTER TABLE livres_genre
ADD CONSTRAINT id_genre FOREIGN KEY(id_genre) REFERENCES genre(id);
*/
/*
Remplissage des tables
*/

INSERT INTO compte(nom,prenom,adresse,contacts,notes) VALUES
('Durand','Toto','11 rue de la bétise','Mail: toto.durand@betise.fr','est plutot mauvais'),
('Durand','Tata','11 rue de la bétise','Mail: tata.durand@betise.fr','maman de toto desespérée'),
('Durand','Tutu','11 rue de la bétise','Mail: tutu.durand@betise.fr','soeur de toto');

INSERT INTO emprunt(id_account,id_livre,date_emprunt,date_retour,notes) VALUES
(1,3,'Lundi 10 Mars 2022',NULL,NULL),
(1,4,'Lundi 10 Mars 2022',NULL,NULL),
(1,5,'Lundi 10 Mars 2022',NULL,NULL),
(2,10,'Lundi 10 Mars 2022','Vendredi 14 Mars 2022',NULL),
(3,11,'Lundi 10 Mars 2022','Vendredi 14 Mars 2022',NULL);

INSERT INTO livres(titre, id_editeur, quantité, date_parution, resumee, localisation, etats, notes) VALUES
('Les Misérables', 3, 1, 'il y a longtemps', 'INSERT RESUME', 'Dans le rayon Romance', 'Neuf', NULL),
('Star Wars', 1, 1, 'Moins de 20 ans', 'Il y a fort fort longtemps dans une galaxie inconue', 'Dans le rayon SF', 'Neuf', NULL),
('Harry Potter à l\'école des sorciers', 1, 1, 'ya un petit moment', 'Gamin sous l\'escalier', 'Rayon Fantastique', 'Neuf', NULL),
('Harry Potter et la chambre des secrets', 1, 1, 'ya un petit moment', 'Gamin un peu moins sous l\'escalier', 'Rayon Fantastique', 'Neuf', NULL),
('Harry Potter et le prisonier d\'azkaban', 1, 1, 'ya un petit moment', 'Gamin plus tellement sous l\'escalier', 'Rayon Fantastique', 'Neuf', NULL),
('Harry Potter et la coupe de feu', 1, 1, 'ya un petit moment', 'Gamin plus du tout sous l\'escalier', 'Rayon Fantastique', 'Neuf', NULL),
('Harry Potter à l\'ordre du phenix', 1, 1, 'ya un petit moment', 'Gamin dans sa chambre', 'Rayon Fantastique', 'Neuf', NULL),
('Harry Potter à les reliques de la mort', 1, 1, 'ya un petit moment', 'Gamin qui vit', 'Rayon Fantastique', 'Neuf', NULL),
('Les fleurs du mal', 3, 5, 'Ya longtemps', 'INSERT RESUME', 'Dans le rayon ', 'Neuf', NULL),
('Maman a tort', 2, 1, 'Ya pas longtemps', 'Bla bla romance', 'Dans le rayon romance', 'Neuf', NULL),
('C\'est arrivé la nuit', 2, 1, 'Ya pas longtemps', 'blabla police', 'Rayon policier', 'Neuf', NULL);

INSERT INTO livres_auteurs(id_livre,id_auteur) VALUES
(1,3),
(2,6),
(3,2),(4,2),(5,2),(6,2),(7,2),(8,2),
(9,1),
(10,4),
(11,5);

INSERT INTO livres_genre(id_livre,id_genre) VALUES
(1,2),
(2,4),
(3,3),(4,3),(5,3),(6,3),(7,3),(8,3),
(9,1),
(10,2),
(11,1);

INSERT INTO genre (nom,notes) VALUES
('Policier','Genre axé sur les enquetes, les meurtres et tout ce qui touche de près ou de loin à la police'),
('Romance','Genre axé l\'amour et les liens entre les personnage, souvent à l\'eau de rose'),
('Fantastique','Genre axé sur les histoire fictives d\'aventure ou d\'autre type de péripeties'),
('Science fiction','Genre axé sur la science et le futur'),
('Poesie','Genre axé sur la lyrique')
;

INSERT INTO editeur (nom,comments) VALUES 
('Gallimard','Maison d\'édition connue pour ses romans fantastique' ), 
('Flamarion','Maison d\'édition connue pour ses contes epiques' ), 
('Hachette','Maison d\'édition connue pour ses ouvrages scolaires' )
;

INSERT INTO auteur (nom,prenom,comments) VALUES
('Baudelaire','C.','Auteur connu pour ses poésies'),
('Rowling','J.K.','Autrice connue notemment pour Harry Potter'),
('Hugo','V.','Auteur connu pour de nombreux ouvrages notemment les misérables'),
('Bussi','M.','Auteur romance'),
('Levy','M.','Auteur connu policier'),
('Lucas','G.','Createur de Star Wars');


/*
Affichage des resultats
*/
SELECT * FROM compte;
SELECT * FROM emprunt;
SELECT * FROM livres;
SELECT * FROM auteur;
SELECT * FROM editeur;
SELECT * FROM genre;
SELECT * FROM livres_auteurs;
SELECT * FROM livres_genre;

/*
SELECT compte.nom as Nom, compte.prenom as Prenom, livres.titre as Titre, emprunt.date_emprunt as Date_Emprunt, emprunt.date_retour as Date_Retour
FROM emprunt
JOIN emprunt_livres ON emprunt_livres.id_emprunt=emprunt.id
JOIN livres ON livres.id=emprunt_livres.id_livre
JOIN compte ON emprunt.id_account=compte.id
WHERE Date_Retour is not NULL
;

SELECT livres.titre as Titre, livres.resumee as Résumé, livres.localisation as Localisation
FROM livres
LEFT JOIN emprunt_livres ON emprunt_livres.id_livre=livres.id
LEFT JOIN emprunt ON emprunt_livres.id_emprunt=emprunt.id
WHERE emprunt.date_retour is not NULL
;
