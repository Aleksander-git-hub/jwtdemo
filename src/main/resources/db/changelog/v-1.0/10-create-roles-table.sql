CREATE TABLE roles(
    id bigserial PRIMARY KEY,
    name VARCHAR(255) UNIQUE NOT NULL,
    created TIMESTAMP default current_timestamp NOT NULL,
    updated TIMESTAMP default current_timestamp NOT NULL,
    status VARCHAR(255) default 'ACTIVE' NOT NULL
);

OK