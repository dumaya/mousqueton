INSERT INTO user (id, first_name, last_name, email, password) VALUES (1, 'Alexis', 'Dumay', 'alexis.dumay@axa.fr', '1234');

INSERT INTO role (id, name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO role (id, name) VALUES (2, 'ROLE_USER');

INSERT INTO users_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO users_roles (user_id, role_id) VALUES (1, 2);