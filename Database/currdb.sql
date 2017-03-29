--
-- File generated with SQLiteStudio v3.1.1 on Fri Mar 24 11:44:22 2017
--
-- Text encoding used: UTF-8
--
PRAGMA foreign_keys = off;
BEGIN TRANSACTION;

-- Table: Conversation
CREATE TABLE Conversation (c_ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, u_One INT (11) NOT NULL REFERENCES Users (User_ID), u_Two INT (11) REFERENCES Users (User_ID) NOT NULL, time INT (11) DEFAULT NULL);

-- Table: Deleted_Users_Log
CREATE TABLE Deleted_Users_Log (u_ID INT (11) NOT NULL PRIMARY KEY UNIQUE, Username VARCHAR (30) NOT NULL UNIQUE, Password VARCHAR (50) NOT NULL, Email VARCHAR (100) NOT NULL);

-- Table: Reply
CREATE TABLE Reply (r_ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, reply TEXT NOT NULL, user_fk_ID INT (11) REFERENCES Users (User_ID) NOT NULL, c_fk_ID INT (11) REFERENCES Conversation (c_ID) NOT NULL, time INT (11) DEFAULT NULL);

-- Table: Users
CREATE TABLE Users (User_ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL , Username VARCHAR (30) NOT NULL UNIQUE, Password VARCHAR (50) NOT NULL, Email VARCHAR (100) NOT NULL);

INSERT INTO Users(Username, Password, Email) values('chicken', 'chickenfingersyum', 'chick@baked.com');
INSERT INTO Users(Username, Password, Email) values('lettuce', 'CABAGES!!!!!', 'let@us.com');

-- Trigger: User_Delete
CREATE TRIGGER User_Delete AFTER DELETE ON Users FOR EACH ROW BEGIN INSERT INTO Deleted_Users_Log SELECT * FROM Users; END;

COMMIT TRANSACTION;
PRAGMA foreign_keys = on;
