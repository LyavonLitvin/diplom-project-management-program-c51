-- # ROLES
INSERT INTO roles(creationDateTime, updateDateTime, name) VALUE (NOW(),NOW(),'ADMIN');
INSERT INTO roles(creationDateTime, updateDateTime, name) VALUE (NOW(),NOW(),'USER');
INSERT INTO roles(creationDateTime, updateDateTime, name) VALUE (NOW(),NOW(),'GUEST');

-- # CATEGORIES
INSERT INTO categories(creationDateTime, updateDateTime, name) VALUE (NOW(),NOW(),'front-end');
INSERT INTO categories(creationDateTime, updateDateTime, name) VALUE (NOW(),NOW(),'back-end');

-- # DEPARTMENTS
INSERT INTO departments(creationDateTime, updateDateTime, name) VALUE (NOW(),NOW(),'managers');
INSERT INTO departments(creationDateTime, updateDateTime, name) VALUE (NOW(),NOW(),'developers');

-- # PRIORITIES
INSERT INTO priorities(creationDateTime, updateDateTime, name) VALUE (NOW(),NOW(),'HIGH');
INSERT INTO priorities(creationDateTime, updateDateTime, name) VALUE (NOW(),NOW(),'NORMAL');
INSERT INTO priorities(creationDateTime, updateDateTime, name) VALUE (NOW(),NOW(),'LOW');

-- # STATUSES
INSERT INTO statuses(creationDateTime, updateDateTime, name) VALUE (NOW(),NOW(),'NEW');
INSERT INTO statuses(creationDateTime, updateDateTime, name) VALUE (NOW(),NOW(),'TO_DO');
INSERT INTO statuses(creationDateTime, updateDateTime, name) VALUE (NOW(),NOW(),'IN_PROGRESS');
INSERT INTO statuses(creationDateTime, updateDateTime, name) VALUE (NOW(),NOW(),'DONE');
INSERT INTO statuses(creationDateTime, updateDateTime, name) VALUE (NOW(),NOW(),'CLOSE');


-- # USERS
INSERT INTO users(creationDateTime, updateDateTime, username, password, email, firstName, lastName, department_id) VALUE (NOW(), NOW(), 'user', 'dXNlcg==', 'user@gmail.com', 'user', 'user', 2);
INSERT INTO users_roles(user_id, role_id) VALUE (1,2);
INSERT INTO members(user_id, project_id) VALUE (1,1);
INSERT INTO users(creationDateTime, updateDateTime, username, password, email, firstName, lastName, department_id) VALUE (NOW(), NOW(), 'user2', 'dXNlcg==', 'user2@gmail.com', 'user2', 'user2', 2);
INSERT INTO users_roles(user_id, role_id) VALUE (1,2);
INSERT INTO members(user_id, project_id) VALUE (2,1);
INSERT INTO users(creationDateTime, updateDateTime, username, password, email, firstName, lastName, department_id) VALUE (NOW(), NOW(), 'admin', 'YWRtaW4=', 'admin@gmail.com', 'admin', 'admin', 1);
INSERT INTO users_roles(user_id, role_id) VALUE (2,1);
INSERT INTO members(user_id, project_id) VALUE (3,1);

-- # PROJECTS
INSERT INTO projects(creationDateTime, updateDateTime, name, description, creator_id) VALUE (NOW(), NOW(), 'PMP', 'Project management program', 3);

-- # TASKS
INSERT INTO tasks(creationDateTime, updateDateTime, creator_id, executor_id, category_id, department_id, status_id, name, description, priority_id, time, time_left, start_date) VALUE (NOW(), NOW(), 3, 1, 1, 2, 1, 'front-end', 'create front-enf for PMP', 2, 120, 120, 2022-06-15);
INSERT INTO tasks(creationDateTime, updateDateTime, creator_id, executor_id, category_id, department_id, status_id, name, description, priority_id, time, time_left, start_date) VALUE (NOW(), NOW(), 3, 2, 2, 2, 2, 'back-end', 'create back-end for PMP', 3, 124, 124, 2022-05-25);

-- #WORK_TIMES
INSERT INTO work_times(creationDateTime, updateDateTime, task_id, name, description, time, date) VALUE (NOW(), NOW(), 1, 'index.html', 'create user index.html', 8, NOW());
INSERT INTO work_times(creationDateTime, updateDateTime, task_id, name, description, time, date) VALUE (NOW(), NOW(), 1, 'reg.html, login.html', 'create user index.html', 8, NOW());
INSERT INTO work_times(creationDateTime, updateDateTime, task_id, name, description, time, date) VALUE (NOW(), NOW(), 2, 'entities, repositories', 'create entities, DTO', 8, NOW());
INSERT INTO work_times(creationDateTime, updateDateTime, task_id, name, description, time, date) VALUE (NOW(), NOW(), 2, 'service', 'create services', 8, NOW());

