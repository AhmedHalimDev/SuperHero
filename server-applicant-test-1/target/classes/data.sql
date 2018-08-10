/**
 * CREATE Script for init of DB
 */

-- Create Publishers
insert into publisher (publisher_id, publisher_name) values (1, 'DC');
insert into publisher (publisher_id, publisher_name) values (2, 'MARVEL');

-- Create Skills
insert into skills (skill_id, skill_name) values (1, 'Flying');
insert into skills (skill_id, skill_name) values (2, 'Strong');
insert into skills (skill_id, skill_name) values (3, 'Hidden');
insert into skills (skill_id, skill_name) values (4, 'ExtraLive');
insert into skills (skill_id, skill_name) values (5, 'Speed');

-- Create 3 Super Hero
insert into super_hero (id, date_created, name, pseudonym, publisher_id) values (1, now(),'Spider-Man','S', 1);
insert into super_hero (id, date_created, name, pseudonym, publisher_id) values (2, now(),'Hulk','H', 2);
insert into super_hero (id, date_created, name, pseudonym, publisher_id) values (3, now(),'Batman','B', 2);

-- Create Allies
insert into allies (allies_id, allies_name, super_hero_id) values (1, 'Harry Osborne', 1);
insert into allies (allies_id, allies_name, super_hero_id) values (2, 'Peter Parker', 1);
insert into allies (allies_id, allies_name, super_hero_id) values (3, 'Bruce Wayne', 3);

-- Relationship between Super Hero and Skills
insert into super_hero_skills (super_hero_id, skill_id) values (1, 1);
insert into super_hero_skills (super_hero_id, skill_id) values (1, 5);
insert into super_hero_skills (super_hero_id, skill_id) values (2, 2);
insert into super_hero_skills (super_hero_id, skill_id) values (2, 3);
insert into super_hero_skills (super_hero_id, skill_id) values (2, 4);
insert into super_hero_skills (super_hero_id, skill_id) values (3, 4);