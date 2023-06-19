DROP TABLE IF EXISTS addresses;

CREATE TABLE addresses(
    id VARCHAR(100) NOT NULL,
    contact_id VARCHAR(100) NOT NULL,
    street VARCHAR(200),
    city VARCHAR(100),
    province VARCHAR(100),
    country VARCHAR(100) NOT NULL,
    postal_code VARCHAR(100),
    PRIMARY KEY (id),
    CONSTRAINT fk_contacts_addresses FOREIGN KEY (contact_id) REFERENCES contacts (id)
);

SELECT * FROM addresses;