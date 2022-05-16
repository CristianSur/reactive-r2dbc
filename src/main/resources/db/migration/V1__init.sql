CREATE TABLE IF NOT EXISTS operator
(
    id         SERIAL PRIMARY KEY,
    first_name VARCHAR(20),
    last_name  VARCHAR(20)
);
--
CREATE TABLE IF NOT EXISTS currency
(
    id   SERIAL PRIMARY KEY,
    code VARCHAR(3),
    name VARCHAR(20)
);
--
CREATE TABLE IF NOT EXISTS cash
(
    id                 SERIAL PRIMARY KEY,
    operator_id        INT NOT NULL,
    currency_id        INT NOT NULL,
    FOREIGN KEY (operator_id) REFERENCES operator (id),
    FOREIGN KEY (currency_id) REFERENCES currency (id),
    amount             DOUBLE PRECISION,
    last_modified_date timestamp
);
--
CREATE TABLE IF NOT EXISTS exchanger
(
    id          SERIAL PRIMARY KEY,
    operator_id INT NOT NULL,
    currency_id_received INT NOT NULL,
    currency_id_withdrawn INT NOT NULL,
    FOREIGN KEY (currency_id_received) REFERENCES currency (id),
    FOREIGN KEY (currency_id_withdrawn) REFERENCES currency (id),
    FOREIGN KEY (operator_id) REFERENCES operator (id),
    rate        DOUBLE PRECISION,
    received    DOUBLE PRECISION,
    withdrawn   DOUBLE PRECISION,
    date        timestamp default current_timestamp NOT NULL
);
--
CREATE TABLE IF NOT EXISTS exchange_rate
(
    id          SERIAL PRIMARY KEY,
    currency_id INT NOT NULL,
    FOREIGN KEY (currency_id) REFERENCES currency (id),
    nominal     INT,
    rate        DOUBLE PRECISION,
    date        timestamp default current_timestamp NOT NULL
);

