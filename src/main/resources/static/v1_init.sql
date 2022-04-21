CREATE TABLE client_model
(
    id                  BIGINT NOT NULL,
    clientid            VARCHAR(255),
    name                VARCHAR(255),
    surname             VARCHAR(255),
    email               VARCHAR(255),
    delivery_option      VARCHAR(255),
    address      VARCHAR(255),
    CONSTRAINT pk_client_model PRIMARY KEY (id)
);

SELECT * FROM client_model;

DROP TABLE client_model;