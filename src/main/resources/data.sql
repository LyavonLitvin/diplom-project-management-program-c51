-- # ROLES
INSERT INTO roles(creation_date_time, update_date_time, name) VALUE (NOW(),NOW(),'USER');
INSERT INTO roles(creation_date_time, update_date_time, name) VALUE (NOW(),NOW(),'GUEST');
INSERT INTO roles(creation_date_time, update_date_time, name) VALUE (NOW(),NOW(),'ADMIN');

-- # CATEGORIES
INSERT INTO categories(creation_date_time, update_date_time, name) VALUE (NOW(),NOW(),'front-end');
INSERT INTO categories(creation_date_time, update_date_time, name) VALUE (NOW(),NOW(),'back-end');



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
INSERT INTO users(creation_date_time, update_date_time, username, password, email, first_name, last_name) VALUE (NOW(), NOW(), 'user', 'dXNlcg==', 'user@gmail.com', 'user', 'user');
INSERT INTO users(creation_date_time, update_date_time, username, password, email, first_name, last_name) VALUE (NOW(), NOW(), 'user2', 'dXNlcg==', 'user2@gmail.com', 'user2', 'user2');
INSERT INTO users(creation_date_time, update_date_time, username, password, email, first_name, last_name) VALUE (NOW(), NOW(), 'admin', 'YWRtaW4=', 'admin@gmail.com', 'admin', 'admin');
INSERT INTO roles_users(creation_date_time, update_date_time, user_id, role_id) VALUE (NOW(),NOW(),2,2);
INSERT INTO roles_users(creation_date_time, update_date_time, user_id, role_id) VALUE (NOW(),NOW(),3,3);
INSERT INTO roles_users(creation_date_time, update_date_time, user_id, role_id) VALUE (NOW(),NOW(),1,1);

-- # TASKS
INSERT INTO tasks(creation_date_time, update_date_time, creator_id, executor_id, category_id, status_id, name, description, priority_id) VALUE (NOW(), NOW(), 3, 1, 1, 1, 'front-end', 'create front-enf for PMP', 1);
INSERT INTO tasks(creation_date_time, update_date_time, creator_id, executor_id, category_id, status_id, name, description, priority_id) VALUE (NOW(), NOW(), 3, 2, 2, 2, 'back-end', 'create back-end for PMP', 1);



