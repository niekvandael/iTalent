--
-- Import script when "hibernate.hbm2ddl.auto" is set to "create"
--

-- Departments
insert into Department (id, lastUpdate, lastUpdatedBy, status, name) values(null, '2016-01-01', 'Team 1', 'A', 'IT');
insert into Department (id, lastUpdate, lastUpdatedBy, status, name) values(null, '2016-01-01', 'Team 1', 'A', 'MARKETING');

-- Categories
insert into Category (id, lastUpdate, lastUpdatedBy, status, description) values(null, '2016-01-01', 'Team 1', 'Active', 'Food');

-- Roles
insert into Role (id, name) values(null, 'Student');

-- Users
insert into User (id, firstname, lastname, password, username, department_id, role_id) values(null, 'Team 1', 'Great', 'test', 'team1', 1, 1);

-- Projects
insert into Project (id, lastUpdate, lastUpdatedBy, status, beginDate, creationDate, description, endDate, isPublic, isVerified, projectStatus, shortDescription, title, category_id, user_id) values(null, '2016-04-23', 'Niek', 'A', '2016-05-01', '2016-04-23', 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis,', '2016-06-01', false, false, 1, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec qu', 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean m', 1, 1);
insert into Project (id, lastUpdate, lastUpdatedBy, status, beginDate, creationDate, description, endDate, isPublic, isVerified, projectStatus, shortDescription, title, category_id, user_id) values(null, '2016-04-23', 'Niek', 'A', '2016-05-01', '2016-04-23', 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis,', '2016-06-01', false, false, 1, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec qu', 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean m', 1, 1);
insert into Project (id, lastUpdate, lastUpdatedBy, status, beginDate, creationDate, description, endDate, isPublic, isVerified, projectStatus, shortDescription, title, category_id, user_id) values(null, '2016-04-23', 'Niek', 'A', '2016-05-01', '2016-04-23', 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis,', '2016-06-01', false, false, 1, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec qu', 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean m', 1, 1);