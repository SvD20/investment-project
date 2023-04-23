USE `investment_directory`;

INSERT INTO `users`
VALUES
('svyat', '{bcrypt}$2a$10$2SGJnIYxWaNjWyqpcgjEb.az0vAGkpAYE66VZQm8xAbj8/CubUAIu',1),
('max', '{bcrypt}$2a$10$2SGJnIYxWaNjWyqpcgjEb.az0vAGkpAYE66VZQm8xAbj8/CubUAIu',1);


INSERT INTO `authorities`
VALUES
('svyat','ROLE_EMPLOYEE'),
('max', 'ROLE_ADMIN');