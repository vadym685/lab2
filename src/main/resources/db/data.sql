INSERT INTO public.a_role (id, name) VALUES (1, 'ROLE_USER');
INSERT INTO public.a_role (id, name) VALUES (2, 'ROLE_ADMIN');

INSERT INTO public.a_user (id, password, username) VALUES (2, '$2a$10$ROPC3JjlWVXy8Li5EhMEg.s.djOapay8hbmXnbGbcGnjX5O15xyTK', '1');
INSERT INTO public.a_user (id, password, username) VALUES (1, '$2a$10$ROPC3JjlWVXy8Li5EhMEg.s.djOapay8hbmXnbGbcGnjX5O15xyTK', 'Admin');

INSERT INTO public.a_user_roles (users_id, roles_id) VALUES (2, 1);
INSERT INTO public.a_user_roles (users_id, roles_id) VALUES (1, 2);

INSERT INTO public.point (id, adress, comment, contact_number, contact_person, latitude, longitude, name) VALUES (1, '1', 'comment12', 'contactNumber', 'contactPerson', 34.24, 54.24, '1');
INSERT INTO public.point (id, adress, comment, contact_number, contact_person, latitude, longitude, name) VALUES (2, '2', 'apsda&#1103;&#1095;&#1089;asd', 'contactNumber2', 'contactPerson2', 34.24, 54.24, '2qwe');
INSERT INTO public.point (id, adress, comment, contact_number, contact_person, latitude, longitude, name) VALUES (3, '234', '678', '6781', '6587123', 543, 5464, '32');
INSERT INTO public.point (id, adress, comment, contact_number, contact_person, latitude, longitude, name) VALUES (5, '13', '', '123', '23123', 123, 123, '123');

INSERT INTO public.task (id, date, pointid, point_id) VALUES (68, '2022-01-16 00:01:00.000000', null, 5);
INSERT INTO public.task (id, date, pointid, point_id) VALUES (3, '2022-01-05 00:01:00.000000', null, 3);
INSERT INTO public.task (id, date, pointid, point_id) VALUES (64, '2022-01-08 00:01:00.000000', null, 1);
INSERT INTO public.task (id, date, pointid, point_id) VALUES (63, '2022-01-08 00:01:00.000000', null, 1);
INSERT INTO public.task (id, date, pointid, point_id) VALUES (65, '2022-01-14 00:01:00.000000', null, 1);
INSERT INTO public.task (id, date, pointid, point_id) VALUES (66, '2022-01-16 00:01:00.000000', null, 1);
INSERT INTO public.task (id, date, pointid, point_id) VALUES (67, '2022-01-15 00:01:00.000000', null, 1);

INSERT INTO public.consumables (id, comment, description, name, task_id) VALUES (3, '14', '41', '13', 3);
INSERT INTO public.consumables (id, comment, description, name, task_id) VALUES (9, null, null, null, null);
INSERT INTO public.consumables (id, comment, description, name, task_id) VALUES (13, '', '', '123', 64);
INSERT INTO public.consumables (id, comment, description, name, task_id) VALUES (14, '', '', '12sa', 63);
INSERT INTO public.consumables (id, comment, description, name, task_id) VALUES (15, '&#1091;&#1092;', '124', '312', 65);
INSERT INTO public.consumables (id, comment, description, name, task_id) VALUES (16, '123', '14', '312', 67);
INSERT INTO public.consumables (id, comment, description, name, task_id) VALUES (17, '', '123', '123', 68);
INSERT INTO public.consumables (id, comment, description, name, task_id) VALUES (18, '', '', '1e', 68);

INSERT INTO public.position (id, comment, description, task_id) VALUES (1, '1', 'a13', null);
INSERT INTO public.position (id, comment, description, task_id) VALUES (4, '13', '123', 3);
INSERT INTO public.position (id, comment, description, task_id) VALUES (5, '24', 'r23', 3);
INSERT INTO public.position (id, comment, description, task_id) VALUES (20, null, null, null);
INSERT INTO public.position (id, comment, description, task_id) VALUES (21, null, null, null);
INSERT INTO public.position (id, comment, description, task_id) VALUES (22, null, null, null);
INSERT INTO public.position (id, comment, description, task_id) VALUES (23, null, null, null);
INSERT INTO public.position (id, comment, description, task_id) VALUES (24, null, null, null);
INSERT INTO public.position (id, comment, description, task_id) VALUES (25, null, null, null);
INSERT INTO public.position (id, comment, description, task_id) VALUES (37, '', '213', 64);
INSERT INTO public.position (id, comment, description, task_id) VALUES (38, '', '12', 63);
INSERT INTO public.position (id, comment, description, task_id) VALUES (39, '', '412', 65);
INSERT INTO public.position (id, comment, description, task_id) VALUES (40, '', '324', 66);
INSERT INTO public.position (id, comment, description, task_id) VALUES (41, '124', '23&#1082;&#1081;', 67);
INSERT INTO public.position (id, comment, description, task_id) VALUES (42, 'q123', 'qe2', 68);
INSERT INTO public.position (id, comment, description, task_id) VALUES (43, '123', '123', 68);

INSERT INTO public.person (id, full_name, managerid, name, phone_number, manager_id, admin) VALUES (5, '1', null, '1', '12', null, true);
INSERT INTO public.person (id, full_name, managerid, name, phone_number, manager_id, admin) VALUES (6, '2', null, '2', '2', 5, false);
INSERT INTO public.person (id, full_name, managerid, name, phone_number, manager_id, admin) VALUES (7, '&#1081;&#1081;&#1081;', null, '&#1081;&#1081;&#1081;', '111', null, false);
INSERT INTO public.person (id, full_name, managerid, name, phone_number, manager_id, admin) VALUES (13, 'full', null, 'name', '+352', 5, false);

INSERT INTO public.task_person_link (task_id, person_id) VALUES (63, 6);
INSERT INTO public.task_person_link (task_id, person_id) VALUES (65, 7);
INSERT INTO public.task_person_link (task_id, person_id) VALUES (67, 5);
INSERT INTO public.task_person_link (task_id, person_id) VALUES (67, 5);
INSERT INTO public.task_person_link (task_id, person_id) VALUES (68, 5);
INSERT INTO public.task_person_link (task_id, person_id) VALUES (68, 6);