DROP TABLE IF EXISTS user_product;
DROP TABLE IF EXISTS user_category;
DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START 100000;

CREATE TABLE users
(
  id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name        VARCHAR NOT NULL,
  email       VARCHAR NOT NULL,
  password    VARCHAR NOT NULL,
  registered  TIMESTAMP DEFAULT now()
);
CREATE UNIQUE INDEX users_unique_email_idx ON users (email);

CREATE TABLE user_category
(
  id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name        VARCHAR NOT NULL,
  user_id     INTEGER NOT NULL,
  red         SMALLINT,
  green       SMALLINT,
  blue        SMALLINT,
  CONSTRAINT user_category_idx UNIQUE (user_id, name),
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE user_product
(
  id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name        VARCHAR NOT NULL,
  created     TIMESTAMP DEFAULT now(),
  quantity    INTEGER NOT NULL,
  dimension   VARCHAR NOT NULL,
  price       INTEGER,
  description VARCHAR,
  category_id INTEGER NOT NULL,
  user_id     INTEGER NOT NULL,
  CONSTRAINT user_product_idx UNIQUE (user_id, category_id, name),
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);
