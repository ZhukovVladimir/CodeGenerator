CREATE TABLE code
(
    id bigint NOT NULL,
    code TEXT,
    version bigint NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO code (id, code, version)
    VALUES (0, 'a0a0', 0);

