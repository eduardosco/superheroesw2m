CREATE SCHEMA IF NOT EXISTS superheroes; 
create sequence superheroes.superheroe_seq;
CREATE TABLE IF NOT EXISTS superheroes.superheroes(
	id int not null,
	nombre varchar(50) not null unique,
	genero varchar(50) not null,
	primary key(id)
);
insert into superheroes.superheroes (id, nombre, genero)
values (nextval('superheroes.superheroe_seq'), 'Ant-Man', 'Hombre');
insert into superheroes.superheroes (id, nombre, genero)
values (nextval('superheroes.superheroe_seq'), 'Aquaman', 'Hombre');
insert into superheroes.superheroes (id, nombre, genero)
values (nextval('superheroes.superheroe_seq'), 'Asterix', 'Hombre');
insert into superheroes.superheroes (id, nombre, genero)
values (nextval('superheroes.superheroe_seq'), 'The Atom', 'Hombre');
insert into superheroes.superheroes (id, nombre, genero)
values (nextval('superheroes.superheroe_seq'), 'Batgirl', 'Mujer');
insert into superheroes.superheroes (id, nombre, genero)
values (nextval('superheroes.superheroe_seq'), 'Batman', 'Hombre');
insert into superheroes.superheroes (id, nombre, genero)
values (nextval('superheroes.superheroe_seq'), 'Batwoman', 'Mujer');
insert into superheroes.superheroes (id, nombre, genero)
values (nextval('superheroes.superheroe_seq'), 'Black Canary', 'Mujer');
insert into superheroes.superheroes (id, nombre, genero)
values (nextval('superheroes.superheroe_seq'), 'Black Panther', 'Hombre');
insert into superheroes.superheroes (id, nombre, genero)
values (nextval('superheroes.superheroe_seq'), 'Captain America', 'Hombre');
insert into superheroes.superheroes (id, nombre, genero)
values (nextval('superheroes.superheroe_seq'), 'Captain Marvel', 'Mujer');
insert into superheroes.superheroes (id, nombre, genero)
values (nextval('superheroes.superheroe_seq'), 'Catwoman', 'Mujer');
insert into superheroes.superheroes (id, nombre, genero)
values (nextval('superheroes.superheroe_seq'), 'Conan the Barbarian', 'Hombre');
insert into superheroes.superheroes (id, nombre, genero)
values (nextval('superheroes.superheroe_seq'), 'Daredevil', 'Hombre');
insert into superheroes.superheroes (id, nombre, genero)
values (nextval('superheroes.superheroe_seq'), 'Doc Savage', 'Hombre');
insert into superheroes.superheroes (id, nombre, genero)
values (nextval('superheroes.superheroe_seq'), 'Doctor Strange', 'Hombre');
insert into superheroes.superheroes (id, nombre, genero)
values (nextval('superheroes.superheroe_seq'), 'Elektra', 'Mujer');
insert into superheroes.superheroes (id, nombre, genero)
values (nextval('superheroes.superheroe_seq'), 'Ghost Rider', 'Hombre');
insert into superheroes.superheroes (id, nombre, genero)
values (nextval('superheroes.superheroe_seq'), 'Green Arrow', 'Hombre');
insert into superheroes.superheroes (id, nombre, genero)
values (nextval('superheroes.superheroe_seq'), 'Green Lantern', 'Hombre');
insert into superheroes.superheroes (id, nombre, genero)
values (nextval('superheroes.superheroe_seq'), 'Hawkeye', 'Hombre');
insert into superheroes.superheroes (id, nombre, genero)
values (nextval('superheroes.superheroe_seq'), 'Hellboy', 'Hombre');
insert into superheroes.superheroes (id, nombre, genero)
values (nextval('superheroes.superheroe_seq'), 'Incredible Hulk', 'Hombre');
insert into superheroes.superheroes (id, nombre, genero)
values (nextval('superheroes.superheroe_seq'), 'Iron Fist', 'Hombre');
insert into superheroes.superheroes (id, nombre, genero)
values (nextval('superheroes.superheroe_seq'), 'Iron Man', 'Hombre');
insert into superheroes.superheroes (id, nombre, genero)
values (nextval('superheroes.superheroe_seq'), 'Marvelman', 'Hombre');
insert into superheroes.superheroes (id, nombre, genero)
values (nextval('superheroes.superheroe_seq'), 'Robin', 'Hombre');
insert into superheroes.superheroes (id, nombre, genero)
values (nextval('superheroes.superheroe_seq'), 'The Rocketeer', 'Hombre');
insert into superheroes.superheroes (id, nombre, genero)
values (nextval('superheroes.superheroe_seq'), 'The Shadow', 'Hombre');
insert into superheroes.superheroes (id, nombre, genero)
values (nextval('superheroes.superheroe_seq'), 'Spider-Man', 'Hombre');
insert into superheroes.superheroes (id, nombre, genero)
values (nextval('superheroes.superheroe_seq'), 'Sub-Mariner', 'Hombre');
insert into superheroes.superheroes (id, nombre, genero)
values (nextval('superheroes.superheroe_seq'), 'Supergirl', 'Mujer');
insert into superheroes.superheroes (id, nombre, genero)
values (nextval('superheroes.superheroe_seq'), 'Superman', 'Hombre');
insert into superheroes.superheroes (id, nombre, genero)
values (nextval('superheroes.superheroe_seq'), 'Thor', 'Hombre');
insert into superheroes.superheroes (id, nombre, genero)
values (nextval('superheroes.superheroe_seq'), 'The Wasp', 'Mujer');
insert into superheroes.superheroes (id, nombre, genero)
values (nextval('superheroes.superheroe_seq'), 'Watchmen', 'Hombre');
insert into superheroes.superheroes (id, nombre, genero)
values (nextval('superheroes.superheroe_seq'), 'Wolverine', 'Hombre');
insert into superheroes.superheroes (id, nombre, genero)
values (nextval('superheroes.superheroe_seq'), 'Wonder Woman', 'Mujer');
insert into superheroes.superheroes (id, nombre, genero)
values (nextval('superheroes.superheroe_seq'), 'Zatanna', 'Mujer');
insert into superheroes.superheroes (id, nombre, genero)
values (nextval('superheroes.superheroe_seq'), 'Zatara', 'Mujer');
