CREATE TABLE IF NOT EXISTS ai_painter.authenticated_user (
    email VARCHAR(100) NOT NULL,
    login_expiry_epoch TIMESTAMP NOT NULL,
    login_epoch TIMESTAMP NOT NULL,
    PRIMARY KEY (email),
    INDEX idx(email)
);