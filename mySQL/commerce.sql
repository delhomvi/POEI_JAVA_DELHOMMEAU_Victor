/*
Initialisation BDD
*/

DROP TABLE articles;
DROP TABLE clients;
DROP TABLE facture;
DROP TABLE ligne;

/*
Creation BDD
*/
CREATE TABLE articles(
    id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
    nom VARCHAR(50),
    price FLOAT,
    quantity INT
);

CREATE TABLE clients(
    id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
    nom VARCHAR(50) NOT NULL,
    prenom VARCHAR(50) NOT NULL,
    adresse TEXT NOT NULL
);

CREATE TABLE facture(
    id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
    client_id INT NOT NULL,
    date_creation TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE ligne(
    id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
    article_id INT,
    facture_id INT,
    quantity INT
);

-- Remplissage des BDD
INSERT INTO articles (nom,price,quantity) VALUES
('laitue',1.50,5),
('scarole',1.25,5),
('roquette',1.33,6),
('radis',2.5,5),
('tomate',4.5,5),
('oignons',1.55,5);

INSERT INTO clients (nom,prenom,adresse) VALUES
('Durand','Toto','11 rue des charmes'),
('Dutrou','Kevin','13 rue des charmes'),
('Dubosquet','Dylan','15 rue des charmes'),
('Dutronc','Maria','17 rue des charmes');

-- Création ligne d'achat et de la facture
INSERT INTO ligne (facture_id,article_id,quantity) VALUES
(1,1,2),
(1,2,1),
(1,3,1),
(1,4,4),
(1,5,2),
(1,6,1),
(2,1,1),
(2,2,1),
(2,3,3),
(2,4,1),
(3,1,1);

INSERT INTO facture (client_id) VALUES 
(1),
(2),
(3);

/*
Affichage des tables
*/
SELECT * FROM articles;
SELECT * FROM clients;
SELECT * FROM ligne;
SELECT * FROM facture;

/*
Affichage de la facture
*/

SELECT facture.id as numFacture,nom,prenom,adresse -- liaison client facture
FROM facture, clients
WHERE facture.client_id=clients.id;

SELECT articles.nom as article, ligne.quantity as qty -- liaison chariot rayons
FROM ligne,articles
WHERE ligne.article_id=articles.id;

SELECT facture.id as FactureNumero,articles.nom as article, ligne.quantity as qty,ligne.quantity*articles.price as SubTotal
FROM ligne,facture,articles -- Facture et ce qu'il y a dedans
WHERE ligne.article_id=articles.id ;

SELECT ligne.facture_id as FactureNumero,ligne.quantity,articles.nom,articles.price, articles.price*ligne.quantity as subTot
FROM ligne
JOIN articles ON ligne.article_id=articles.id
ORDER BY FactureNumero
;


SELECT ligne.facture_id as FactureNumero,clients.nom,ligne.quantity,articles.nom,articles.price, articles.price*ligne.quantity as subTot
FROM ligne
JOIN articles ON ligne.article_id=articles.id
JOIN facture ON ligne.facture_id=facture.id
JOIN clients ON facture.client_id=clients.id
ORDER BY FactureNumero
;



INSERT INTO facture (client_id) VALUES 
(1);
INSERT INTO ligne (facture_id,article_id,quantity) VALUES 
(4,1,2),
(4,4,4);
SELECT ligne.facture_id as FactureNumero,clients.nom,ligne.quantity,articles.nom,articles.price, articles.price*ligne.quantity as subTot
FROM ligne
JOIN articles ON ligne.article_id=articles.id
JOIN facture ON ligne.facture_id=facture.id
JOIN clients ON facture.client_id=clients.id
WHERE clients.nom = 'Durand'
;

SELECT SUM(articles.price*ligne.quantity) as TotDurand
FROM ligne
JOIN articles ON ligne.article_id=articles.id
JOIN facture ON ligne.facture_id=facture.id
JOIN clients ON facture.client_id=clients.id
WHERE clients.nom = 'Durand'
;
