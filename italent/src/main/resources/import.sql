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
insert into department (last_update, last_updated_by, status, name) values('2016-01-01', 'Team1', 'A', 'Business');
insert into department (last_update, last_updated_by, status, name) values('2016-01-01', 'Team1', 'A', 'Education');
insert into department (last_update, last_updated_by, status, name) values('2016-01-01', 'Team1', 'A', 'Healthcare');
insert into department (last_update, last_updated_by, status, name) values('2016-01-01', 'Team1', 'A', 'IT');
insert into department (last_update, last_updated_by, status, name) values('2016-01-01', 'Team1', 'A', 'MAD');
insert into department (last_update, last_updated_by, status, name) values('2016-01-01', 'Team1', 'A', 'Media & Tourism');
insert into department (last_update, last_updated_by, status, name) values('2016-01-01', 'Team1', 'A', 'Music');
insert into department (last_update, last_updated_by, status, name) values('2016-01-01', 'Team1', 'A', 'Social Work');
insert into department (last_update, last_updated_by, status, name) values('2016-01-01', 'Team1', 'A', 'Tech');

-- Categories
insert into category (last_update, last_updated_by, status, description) values('2016-01-01', 'Team1', 'A', 'Big Data');
insert into category (last_update, last_updated_by, status, description) values('2016-01-01', 'Team1', 'A', 'Tutoring');

-- Roles
insert into role (name) values('Docent');
insert into role (name) values('Student');

-- Users
insert into user (firstname, lastname, username, password, department_id, role_id) values('Arjen', 'Schuurman', 'arjen.schuurman@student.pxl.be', 'pxlpxl', 4, 2);
insert into user (firstname, lastname, username, password, department_id, role_id) values('Bart', 'Hunerbein', 'bart.hunerbein@student.pxl.be', 'pxlpxl', 4, 2);
insert into user (firstname, lastname, username, password, department_id, role_id) values('Dennie', 'Grondelaers', 'dennie.grondelaers@student.pxl.be', 'pxlpxl', 4, 2);
insert into user (firstname, lastname, username, password, department_id, role_id) values('Jesse', 'Vranken', 'jesse.vranken@student.pxl.be', 'pxlpxl', 4, 2);
insert into user (firstname, lastname, username, password, department_id, role_id) values('Niek', 'Vandael', 'niek.vandael@student.pxl.be', 'pxlpxl', 4, 2);
insert into user (firstname, lastname, username, password, department_id, role_id) values('Tim', 'Dupont', 'tim.dupont@pxl.be', 'pxlpxl', 4, 1);

-- Projects
insert into project (last_update, last_updated_by, status, begin_date, end_date, creation_date, is_public, is_backed, is_verified, project_status, description, short_description, title, category_id, user_id) values('2016-04-23', 'Team1', 'A', '2016-05-01', '2016-04-23', '2016-06-01', true, false, true, 1, 'Big Data wordt wel eens de olie van de 21e eeuw genoemd, maar om uit te groeien tot nieuwe rijke datasjeiks moeten we net als bij olie raffineren. We moeten Big Data omzetten in iets kostbaars. Jackie Janssen neemt ons mee in deze nieuwe, wondere wereld van Big Data', 'Big Data wordt wel eens de olie van de 21e eeuw genoemd, maar om uit te groeien tot nieuwe rijke datasjeiks moeten we net als bij olie raffineren. We moeten Big Data omzetten in iets kostbaars.', 'IT@Breakfast - 18 mei: voor alle 2de jaars - Topic: Big Data', 1, 1);
insert into project (last_update, last_updated_by, status, begin_date, end_date, creation_date, is_public, is_backed, is_verified, project_status, description, short_description, title, category_id, user_id) values('2016-04-23', 'Team1', 'A', '2016-05-01', '2016-04-23', '2016-06-01', true, false, true, 1, 'Tijdens PXL Breekt uit, op woensdag 20 april, willen we samen met studenten Journalistiek op zoek gaan naar mogelijke verhalen in Big Data. De bedoeling is dat een aantal IT-studenten één of meerdere datasets met ruwe data vertalen naar een gestructureerd datarapport. Daarna gaan de studenten Journalistiek met dit rapport aan de slag om een verhaal te schrijven. Deze opdracht vindt plaats in een redactielokaal van Het Belang van Limburg van 08.30 u. tot 13.00 u. (schatting). We zijn op zoek naar een 3-tal tweedejaarsstudenten van de IT management track (of studenten die niet deelnemen aan het AppDev/SNB project). Geïnteresseerde studenten mogen zich kandidaat stellen door een e-mail te sturen naar Tristan.Fransen@pxl.be. Geselecteerde kandidaten worden z.s.m. op de hoogte gebracht. Collega Steven Palmaers kondigde eerder ook reeds een opdracht aan voor IT management-studenten om projectvoorstellen van studenten Journalistiek bij te wonen en te evalueren tijdens PXL Breekt uit op woensdag 20 april van 09.00 u. tot 13.00 u. Hier zoeken we nog 4 andere studenten die willen deelnemen.Uiteraard vallen hier I-Talent uren mee te verdienen, afhankelijk van de duur van de opdracht.', 'Tijdens PXL Breekt uit, op woensdag 20 april, willen we samen met studenten Journalistiek op zoek gaan naar mogelijke verhalen in Big Data.', 'PXL Breekt Uit: opdracht samen met studenten Journalistiek.', 1, 2);
insert into project (last_update, last_updated_by, status, begin_date, end_date, creation_date, is_public, is_backed, is_verified, project_status, description, short_description, title, category_id, user_id) values('2016-04-23', 'Team1', 'A', '2016-05-01', '2016-04-23', '2016-06-01', false, false, true, 1, 'Volgende zaterdag (16 april 2016) is er opnieuw een CoderDojo Hasselt event. Ditmaal opnieuw op de PXL (Campus Vildersstraat), van 10u tot 13u (in de cafetaria). Jullie zijn liefst rond 9.30u ter plaatse.Hiermee kunnen jullie 4u voor I-Talent verdienen. Bedoeling is dat jullie kinderen leren programmeren, aan de hand van Scratch, App Inventor, Robomind / Lego Mindstorms, HTML en Minecraft.Wie wil deze sessie mee begeleiden?Als jullie mee willen komen helpen, geef dan even jullie naam in op https://docs.google.com/document/d/1Mon4xcGwK7e0MRkxHEPTDsFoimtRl0DssgT5k_YeJlE/editGraag ook een mailtje naar steven.palmaers@pxl.be', 'Volgende zaterdag (16 april 2016) is er opnieuw een CoderDojo Hasselt event.', 'CoderDojo Hasselt - 16 april 2016', 2, 3);

-- Likes
insert into likes(last_update, last_updated_by, status, user_id, project_id) values('2016-01-01', 'Team1', 'A', 1, 1);
--insert into likes(last_update, last_updated_by, status, user_id, project_id) values('2016-01-01', 'Team1', 'A', 1, 2);
insert into likes(last_update, last_updated_by, status, user_id, project_id) values('2016-01-01', 'Team1', 'A', 2, 1);
