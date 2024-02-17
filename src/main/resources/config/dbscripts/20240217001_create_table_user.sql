CREATE TABLE IF NOT EXISTS ai_painter.registered_user (
    email VARCHAR(100) NOT NULL,
    name VARCHAR(100) NOT NULL,
    picture_url VARCHAR(2000),
    admin BOOLEAN NOT NULL DEFAULT 0,
    suspended BOOLEAN NOT NULL DEFAULT 0,
    PRIMARY KEY (email),
    INDEX idx(email)
);