INSERT INTO operator(first_name, last_name) values ('cristian', 'suruceanu');
INSERT INTO operator(first_name, last_name) values ('aliona', 'florea');
INSERT INTO operator(first_name, last_name) values ('constantin', 'cazacu');
--
INSERT INTO currency(code, name) values ('USD', 'us dollar');
INSERT INTO currency(code, name) values ('EUR', 'euro');
INSERT INTO currency(code, name) values ('MDL', 'lei moldovenesc');
--
INSERT INTO exchange_rate(currency_id, nominal, rate) values (1,1,15);
INSERT INTO exchange_rate(currency_id, nominal, rate) values (2,1,20);
INSERT INTO exchange_rate(currency_id, nominal, rate) values (3,1,1);
--
INSERT INTO cash(operator_id, currency_id, amount, last_modified_date) values (1, 1, 500, CURRENT_TIMESTAMP);
INSERT INTO cash(operator_id, currency_id, amount, last_modified_date) values (1, 2, 500, CURRENT_TIMESTAMP);
INSERT INTO cash(operator_id, currency_id, amount, last_modified_date) values (1, 3, 5000, CURRENT_TIMESTAMP);
INSERT INTO cash(operator_id, currency_id, amount, last_modified_date) values (2, 1, 500, CURRENT_TIMESTAMP);
INSERT INTO cash(operator_id, currency_id, amount, last_modified_date) values (2, 2, 500, CURRENT_TIMESTAMP);
INSERT INTO cash(operator_id, currency_id, amount, last_modified_date) values (2, 3, 5000, CURRENT_TIMESTAMP);
INSERT INTO cash(operator_id, currency_id, amount, last_modified_date) values (3, 1, 500, CURRENT_TIMESTAMP);
INSERT INTO cash(operator_id, currency_id, amount, last_modified_date) values (3, 2, 500, CURRENT_TIMESTAMP);
INSERT INTO cash(operator_id, currency_id, amount, last_modified_date) values (3, 3, 5000, CURRENT_TIMESTAMP);