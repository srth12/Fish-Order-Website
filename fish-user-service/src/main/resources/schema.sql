CREATE TABLE USER(
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  NAME VARCHAR(16) NOT NULL,
  BALANCE INTEGER NOT NULL UNIQUE
);