-- Persons
INSERT INTO production.persons(nusp, name, document, institution, email, birth) VALUES ('11796020', 'Gabriel M. Jospin', '52473041873', 'Escola de Artes, Ciencias e Humanidades', 'gabriel.jospin@usp.br', '02-10-2002');
INSERT INTO production.persons(nusp, name, document, institution, email, birth) VALUES ('623665', 'JEF', '0322764378', 'Instituto de Matematica e Estatística', 'jef@ime.usp.br', '07-11-1972');
INSERT INTO production.persons(nusp, name, document, institution, email, birth) VALUES ('68933', 'Don vito Corleone', '36548876543', 'Faculdade de Economia e Administração', 'godfather@usp.br', '21-09-1952');
INSERT INTO production.persons(nusp, name, document, institution, email, birth) VALUES ('27754343', 'James Gun', '15567834567', 'Escola de Comunicação e Artes', 'James.gun@usp.br', '07-11-1983');
INSERT INTO production.persons(nusp, name, document, institution, email, birth) VALUES ('12312350', 'Charles Leclerc', '12285541873', 'Escola Politécnica', 'tifosi@usp.br', '25-10-1998');
INSERT INTO production.persons(nusp, name, document, institution, email, birth) VALUES ('0000000001', 'Hari Seldon', '7894561230', 'Instituto de Matemática e Estatistica', 'seldon@ime.usp.br', '19-01-2038');

-- Students
INSERT INTO production.students(course, entry_grade) VALUES ('Sistemas de Informação', 7);
INSERT INTO production.students(course, entry_grade) VALUES ('Computação', 9);

-- Professor
INSERT INTO production.professors(specialization, level_of_education, alma_matter, institutional_website) VALUES ('Ciencia e Engenharia de Dados', 'Doctor', 'USP - Universidade de São Paulo', 'www.ime.usp.br/~jef');
INSERT INTO production.professors(specialization, level_of_education, alma_matter) VALUES ('Cambio de Favores', 'Doctor', 'NYU - New York University');
INSERT INTO production.professors(specialization, level_of_education, alma_matter, institutional_website) VALUES ('Psicohistória', 'Doctor', 'Streeling University of Trantor', 'asimov.fandom.com/wiki/Hari_Seldon');

-- Researcher
INSERT INTO production.researchers(specialization, is_postgraduate_student) VALUES ('Processamento de Linguagem Natural', true);
INSERT INTO production.researchers(specialization, is_postgraduate_student) VALUES ('Cinema Blockbuster', false);

-- Employer
INSERT INTO production.employers(function, salary) VALUES ('University Manager', 10000000);
INSERT INTO production.employers(function, salary) VALUES ('God Father', 1700000000);
INSERT INTO production.employers(function, salary) VALUES ('The Haven', 60000);

--Courses
INSERT INTO production.courses(code_course, name, description, menu, institution, creation) VALUES ('MAC0350', 'Desenvolvimento de Sistemas', 'Princípios e técnicas de desenvolvimento de sistemas de software. Testes de software. Persistência de dados. Modelo entidade relacionamento e modelo relacional.','Técnicas para coleta de requisitos, modelagem, projeto e implementação de sistemas de software. Conceitos de projetos de sistemas avançados. Qualidade de software. Gerência e manutenção de software. Persistência de dados: projeto conceitual.', 'Instituto de Matemática e Estatistica', '2021-01-01');
INSERT INTO production.courses(code_course, name, description, menu, institution, creation) VALUES ('PHC0001','Introdução a PsicoHistoria', 'Introdução a Ciencia da Psicohistoria', 'Lógica Seldon; Teste Seldon; Series Temporais Sociais; O Mulo - Mutações em Seldon', 'Instituto de Matematica Estatistica', CURRENT_DATE);
