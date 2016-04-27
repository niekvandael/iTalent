--
-- Import script when "hibernate.hbm2ddl.auto" is set to "create"
--
delete from department;
delete from category;
delete from role;
delete from user;
delete from project;
delete from likes;


-- Departments
insert into department (id, last_update, last_updated_by, status, name) values(null, '2016-01-01', 'Team 1', 'A', 'IT');
insert into department (id, last_update, last_updated_by, status, name) values(null, '2016-01-01', 'Team 1', 'A', 'Marketing');

-- Categories
insert into category (id, last_update, last_updated_by, status, description) values(null, '2016-01-01', 'Team 1', 'Active', 'Food');

-- Roles
insert into role (id, name) values(null, 'Student');

-- Users
insert into user (id, firstname, lastname, password, username, department_id, role_id) values(null, 'Team 1', 'Great', 'test', 'team1', 1, 1);

-- Projects
insert into project (id, last_update, last_updated_by, status, begin_date, creation_date, description, end_date, is_public, is_verified, project_status, short_description, title, category_id, user_id) values(null, '2016-04-23', 'Niek', 'A', '2016-05-01', '2016-04-23', 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis,', '2016-06-01', false, false, 1, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec qu', 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean m', 1, 1);
insert into project (id, last_update, last_updated_by, status, begin_date, creation_date, description, end_date, is_public, is_verified, project_status, short_description, title, category_id, user_id) values(null, '2016-04-23', 'Niek', 'A', '2016-05-01', '2016-04-23', 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis,', '2016-06-01', false, false, 1, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec qu', 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean m', 1, 1);
insert into project (id, last_update, last_updated_by, status, begin_date, creation_date, description, end_date, is_public, is_verified, project_status, short_description, title, category_id, user_id) values(null, '2016-04-23', 'Niek', 'A', '2016-05-01', '2016-04-23', 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis,', '2016-06-01', false, false, 1, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec qu', 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean m', 1, 1);

-- Likes
insert into likes(user_id, project_id, status, last_update, last_updated_by, id) values(1,1,'A','Niek', '2016-01-01', 1);
