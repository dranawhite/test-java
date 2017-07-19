DROP TABLE T_CUSTOMER;

CREATE TABLE T_CUSTOMER (
  id        INTEGER PRIMARY KEY,
  name      VARCHAR(30),
  contact   VARCHAR(30),
  telephone VARCHAR(11),
  email     VARCHAR(30),
  remark    VARCHAR(30)
);

TRUNCATE TABLE T_CUSTOMER;

INSERT INTO T_CUSTOMER (id, name, contact, telephone, email, remark)
VALUES
  (
    1,
    'customer1',
    'Jack',
    '13512345678',
    'jack@gmail.com',
    NULL);
INSERT INTO T_CUSTOMER (id, name, contact, telephone, email, remark)
VALUES
  (
    2,
    'customer2',
    'Rose',
    '13623456789',
    'rose@gmail.com',
    NULL);