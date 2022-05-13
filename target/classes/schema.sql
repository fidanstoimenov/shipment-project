CREATE TABLE SENDER
(
    id      SMALLINT AUTO_INCREMENT PRIMARY KEY,
    name    VARCHAR(64) NOT NULL,
    surname VARCHAR(64) NOT NULL,
    email   VARCHAR(64) NOT NULL
);

CREATE TABLE POSTMAN
(
    id      SMALLINT AUTO_INCREMENT PRIMARY KEY,
    name    VARCHAR(64) NOT NULL,
    surname VARCHAR(64) NOT NULL
);

CREATE TABLE SHIPMENT
(
    id         SMALLINT AUTO_INCREMENT PRIMARY KEY,
    sender_id  SMALLINT NOT NULL,
    postman_id SMALLINT NOT NULL,
    CONSTRAINT fk_shipment_sender_id FOREIGN KEY (sender_id) REFERENCES sender (id),
    CONSTRAINT fk_shipment_postman_id FOREIGN KEY (postman_id) REFERENCES postman (id)
);

CREATE TABLE ADDRESS
(
    id          SMALLINT AUTO_INCREMENT PRIMARY KEY,
    city        VARCHAR(64) NOT NULL,
    address     VARCHAR(64) NOT NULL,
    shipment_id SMALLINT    NOT NULL,
    CONSTRAINT fk_address_shipment_id FOREIGN KEY (shipment_id) REFERENCES shipment (id)
);

CREATE TABLE TAG
(
    id   SMALLINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(64) NOT NULL
);

CREATE TABLE SHIPMENT_TAG
(
    id          SMALLINT AUTO_INCREMENT PRIMARY KEY,
    shipment_id SMALLINT NOT NULL,
    tag_id      SMALLINT NOT NULL,
    CONSTRAINT fk_shipment_tag_shipment_id FOREIGN KEY (shipment_id) REFERENCES shipment (id),
    CONSTRAINT fk_shipment_tag_tag_id FOREIGN KEY (tag_id) REFERENCES tag (id)
);

CREATE TABLE USER
(
    id       SMALLINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(64) NOT NULL,
    password VARCHAR(64) NOT NULL,
    role     VARCHAR(64) NOT NULL,
    user_id  SMALLINT    NOT NULL
);