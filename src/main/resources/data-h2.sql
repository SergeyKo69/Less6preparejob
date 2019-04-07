INSERT INTO UserEntity (id, name, login, password, eMail) VALUES ('1', 'Administrator', 'Admin', '123','');

INSERT INTO RoleEntity (id, name) VALUES ('1', 'Administrator'), ('2', 'User');

INSERT INTO UserRoleEntity (id, userId, roleId) VALUES ('1', '1', '1');