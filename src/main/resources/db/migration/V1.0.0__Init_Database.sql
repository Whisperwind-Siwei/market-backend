CREATE TABLE customer
(
    id            BIGSERIAL PRIMARY KEY,
    code          VARCHAR(8)               NOT NULL,
    name          VARCHAR(30)              NOT NULL,
    gender        VARCHAR(8)               NOT NULL,
    is_active     BOOLEAN                  NOT NULL DEFAULT TRUE,
    created_at    TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW(),
    updated_at    TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW()
);

CREATE TABLE commodity
(
    id            BIGSERIAL PRIMARY KEY,
    name          VARCHAR(30)              NOT NULL,
    position_id   BIGINT,
    procedure     INT                      NOT NULL,
    inventory     INT                      NOT NULL,
    unit_id       BIGINT                   NOT NULL,
    description   VARCHAR(255),
    type_id       INT                      NOT NULL,
    is_active     BOOLEAN                  NOT NULL DEFAULT TRUE,
    created_at    TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW(),
    updated_at    TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW()
);

CREATE TABLE unit
(
    id            BIGSERIAL PRIMARY KEY,
    name          VARCHAR(30)              NOT NULL,
    is_active     BOOLEAN                  NOT NULL DEFAULT TRUE,
    created_at    TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW(),
    updated_at    TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW()
);

CREATE TABLE position
(
    id            BIGSERIAL PRIMARY KEY,
    name          VARCHAR(30)              NOT NULL,
    is_active     BOOLEAN                  NOT NULL DEFAULT TRUE,
    created_at    TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW(),
    updated_at    TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW()
);

CREATE TABLE record
(
    id            BIGSERIAL PRIMARY KEY,
    customer_id       BIGINT                   NOT NULL,
    commodity_id  BIGINT                   NOT NULL,
    quantity      INT                      NOT NULL,
    total_price   BIGINT                   NOT NULL,
    degree        INT,
    is_active     BOOLEAN                  NOT NULL DEFAULT TRUE,
    created_at    TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW(),
    updated_at    TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW()
);

CREATE TABLE factor
(
    id            BIGSERIAL PRIMARY KEY,
    name          VARCHAR(30)              NOT NULL,
    is_active     BOOLEAN                  NOT NULL DEFAULT TRUE,
    created_at    TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW(),
    updated_at    TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW()
);

CREATE TABLE customer_factor
(
    id            BIGSERIAL PRIMARY KEY,
    customer_id       BIGINT                   NOT NULL,
    factor_id     BIGINT                   NOT NULL,
    degree        INT,
    is_active     BOOLEAN                  NOT NULL DEFAULT TRUE,
    created_at    TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW(),
    updated_at    TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW(),
    UNIQUE (customer_id, factor_id)
);

CREATE TABLE commodity_factor
(
    id            BIGSERIAL PRIMARY KEY,
    commodity_id  BIGINT                   NOT NULL,
    factor_id     BIGINT                   NOT NULL,
    degree        INT,
    is_active     BOOLEAN                  NOT NULL DEFAULT TRUE,
    created_at    TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW(),
    updated_at    TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW(),
    UNIQUE (commodity_id, factor_id)
);