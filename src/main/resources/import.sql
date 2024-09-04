INSERT INTO roles (name) VALUES ("ROLE_ADMIN");
INSERT INTO roles (name) VALUES ("ROLE_USER");

INSERT INTO permissions (name) VALUES ('Create Survey');
INSERT INTO permissions (name) VALUES ('Read Surveys');
INSERT INTO permissions (name) VALUES ('Update Survey');
INSERT INTO permissions (name) VALUES ('Delete Survey');
INSERT INTO permissions (name) VALUES ('Create Chapter');
INSERT INTO permissions (name) VALUES ('Read Chapters');
INSERT INTO permissions (name) VALUES ('Update Chapter');
INSERT INTO permissions (name) VALUES ('Delete Chapter');
INSERT INTO permissions (name) VALUES ('Create Question');
INSERT INTO permissions (name) VALUES ('Read Questions');
INSERT INTO permissions (name) VALUES ('Update Question');
INSERT INTO permissions (name) VALUES ('Delete Question');
INSERT INTO permissions (name) VALUES ('Create Response Option');
INSERT INTO permissions (name) VALUES ('Read Response Options');
INSERT INTO permissions (name) VALUES ('Update Response Option');
INSERT INTO permissions (name) VALUES ('Delete Response Option');
INSERT INTO permissions (name) VALUES ('User Authentication and Authorization');
INSERT INTO permissions (name) VALUES ('Create New Survey');
INSERT INTO permissions (name) VALUES ('Edit Survey Details');
INSERT INTO permissions (name) VALUES ('Publish Survey');
INSERT INTO permissions (name) VALUES ('User Login');
INSERT INTO permissions (name) VALUES ('User Logout');

-- Permissions for Admin (role_id = 1)
INSERT INTO role_permissions (permission_id, role_id) VALUES (1, 1); -- Create Survey
INSERT INTO role_permissions (permission_id, role_id) VALUES (2, 1); -- Read Surveys
INSERT INTO role_permissions (permission_id, role_id) VALUES (3, 1); -- Update Survey
INSERT INTO role_permissions (permission_id, role_id) VALUES (4, 1); -- Delete Survey
INSERT INTO role_permissions (permission_id, role_id) VALUES (5, 1); -- Create Chapter
INSERT INTO role_permissions (permission_id, role_id) VALUES (6, 1); -- Read Chapters
INSERT INTO role_permissions (permission_id, role_id) VALUES (7, 1); -- Update Chapter
INSERT INTO role_permissions (permission_id, role_id) VALUES (8, 1); -- Delete Chapter
INSERT INTO role_permissions (permission_id, role_id) VALUES (9, 1); -- Create Question
INSERT INTO role_permissions (permission_id, role_id) VALUES (10, 1); -- Read Questions
INSERT INTO role_permissions (permission_id, role_id) VALUES (11, 1); -- Update Question
INSERT INTO role_permissions (permission_id, role_id) VALUES (12, 1); -- Delete Question
INSERT INTO role_permissions (permission_id, role_id) VALUES (13, 1); -- Create Response Option
INSERT INTO role_permissions (permission_id, role_id) VALUES (14, 1); -- Read Response Options
INSERT INTO role_permissions (permission_id, role_id) VALUES (15, 1); -- Update Response Option
INSERT INTO role_permissions (permission_id, role_id) VALUES (16, 1); -- Delete Response Option
INSERT INTO role_permissions (permission_id, role_id) VALUES (17, 1); -- User Authentication and Authorization
INSERT INTO role_permissions (permission_id, role_id) VALUES (18, 1); -- Create New Survey
INSERT INTO role_permissions (permission_id, role_id) VALUES (19, 1); -- Edit Survey Details
INSERT INTO role_permissions (permission_id, role_id) VALUES (20, 1); -- Publish Survey
INSERT INTO role_permissions (permission_id, role_id) VALUES (21, 1); -- User Login
INSERT INTO role_permissions (permission_id, role_id) VALUES (22, 1); -- User Logout

-- Permissions for User (role_id = 2)
INSERT INTO role_permissions (permission_id, role_id) VALUES (2, 2); -- Read Surveys
INSERT INTO role_permissions (permission_id, role_id) VALUES (6, 2); -- Read Chapters
INSERT INTO role_permissions (permission_id, role_id) VALUES (10, 2); -- Read Questions
INSERT INTO role_permissions (permission_id, role_id) VALUES (14, 2); -- Read Response Options
INSERT INTO role_permissions (permission_id, role_id) VALUES (17, 2); -- User Authentication and Authorization
INSERT INTO role_permissions (permission_id, role_id) VALUES (21, 2); -- User Login
INSERT INTO role_permissions (permission_id, role_id) VALUES (22, 2); -- User Logout

-- Creating the admin user
INSERT INTO users (account_no_expired, account_no_locked, credential_no_expired, is_enabled, password, username) VALUES (b'1', b'1', b'1', b'1', '$2a$10$7eTUu6pEZl7XpX8IZFY.zOzJ2nOoJWsjwOMCFsHrpEdBJtQUnsm4O', 'admin@example.com');

-- Creating the standard user
INSERT INTO users (account_no_expired, account_no_locked, credential_no_expired, is_enabled, password, username) VALUES (b'1', b'1', b'1', b'1', '$2a$10$1i30oeV9SPD.Mp6JgVo3n.Gpx6.fyLFseSiLo3dZ6sNpS3eZt1ohe', 'user@example.com');

-- Assigning the admin role to the admin user
INSERT INTO users_roles (role_id, user_id) VALUES (1, 1); -- role_id 1 is for admin

-- Assigning the user role to the standard user
INSERT INTO users_roles (role_id, user_id) VALUES (2, 2); -- role_id 2 is for user

