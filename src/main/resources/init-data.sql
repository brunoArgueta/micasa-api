INSERT INTO public.groups (id, created_date, updated_date, group_name) VALUES
(10001, now(), now(), 'ADMINISTRACION'),
(10003, now(), now(), 'VIGILANCIA'),
(10005, now(), now(), 'RESIDENTE');

INSERT INTO public.group_authorities (id, created_date, updated_date, authority, group_id) VALUES
(10007, now(), now(), 'ADMIN', 10001),
(10009, now(), now(), 'SEG', 10001),
(100011, now(), now(), 'SEG', 10003),
(100012, now(), now(), 'USER', 10005);



INSERT INTO public.users (id, created_date, updated_date, name, last_name, username, password, enabled, non_expired, non_locked)
VALUES (nextval('micasa_sequence'), now(), now(), 'Bruno', 'Argueta Montes de Oca', 'bruno.argueta@gmail.com', '{bcrypt}$2a$10$Bpri08o/JziN1aSjPogVnexP2CqRphJ0yHv8ab0jd625T3NJMw1oG', TRUE, TRUE, TRUE);

