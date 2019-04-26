INSERT INTO user (id, first_name, last_name, email, password) VALUES (1, 'Alexis', 'Dumay', 'alexis.dumay@axa.fr', '1234');

INSERT INTO role (id, name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO role (id, name) VALUES (2, 'ROLE_USER');

INSERT INTO users_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO users_roles (user_id, role_id) VALUES (1, 2);

insert into site (id,nom,description,cotation_min,cotation_max,type_roche,ancrage,relais,altitude,orientation,lieu) values ('1','Moncel','coteaux','4A','9H','caillou','poteaux','type COLLINOX scéllés',450,'est','54280 Moncel Sur Seille');

insert into secteur (site_id,nom,description) values ('1','gare','à droite');
insert into secteur (site_id,nom,description) values ('1','vaimbois','au milieu');
insert into secteur (site_id,nom,description) values ('1','lotissement','à gauche');

insert into voie (secteur_id,nom,cotation) values ('1','soleil','4A');
insert into voie (secteur_id,nom,cotation) values ('1','lune','9A');

insert into voie (secteur_id,nom,cotation) values ('2','eclipse','9H');

insert into voie (secteur_id,nom,cotation) values ('3','sunset','4A');

INSERT into longueur (voie_id,cotation,description) values ('1','5A','petite longueur');
INSERT into longueur (voie_id,cotation,description) values ('1','8A','grosse longueur');
INSERT into longueur (voie_id,cotation) values ('1','5');

INSERT into longueur (voie_id,cotation,description) values ('2','8A','longueur 1');
INSERT into longueur (voie_id,cotation) values ('2','5');

INSERT into longueur (voie_id,cotation,description) values ('3','6A','longueur 1');
INSERT into longueur (voie_id,cotation) values ('3','7');

