DROP TABLE IF EXISTS USERS;
CREATE TABLE USERS (
                       UserId      INTEGER PRIMARY KEY AUTOINCREMENT ,
                       Email       VARCHAR(20),
                       Password    VARCHAR(20),
                       Genre       VARCHAR(20)
);

INSERT INTO USERS (Email, Password, Genre) VALUES ('davey@uts.com', '123', 'Kpop');
INSERT INTO USERS (Email, Password, Genre) VALUES ('jenny@gmail.com', '12345', 'Hardstyle');

DROP TABLE IF EXISTS ALBUMS;
CREATE TABLE ALBUMS (
                        AlbumId     INTEGER PRIMARY KEY AUTOINCREMENT ,
                        Artist      VARCHAR(20),
                        Title       VARCHAR(20)
);
INSERT INTO ALBUMS (Artist, Title) VALUES ('TWICE', 'Ready To Be');
INSERT INTO ALBUMS (Artist, Title) VALUES ('WJSN', 'Last Sequence');
INSERT INTO ALBUMS (Artist, Title) VALUES ('Angerfist', 'Diabolic Dice');
INSERT INTO ALBUMS (Artist, Title) VALUES ('Phuture Noize', 'Circles & Squares');
INSERT INTO ALBUMS (Artist, Title) VALUES ('TWICE', 'Between 1&2');
INSERT INTO ALBUMS (Artist, Title) VALUES ('Angerfist', 'Deadfaced Dimension');
INSERT INTO ALBUMS (Artist, Title) VALUES ('WJSN', 'Neverland');
INSERT INTO ALBUMS (Artist, Title) VALUES ('TWICE', 'Set Me Free');

DROP TABLE IF EXISTS INVOICES;
CREATE TABLE INVOICES (
                          InvoiceId   INTEGER PRIMARY KEY AUTOINCREMENT ,
                          UserId      INTEGER,
                          AlbumId     INTEGER,
                          CONSTRAINT UserFK
                              FOREIGN KEY (UserId)
                                  REFERENCES USERS(UserId),
                          CONSTRAINT AlbumFK
                              FOREIGN KEY (AlbumId)
                                  REFERENCES ALBUMS(AlbumId)
);

INSERT INTO INVOICES (UserId, AlbumId) VALUES (1, 1);
INSERT INTO INVOICES (UserId, AlbumId) VALUES (1, 2);
INSERT INTO INVOICES (UserId, AlbumId) VALUES (1, 3);
INSERT INTO INVOICES (UserId, AlbumId) VALUES (2, 3);
INSERT INTO INVOICES (UserId, AlbumId) VALUES (2, 4);