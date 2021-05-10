CREATE SEQUENCE messages_seq START WITH 1;

Drop table if exists messages;

CREATE TABLE messages
(

    id      BIGINT PRIMARY KEY DEFAULT nextval('messages_seq'),
    mid     BIGINT                            not null,
    body    VARCHAR                          NOT NULL,
    queue   VARCHAR            DEFAULT 'DLQ' NOT NULL,
    timing  time                         NOT NULL

);

