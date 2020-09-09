DROP TABLE IF EXISTS api_token;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS units;

CREATE TABLE units
(
 id bigint NOT NULL ,
 name TEXT NOT NULL,
 status integer NOT NULL,
 rent bigint NOT NULL,
 rent_balance bigint NOT NULL,
 last_payment_date bigint NOT NULL,
 tenant_id bigint NOT NULL,
 property_name TEXT NOT NULL,
 property_short_code TEXT NOT NULL,
 PRIMARY KEY (id)
);

CREATE TABLE users
(
 id bigint NOT NULL ,
 national_id TEXT NOT NULL ,
 phone TEXT NOT NULL ,
 username TEXT NOT NULL ,
 password TEXT NOT NULL ,
 first_name TEXT NOT NULL ,
 last_name TEXT NOT NULL ,
 role integer NOT NULL,
 PRIMARY KEY (id)
);

CREATE TABLE tenants
(
 id bigint NOT NULL ,
 phone TEXT NOT NULL ,
 national_id TEXT NOT NULL ,
 first_name TEXT NOT NULL ,
 last_name TEXT NOT NULL ,
 PRIMARY KEY (id)
);

CREATE TABLE api_token
(
 id bigint NOT NULL ,
 expiry bigint NOT NULL ,
 token TEXT NOT NULL ,
 PRIMARY KEY (id)
);

CREATE SEQUENCE tenant_sequence;
CREATE SEQUENCE user_sequence;
CREATE SEQUENCE unit_sequence;