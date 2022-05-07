-- # ROLES
INSERT INTO roles(creation_date_time, update_date_time, name) VALUE (NOW(),NOW(),'ADMIN');
INSERT INTO roles(creation_date_time, update_date_time, name) VALUE (NOW(),NOW(),'USER');
INSERT INTO roles(creation_date_time, update_date_time, name) VALUE (NOW(),NOW(),'GUEST');

-- # CATEGORIES
INSERT INTO categories(creation_date_time, update_date_time, name) VALUE (NOW(),NOW(),'front-end');
INSERT INTO categories(creation_date_time, update_date_time, name) VALUE (NOW(),NOW(),'back-end');

-- # DEPARTMENTS
INSERT INTO departments(creation_date_time, update_date_time, name) VALUE (NOW(),NOW(),'managers');
INSERT INTO departments(creation_date_time, update_date_time, name) VALUE (NOW(),NOW(),'developers');

-- # PRIORITIES
INSERT INTO priorities(creation_date_time, update_date_time, name) VALUE (NOW(),NOW(),'HIGH');
INSERT INTO priorities(creation_date_time, update_date_time, name) VALUE (NOW(),NOW(),'NORMAL');
INSERT INTO priorities(creation_date_time, update_date_time, name) VALUE (NOW(),NOW(),'LOW');

-- # STATUSES
INSERT INTO statuses(creation_date_time, update_date_time, name) VALUE (NOW(),NOW(),'NEW');
INSERT INTO statuses(creation_date_time, update_date_time, name) VALUE (NOW(),NOW(),'TO_DO');
INSERT INTO statuses(creation_date_time, update_date_time, name) VALUE (NOW(),NOW(),'IN_PROGRESS');
INSERT INTO statuses(creation_date_time, update_date_time, name) VALUE (NOW(),NOW(),'DONE');
INSERT INTO statuses(creation_date_time, update_date_time, name) VALUE (NOW(),NOW(),'CLOSE');


-- # USERS
INSERT INTO users(creation_date_time, update_date_time, username, password, email, first_name, last_name, department_id) VALUE (NOW(), NOW(), 'user', 'dXNlcg==', 'user@gmail.com', 'user', 'user', 2);
INSERT INTO users(creation_date_time, update_date_time, username, password, email, first_name, last_name, department_id) VALUE (NOW(), NOW(), 'user2', 'dXNlcg==', 'user2@gmail.com', 'user2', 'user2', 2);
INSERT INTO users(creation_date_time, update_date_time, username, password, email, first_name, last_name, department_id) VALUE (NOW(), NOW(), 'admin', 'YWRtaW4=', 'admin@gmail.com', 'admin', 'admin', 1);
INSERT INTO roles_users(creation_date_time, update_date_time, user_id, role_id) VALUE (NOW(),NOW(),1,2);
INSERT INTO roles_users(creation_date_time, update_date_time, user_id, role_id) VALUE (NOW(),NOW(),1,2);
INSERT INTO roles_users(creation_date_time, update_date_time, user_id, role_id) VALUE (NOW(),NOW(),2,1);
INSERT INTO members(creation_date_time, update_date_time,user_id, project_id) VALUE (NOW(),NOW(),4,2);
INSERT INTO members(creation_date_time, update_date_time,user_id, project_id) VALUE (NOW(),NOW(),3,2);
INSERT INTO members(creation_date_time, update_date_time, user_id, project_id) VALUE (NOW(),NOW(),2,2);

-- # PROJECTS
INSERT INTO projects(creation_date_time, update_date_time, name, description, creator_id) VALUE (NOW(), NOW(), 'PMP', 'Project management program', 3);

-- # TASKS
INSERT INTO tasks(creation_date_time, update_date_time, creator_id, executor_id, category_id, department_id, status_id, name, description, priority_id, time, time_left, start_date, projects_id) VALUE (NOW(), NOW(), 3, 1, 1, 2, 1, 'front-end', 'create front-enf for PMP', 2, 120, 120, NOW(), 1);
INSERT INTO tasks(creation_date_time, update_date_time, creator_id, executor_id, category_id, department_id, status_id, name, description, priority_id, time, time_left, start_date, projects_id) VALUE (NOW(), NOW(), 3, 2, 2, 2, 2, 'back-end', 'create back-end for PMP', 3, 124, 124, NOW(), 1);

-- #WORK_TIMES
INSERT INTO work_times(creation_date_time, update_date_time, task_id, name, description, time, date) VALUE (NOW(), NOW(), 1, 'index.html', 'create user index.html', 8, NOW());
INSERT INTO work_times(creation_date_time, update_date_time, task_id, name, description, time, date) VALUE (NOW(), NOW(), 1, 'reg.html, login.html', 'create user index.html', 8, NOW());
INSERT INTO work_times(creation_date_time, update_date_time, task_id, name, description, time, date) VALUE (NOW(), NOW(), 2, 'entities, repositories', 'create entities, DTO', 8, NOW());
INSERT INTO work_times(creation_date_time, update_date_time, task_id, name, description, time, date) VALUE (NOW(), NOW(), 2, 'service', 'create services', 8, NOW());

