CREATE TABLE exchange_rate
(
    id          integer,
    code        char(3),
    description varchar(500),
    country     varchar(500),
    rate        decimal(20,10),
    enabled     boolean,
    PRIMARY KEY (id)
);
