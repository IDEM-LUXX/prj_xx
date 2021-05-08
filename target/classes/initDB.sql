

CREATE SEQUENCE global_seq2 START WITH 100000;


CREATE TABLE users2
(
    id       BIGINT PRIMARY KEY DEFAULT nextval('global_seq2'),
    chatId   BIGINT UNIQUE                NOT NULL,
    userName VARCHAR                       NOT NULL,
    record   INTEGER             DEFAULT 0 NOT NULL

);

