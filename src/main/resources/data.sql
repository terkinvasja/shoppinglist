-- http://stackoverflow.com/questions/13223820/postgresql-delete-all-content
-- TRUNCATE public CASCADE;

-- http://stackoverflow.com/a/4991969/548473
-- TRUNCATE SCHEMA public AND COMMIT;
DELETE FROM user_product;
DELETE FROM user_category;
DELETE FROM users;

ALTER SEQUENCE global_seq RESTART WITH 100000;

-- $2a$10$Sh0ZD2NFrzRRJJEKEWn8l.92ROEuzlVyzB9SV1AM8fdluPR0aC1ni
INSERT INTO users (name, email, password)
VALUES ('User', 'user@yandex.ru', 'admin');

-- $2a$10$WejOLxVuXRpOgr4IlzQJ.eT4UcukNqHlAiOVZj1P/nmc8WbpMkiju
INSERT INTO users (name, email, password)
VALUES ('Admin Василий', 'admin@gmail.com', 'password');

INSERT INTO user_category (name, user_id, red, green, blue) VALUES
  ('Мясные', 100000, 255, 0, 0),
  ('Молочные', 100001, 0, 0, 255),
  ('Бакалея', 100001, 0, 128, 128);

INSERT INTO user_product (name, created, quantity, dimension, price, category_id, user_id) VALUES
  ('Молоко', '2017-01-25 10:00:00', 2, 'DIMENSION_BOTTLE', 0, 100003, 100001),
  ('Мясо', '2017-01-25 10:01:00', 1, 'DIMENSION_THING', 10, 100002, 100000),
  ('Хлеб', '2017-01-25 10:02:00', 1, 'DIMENSION_THING', 1, 100004, 100001),
  ('Йогурт', '2017-01-25 10:03:00', 5, 'DIMENSION_THING', 0, 100003, 100001),
  ('Торт', '2017-01-25 10:04:00', 1, 'DIMENSION_THING', 0, 100004, 100001),
  ('Кости на суп', '2017-01-25 10:05:00', 5, 'DIMENSION_THING', 100, 100002, 100000),
  ('Минералка', '2017-01-25 10:07:00', 3, 'DIMENSION_BOTTLE', 0, 100004, 100001),
  ('Рыба', '2017-01-25 10:10:00', 2, 'DIMENSION_THING', 7, 100002, 100000);
