PRAGMA foreign_keys = off;
BEGIN TRANSACTION;

-- Table: Conversation
CREATE TABLE Conversation (
    c_ID  INTEGER      PRIMARY KEY
                       NOT NULL,
    u_One INT (11)     NOT NULL
                       REFERENCES Users (User_ID),
    u_Two INT (11)     REFERENCES Users (User_ID) 
                       NOT NULL,
    time  INT (11)     DEFAULT NULL,
    ip    VARCHAR (30) DEFAULT NULL
);


-- Table: Deleted_Users_Log
CREATE TABLE Deleted_Users_Log (
    u_ID     INT (11)      NOT NULL
                           PRIMARY KEY,
    Username VARCHAR (30)  NOT NULL
                           UNIQUE,
    Password VARCHAR (50)  NOT NULL,
    Email    VARCHAR (100) NOT NULL
);


-- Table: Reply
CREATE TABLE Reply (
    r_ID       INT (11)     PRIMARY KEY
                            NOT NULL,
    reply      TEXT,
    user_fk_ID INT (11)     REFERENCES Users (User_ID) 
                            NOT NULL,
    c_fk_ID    INT (11)     REFERENCES Conversation (c_ID) 
                            NOT NULL,
    ip         VARCHAR (30) DEFAULT NULL,
    time       INT (11)     DEFAULT NULL
);


-- Table: Users
CREATE TABLE Users (
    User_ID  INT (11)      PRIMARY KEY
                           NOT NULL,
    Username VARCHAR (30)  NOT NULL
                           UNIQUE,
    Password VARCHAR (50)  NOT NULL,
    Email    VARCHAR (100) NOT NULL
);


-- Trigger: User_Add
CREATE TRIGGER User_Add
         AFTER INSERT
            ON Users
      FOR EACH ROW
BEGIN
    INSERT INTO Users VALUES (
                          Old.main
                      );
END;


-- Trigger: User_Delete
CREATE TRIGGER User_Delete
         AFTER DELETE
            ON Users
      FOR EACH ROW
BEGIN
    INSERT INTO Deleted_Users_Log VALUES (
                                      Old.main
                                  );
END;


COMMIT TRANSACTION;
PRAGMA foreign_keys = on;
