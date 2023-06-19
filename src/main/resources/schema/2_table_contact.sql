DROP TABLE IF EXISTS contacts;

CREATE TABLE contacts (
    id VARCHAR(100) NOT NULL,
    username VARCHAR(100) NOT NULL,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100),
    phone VARCHAR(100),
    email VARCHAR(100),
    PRIMARY KEY (id),
    CONSTRAINT fk_users_contacts FOREIGN KEY (username) REFERENCES users (username)
);

SELECT * FROM contacts;