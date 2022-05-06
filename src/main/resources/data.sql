# ROLES
INSERT INTO roles(creationDateTime, updateDateTime, name) VALUE (NOW(),NOW(),'ADMIN');
INSERT INTO roles(creationDateTime, updateDateTime, name) VALUE (NOW(),NOW(),'USER');
INSERT INTO roles(creationDateTime, updateDateTime, name) VALUE (NOW(),NOW(),'GUEST');

# CATEGORIES
INSERT INTO categories(creationDateTime, updateDateTime, name) VALUE (NOW(),NOW(),'front-end');
INSERT INTO categories(creationDateTime, updateDateTime, name) VALUE (NOW(),NOW(),'back-end');

# DEPARTMENTS
INSERT INTO departments(creationDateTime, updateDateTime, name) VALUE (NOW(),NOW(),'managers');
INSERT INTO departments(creationDateTime, updateDateTime, name) VALUE (NOW(),NOW(),'developers');

# PRIORITIES
INSERT INTO priorities(creationDateTime, updateDateTime, name) VALUE (NOW(),NOW(),'HIGH');
INSERT INTO priorities(creationDateTime, updateDateTime, name) VALUE (NOW(),NOW(),'NORMAL');
INSERT INTO priorities(creationDateTime, updateDateTime, name) VALUE (NOW(),NOW(),'LOW');

# STATUSES
INSERT INTO statuses(creationDateTime, updateDateTime, name) VALUE (NOW(),NOW(),'NEW');
INSERT INTO statuses(creationDateTime, updateDateTime, name) VALUE (NOW(),NOW(),'TO_DO');
INSERT INTO statuses(creationDateTime, updateDateTime, name) VALUE (NOW(),NOW(),'IN_PROGRESS');
INSERT INTO statuses(creationDateTime, updateDateTime, name) VALUE (NOW(),NOW(),'DONE');
INSERT INTO statuses(creationDateTime, updateDateTime, name) VALUE (NOW(),NOW(),'CLOSE');


# USERS
INSERT INTO users(creationDateTime, updateDateTime, username, password, email, firstName, lastName, department_id) VALUE (NOW(), NOW(), 'user', '$2a$12$Kh8lJ69CilLhT6paLNP46.gYRp95KtW80t99L9XJki0THpiUCQOSG', 'user@gmail.com', 'user', 'user', 2);
INSERT INTO users_roles(user_id, role_id) VALUE (1,2);
INSERT INTO members(user_id, project_id) VALUE (1,1);
INSERT INTO users(creationDateTime, updateDateTime, username, password, email, firstName, lastName, department_id) VALUE (NOW(), NOW(), 'user2', '$2a$12$Kh8lJ69CilLhT6paLNP46.gYRp95KtW80t99L9XJki0THpiUCQOSG', 'user2@gmail.com', 'user2', 'user2', 2);
INSERT INTO users_roles(user_id, role_id) VALUE (1,2);
INSERT INTO members(user_id, project_id) VALUE (2,1);
INSERT INTO users(creationDateTime, updateDateTime, username, password, email, firstName, lastName, department_id) VALUE (NOW(), NOW(), 'admin', '$2a$12$Yeu9s3uMxRx/k4KUjTtnEe7RZFGmuBw6iaAPHiC8CzF31cIGbDJFa', 'admin@gmail.com', 'admin', 'admin', 1);
INSERT INTO users_roles(user_id, role_id) VALUE (2,1);
INSERT INTO members(user_id, project_id) VALUE (3,1);

# PROJECTS
INSERT INTO projects(creationDateTime, updateDateTime, name, description, creator_id) VALUE (NOW(), NOW(), 'PMP', 'Project management program', 3);

# TASKS
INSERT INTO tasks(creationDateTime, updateDateTime, creator_id, executor_id, category_id, department_id, status_id, name, description, priority_id, time, time_left, start_date) VALUE (NOW(), NOW(), 3, 1, 1, 2, 1, 'front-end', 'create front-enf for PMP', 2, 20, 20, 2022-06-15);
INSERT INTO tasks(creationDateTime, updateDateTime, creator_id, executor_id, category_id, department_id, status_id, name, description, priority_id, time, time_left, start_date) VALUE (NOW(), NOW(), 3, 2, 2, 2, 2, 'back-end', 'create back-end for PMP', 3, 24, 24, 2022-05-25);



