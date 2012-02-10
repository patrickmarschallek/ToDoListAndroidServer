CREATE TABLE Todo_Contact (todoId int(10) NOT NULL, contactId int(10) NOT NULL, PRIMARY KEY (todoId, contactId));
CREATE TABLE Contact (id int(10) NOT NULL AUTO_INCREMENT, contactId int(10) NOT NULL, PRIMARY KEY (id));
CREATE TABLE `User` (username varchar(255) NOT NULL UNIQUE, password varchar(255) NOT NULL, id int(10) NOT NULL AUTO_INCREMENT, PRIMARY KEY (id));
CREATE TABLE Todo (id int(10) NOT NULL AUTO_INCREMENT, name varchar(255) NOT NULL, description varchar(255) NOT NULL, finished tinyint NOT NULL, favourite tinyint NOT NULL, expire date NOT NULL,lastChange date NOT NULL, userId int(10) NOT NULL, PRIMARY KEY (id), INDEX (name));
ALTER TABLE Todo_Contact ADD INDEX FKTodo_Conta23185 (todoId), ADD CONSTRAINT FKTodo_Conta23185 FOREIGN KEY (todoId) REFERENCES Todo (id);
ALTER TABLE Todo_Contact ADD INDEX FKTodo_Conta64317 (contactId), ADD CONSTRAINT FKTodo_Conta64317 FOREIGN KEY (contactId) REFERENCES Contact (id);
ALTER TABLE Todo ADD INDEX FKTodo902816 (userId), ADD CONSTRAINT FKTodo902816 FOREIGN KEY (userId) REFERENCES `User` (id);
