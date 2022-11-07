-- Création table ----------------------------------------------------------------------------------------------------------------------------------
CREATE TABLE infosEleves (
    Nom VARCHAR(120) ,
    Prenom VARCHAR(120) ,
    Age INT DEFAULT 12,
    Moy_Generale DOUBLE, 
    dateInscription DATETIME
);


-- Altérations ----------------------------------------------------------------------------------------------------------------------------------
-- ajoute/enlève/renome les colonnes
ALTER TABLE infosEleves RENAME to infos_eleves -- renome le fichier
ALTER TABLE infosEleves RENAME COLUMN Prenom to Prenoms -- renome une colonne
ALTER TABLE infosEleves ADD COLUMN toto -- Ajoute une colonne
ALTER TABLE infosEleves DROP COLUMN toto -- SUpprime une colonne
DROP TABLE XXXX // Suprime la table de nom XXXX

-- Entrer des infos dans les tables
INSERT INTO infosEleves (Nom,Prenom,Age,Moy_Genereale,dateInscription) VALUES ('Dutronc','Toto',12,10.00,1667234621);


-- Recuperer les info des tables
SELECT Nom, Prenom, Age FROM infosEleves;


--  variation des conditions
WHERE Age<=12 -- Conditions necessaire à la selection
WHERE Age BETWEEN 12 AND 13 -- Double condition
WHERE Nom IN ('Toto','tutu')  -- Va chercher un element dans une colonne
WHERE Nom LIKE '%Tot%' -- Like est la condition ncontines, les % indiquent un "joker" sur les elem, genre contiens

-- Supprimer une ligne de tableau
DELETE FROM infosEleves WHERE Prenom = 'Toto'

-- MAJ une ligne
UPDATE infosEleves SET Prenom = 'Toto' WHERE Prenom = 'Tata'

-- Afficher des resultats sans avoir de doublons
SELECT DISTINCT * FROM BDD;
-- Les alias
SELECT id as i, comment as c FROM BDD; -- permet de renomer les collones affichées dans le terminal, et permet de reduire en meme temps la taille des variables

-- MAJ des lignes
UPDATE client
SET col1 = 'val1', col2 = 'val2', col3 = 'val3'
WHERE id = value;




-- Avancé ----------------------------------------------------------------------------------------------------------------------------------
-- Clés primaires = id unique
CREATE TABLE infosEleves (
    idEleves  INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL, -- Identifiant unique, ne sera pas donné a d'autre alterations du tableau
    Nom VARCHAR(120) ,
    Prenom VARCHAR(120) ,
    Age INT ,
    Moy_Generale DOUBLE, 
    dateInscription DATETIME
);
DELETE FROM infoEleves WHERE idEleves = 1


-- Contraintes sur les colonnes de notre tableau (détail en ligne sur les contraintes)
-- UNIQUE (pas de doublons) [...] 
CREATE TABLE infosEleves (
    idEleves INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL, -- Identifiant unique, ne sera pas donné a d'autre alterations du tableau
    Nom VARCHAR(120) NOT NULL UNIQUE,
    Prenom VARCHAR(120) NOT NULL ,
    Age INT ,
    Moy_Generale DOUBLE, 
    dateInscription DATETIME
);
INSERT INTO infosEleves (Nom,Prenom,Age,Moy_Generale,dateInscription) VALUES ('Dutronc','Toto',12,10.00,1667234621);
INSERT INTO infosEleves (Nom,Prenom,Age,Moy_Generale,dateInscription) VALUES ('Dutronc','Toto',12,10.00,1667234621);


-- Clés étrangères = permet de lier des tableaux selon leurs id par exemple
PRAGMA foreign_key = ON ;
CREATE TABLE IF NOT EXISTS categories (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    title VARCHAR(50) NOT NULL,
    description TEXT
);
INSERT INTO categories (title) VALUES ('Fruits');
INSERT INTO categories (title) VALUES ('Legumes');
CREATE TABLE IF NOT EXISTS categoriesFruit (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    title VARCHAR(50) NOT NULL,
    description TEXT,
    category_id INTEGER,
    FOREIGN KEY (category_id) REFERENCES categories (id) ON DELETE CASCADE -- Différentes facon de définir les base de données, liaisons etc...
);
INSERT INTO categoriesFruit (title,description,category_id) VALUES ('Pomme','La pomme est un fruit rond',1);
INSERT INTO categoriesFruit (title,description,category_id) VALUES ('Poire','La poire est un fruit bon mais bizare',1);
INSERT INTO categoriesFruit (title,description,category_id) VALUES ('Pomme de terre','La pomme de terre est ronde',2);
INSERT INTO categoriesFruit (title,description,category_id) VALUES ('Carrot','La carrot est orange',2);

SELECT *
FROM categoriesFruit r
JOIN categories c ON r.category_id = c.id; -- Joint les tableaux + renoms des tableaux

-- Jointure des éléments de tableaux, plusieurs types de jointures, voir les details sur le web
SELECT r.id , r.c 
FROM categoriesFruit r
JOIN categories c ON r.category_id = c.id;

-- Jointure sur des elements non liés, mettra des null si rien n'est spécifié
SELECT *
FROM BDD1
LEFT JOIN BDD2 ON BDD_id1=BDD_id2;


-- Agrégations = Types de données utiles en gros
-- AVG/COUNT/GROUP CONCAT/MAX/MIN ...
SELECT COUNT(category_id) FROM categoriesFruit -- Compte le nombre d'éléments dans la BDD
SELECT SUM(int) FROM BDD -- somme les valeurs d'une colonne int d'une bdd
SELECT GROUP_CONCAT(title,',') FROM BDD -- concatène les elements d'une colonne d'une bdd genre elem1,elem2 ...
SELECT COUNT(id), duration FROM BDD GROUP BY duration -- Va compter le nombre d'elements d'une BDD et va les grouper par valeurs genre x eleme de durée y
SELECT XX FROM BDD GROUPED BY YY HAVING XXcondition -- va selectionner des elem et conditionne cette selection
SELECT COUNT(id), duration FROM BDD GROUP BY duration ORDER BY COUNT(id) LIMIT Z OFFSET ZZ-- Va tier les données à affichier selon les resultats, et se limite à Z resultats à partir du resultat ZZ

-- Les sous requettes dans des requettes
SELECT * (SELECT COUNT(*) FROM BDD2)FROM BDD ; -- Va effectuer le requette et va ajouter à la fin du resultat le resultat de la sous requette

-- Requettes corélées = Permet par exemple de compter le nombre d'ingrédient dans une recette
SELECT * (SELECT COUNT(*) FROM ingrédients_recettes WHERE recette_id=recettes.id) FROM recettes ;


-- Les transactions= groupper des sous requettes et permet de rollback si opé delicate
BEGIN TRANSACTION;
SELECT ...;
DELETE ...;
SELECT ...;
ROLLBACK TRANSACTION;
COMMIT TRANSACTION; -- Quand tu es satisfait tu fait le transaction

-- Ajouter une colonne conditionelle
SELECT * 
CASE
    WHEN cond1 THEN 'RES1'
    WHEN cond2 THEN 'RES2'
    ELSE 'RES3'
END
FROM BDD;

-- UNION et INTERSECTion des bdd = si des bdd on des colonnes identiques, on peut union les bdd ensemble
SELECT * FROM BDD1
UNION/INTERSECT
SELECT * FROM BDD2;



/*
MCD
---

Façon de representer des bases de données


Dans les schéma on a des boites qui représentrent les bases de données, boites reliée entre elles par des laiison
qui définissent le lien entre les bases de données (on note le attributs dans les liens, les attributs doivent dépendre 
des deux BDD, par exemple les quantité, 
l'unit" de mesure ...); on définit ensuite les cardinalités, c'est a dire par exemple pour un lien:

|Aliment| - |composée de| - |Recettes|

la quantité de lien par boucle:
-> une recette est composée de combien d'aliment ? 
    - au moins 1 aliment
    - peut etre composée de n aliments

DONC : |Aliment| - |composée de| - 1,n - |Recettes|

de même 
-> un aliment peut etre dans combien de recette ?
    - un aliment peut être dans aucune recette
- > combien de recettes peuvent être composé d'un aliment?
    - n recettes peuvent être composée de n aliments


Pour eviter d'avoir des repetitions style 
|Legumes| - |composée de| - |Recettes|
|Fruits| - 

on fusion de façon plus générique les entitées



De même on normalise, si on a un truc du genre 
| clients | - |commandes|
|addresse |   |addresse |
on met addresse qu'une seule fois, pour eviter les repetitions


MLD
---
Modèle logique de données
On reprend le MCD et on fait le lien entre les clés étrangères etc.. 
Si on a n chemins possible dans les cardinaux, on crée des boites intermediaires

*/