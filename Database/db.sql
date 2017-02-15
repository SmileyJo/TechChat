--
-- File generated with SQLiteStudio v3.1.1 on Wed Feb 15 11:23:48 2017
--
-- Text encoding used: UTF-8
--
PRAGMA foreign_keys = off;
BEGIN TRANSACTION;

-- Table: Conversation
CREATE TABLE Conversation (c_ID INTEGER PRIMARY KEY NOT NULL, u_One INT (11) NOT NULL REFERENCES Users (User_ID), u_Two INT (11) REFERENCES Users (User_ID) NOT NULL, time INT (11) DEFAULT NULL, ip VARCHAR (30) DEFAULT NULL);

-- Table: Reply
CREATE TABLE Reply (r_ID INT (11) PRIMARY KEY NOT NULL, reply TEXT, user_fk_ID INT (11) REFERENCES Users (User_ID) NOT NULL, c_fk_ID INT (11) REFERENCES Conversation (c_ID) NOT NULL, ip VARCHAR (30) DEFAULT NULL, time INT (11) DEFAULT NULL);

-- Table: Users
CREATE TABLE Users (User_ID INT (11) PRIMARY KEY NOT NULL, Username VARCHAR (30) NOT NULL UNIQUE, Password VARCHAR (50) NOT NULL, Email VARCHAR (100) NOT NULL);

COMMIT TRANSACTION;
PRAGMA foreign_keys = on;
