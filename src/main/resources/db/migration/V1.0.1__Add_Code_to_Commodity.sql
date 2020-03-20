ALTER TABLE commodity
    ADD COLUMN code VARCHAR(8) NOT NULL;
ALTER TABLE commodity
    RENAME procedure to price;