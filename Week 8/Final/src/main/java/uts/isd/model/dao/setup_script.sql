DROP TABLE USERS;
CREATE TABLE USERS
(
    UserId      INTEGER PRIMARY KEY AUTOINCREMENT ,
    Email       varchar(30),
    Password    varchar(30),
    Genre       varchar(30)
);

INSERT INTO USERS (Email, Password, Genre) VALUES ('daveyd@uts.com', '123', 'Kpop');
INSERT INTO USERS (Email, Password, Genre) VALUES ('jenny@usyd.com', '1234', 'Hardstyle');

SELECT * FROM USERS;