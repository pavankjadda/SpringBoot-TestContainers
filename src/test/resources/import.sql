CREATE TABLE employee
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    first_name VARCHAR(255)          NOT NULL,
    last_name  VARCHAR(255)          NOT NULL,
    email      VARCHAR(255)          NOT NULL,
    phone      VARCHAR(255)          NOT NULL,
    CONSTRAINT pk_employee PRIMARY KEY (id)
);

INSERT INTO employee (email, first_name, last_name, phone) VALUES ('jdoe@example.com', 'John', 'Doe', '123-852-5225');
INSERT INTO employee (email, first_name, last_name, phone) VALUES ('jryan@example.com', 'Jack', 'Ryan', '123-852-5225');
INSERT INTO employee (email, first_name, last_name, phone) VALUES ('tcruise@example.com', 'Tom', 'Cruise', '123-852-5225');
