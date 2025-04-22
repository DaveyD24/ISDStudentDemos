DROP TABLE IF EXISTS USERS;
CREATE TABLE USERS (
                       UserId      INTEGER PRIMARY KEY AUTOINCREMENT ,
                       Email       VARCHAR(20),
                       Password    VARCHAR(20),
                       Genre       VARCHAR(20)
);

INSERT INTO USERS (Email, Password, Genre) VALUES ('davey@uts.com', '123', 'Kpop');
INSERT INTO USERS (Email, Password, Genre) VALUES ('jenny@gmail.com', '12345', 'Hardstyle');

SELECT * FROM USERS;