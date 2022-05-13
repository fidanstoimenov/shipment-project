INSERT INTO SENDER (id, name, surname, email)
VALUES (10000, 'Olivier', 'Peters', 'olivierpeters@gmail.com');

INSERT INTO POSTMAN (id, name, surname)
VALUES (10000, 'Kade', 'Richardson');

INSERT INTO SHIPMENT (id, sender_id, postman_id)
VALUES (10000, 10000, 10000);

INSERT INTO ADDRESS (id, city, address, shipment_id)
VALUES (10000, 'LONDON', '81 Manchester Road London SW74 2UE', 10000);

INSERT INTO TAG (id, name)
VALUES (10000, 'FRAGILE');

INSERT INTO TAG (id, name)
VALUES (10001, 'ELECTRONIC');

INSERT INTO TAG (id, name)
VALUES (10002, 'GAMES');

INSERT INTO TAG (id, name)
VALUES (10003, 'FOOD');

INSERT INTO SHIPMENT_TAG (id, shipment_id, tag_id)
VALUES (10000, 10000, 10000);

INSERT INTO SHIPMENT_TAG (id, shipment_id, tag_id)
VALUES (10001, 10000, 10001);

INSERT INTO USER (id, username, password, role, user_id)
VALUES (10000, 'postman', '123', 'POSTMAN', 10000);

INSERT INTO USER (id, username, password, role, user_id)
VALUES (10001, 'sender', '123', 'SENDER', 10000);