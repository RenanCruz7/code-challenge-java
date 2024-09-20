CREATE TABLE tasks (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       title VARCHAR(100) NOT NULL,
                       description VARCHAR(500) NOT NULL,
                       done BOOLEAN NOT NULL DEFAULT FALSE,
                       favorite BOOLEAN NOT NULL DEFAULT FALSE,
                       color VARCHAR(7) NOT NULL,
                       created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);