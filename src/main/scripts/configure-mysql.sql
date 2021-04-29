--Create Databases
CREATE DATABASE rec_dev;
CREATE DATABASE rec_prod;

--Create database service accounts
CREATE USER 'rec_dev_user'@'localhost' IDENTIFIED BY 'dev-pass';
CREATE USER 'rec_prod_user'@'localhost' IDENTIFIED BY 'prod-pass';

--Database grants
GRANT SELECT ON rec_dev.* TO 'rec_dev_user'@'localhost';
GRANT INSERT ON rec_dev.* TO 'rec_dev_user'@'localhost';
GRANT DELETE ON rec_dev.* TO 'rec_dev_user'@'localhost';
GRANT UPDATE ON rec_dev.* TO 'rec_dev_user'@'localhost';

GRANT SELECT ON rec_prod.* TO 'rec_prod_user'@'localhost';
GRANT INSERT ON rec_prod.* TO 'rec_prod_user'@'localhost';
GRANT DELETE ON rec_prod.* TO 'rec_prod_user'@'localhost';
GRANT UPDATE ON rec_prod.* TO 'rec_prod_user'@'localhost';