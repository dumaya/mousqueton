INSERT INTO user (id, first_name, last_name, email, password) VALUES (1, 'Alexis', 'Dumay', 'alexis.dumay@axa.fr', '$2a$10$RyY4bXtV3LKkDCutlUTYDOKd2AiJYZGp4Y7MPVdLzWzT1RX.JRZyG');

INSERT INTO role (id, name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO role (id, name) VALUES (2, 'ROLE_UTILISATEUR');
INSERT INTO role (id, name) VALUES (3, 'ROLE_AMI_ESCALADE');

INSERT INTO users_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO users_roles (user_id, role_id) VALUES (1, 2);

INSERT INTO user (id, first_name, last_name, email, password) VALUES (2, 'Tom', 'Dumoulin', 'alexlanoisette@gmail.fr', '$2a$10$RyY4bXtV3LKkDCutlUTYDOKd2AiJYZGp4Y7MPVdLzWzT1RX.JRZyG');
INSERT INTO users_roles (user_id, role_id) VALUES (2, 1);
INSERT INTO users_roles (user_id, role_id) VALUES (2, 2);

insert into site (id,nom,description,cotation_min,cotation_max,type_roche,ancrage,relais,altitude,orientation,lieu) values ('1','Moncel','coteaux','4A','9H','caillou','poteaux','type COLLINOX scéllés',450,'est','54280 Moncel Sur Seille');

insert into secteur (id,site_id,nom,description) values ('1','1','gare','à droite');
insert into secteur (id,site_id,nom,description) values ('2','1','vaimbois','au milieu');
insert into secteur (id,site_id,nom,description) values ('3','1','lotissement','à gauche');

insert into voie (id,secteur_id,nom,cotation) values ('1','1','soleil','4A');
insert into voie (id,secteur_id,nom,cotation) values ('2','1','lune','9A');

insert into voie (id,secteur_id,nom,cotation) values ('3','2','eclipse','9H');

insert into voie (id,secteur_id,nom,cotation) values ('4','3','sunset','4A');

INSERT into longueur (id,voie_id,cotation,description) values ('1','1','5A','petite longueur');
INSERT into longueur (id,voie_id,cotation,description) values ('2','1','8A','grosse longueur');
INSERT into longueur (id,voie_id,cotation) values ('3','1','5');

INSERT into longueur (id,voie_id,cotation,description) values ('4','2','8A','longueur 1');
INSERT into longueur (id,voie_id,cotation) values ('5','2','5');

INSERT into longueur (id,voie_id,cotation,description) values ('6','3','6A','longueur 1');
INSERT into longueur (id,voie_id,cotation) values ('7','3','7');

INSERT into topo (dispo_pret,lieu, nom,description,user_proprietaire_id) values (true,'Le bois joli','grimpette','topo dispo','1' );
INSERT into topo (dispo_pret,lieu, nom,description,user_proprietaire_id) values (false ,'La montagne grise','grisaille','topo non dispo','1' );
INSERT into topo (dispo_pret,user_emprunteur_id,lieu, nom,description,user_proprietaire_id) values (true,'2','joli falaise','grimpette','demande de resa en cours','1');
INSERT into topo (dispo_pret,user_emprunteur_id,lieu, nom,description,user_proprietaire_id) values (false,'2','La montagne brune','grisaille','demande acceptée','1');
