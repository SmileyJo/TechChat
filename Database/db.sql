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

-- Table: Message
-- I don't personally think that reply should
-- be used used for messages, but for the auto
-- response later (-dane)
CREATE TABLE Message(
	id	int(11) 	NOT NULL
				AUTO_INCREMENT
				PRIMARY KEY,
	U_From	int(11)		not NULL 
				references Users(u_id),
	U_To	int(11) 	not NULL 
				References Users(u_id),
	content	varchar(255) 	not NULL
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


-- Triggee: Update Message Table
-- TODO


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
