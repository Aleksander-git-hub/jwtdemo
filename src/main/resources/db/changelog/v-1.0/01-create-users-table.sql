CREATE TABLE users(
    id bigserial PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(60) NOT NULL,
    created TIMESTAMP default current_timestamp NOT NULL,
    updated TIMESTAMP default current_timestamp NOT NULL,
    status VARCHAR(255) default 'ACTIVE' NOT NULL
);

OK