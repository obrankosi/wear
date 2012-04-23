CREATE TABLE users (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    username varchar(90) NOT NULL,
    password varchar(90) NOT NULL,
    role varchar(20) NOT NULL,  
    UNIQUE KEY(username)
);

