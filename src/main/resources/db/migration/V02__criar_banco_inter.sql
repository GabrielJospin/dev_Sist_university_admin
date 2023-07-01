CREATE TABLE production.persons(
    id_person serial,
    nusp CHARACTER varying(10) NOT NULL,
    name CHARACTER varying(255) NOT NULL,
    document CHARACTER varying(11) NOT NULL,
    institution CHARACTER varying(255) NOT NULL,
    email CHARACTER varying(255) NOT NULL,
    birth DATE NOT NULL,
    PRIMARY KEY (id_person),
    UNIQUE (nusp)
);

CREATE TABLE production.profiles(
    id_profile serial,
    code_profile CHARACTER varying(5) NOT NULL,
    description CHARACTER varying(255) NOT NULL,
    name CHARACTER varying(255) NOT NULL,
    PRIMARY KEY(id_profile),
    UNIQUE(code_profile)
);

CREATE TABLE production.services(
    id_service serial,
    code_service CHARACTER varying(10) NOT NULL,
    description CHARACTER varying(255) NOT NULL,
    id_profile INTEGER not null,
    PRIMARY KEY(id_service),
    UNIQUE(code_service),
    FOREIGN KEY (id_profile) REFERENCES production.profiles(id_profile)
);

CREATE TABLE production.login(
    id_login serial,
    login CHARACTER varying(30) NOT NULL,
    password text not null,
    id_person INTEGER NOT NULL,
    PRIMARY KEY(id_login),
    UNIQUE(login),
    FOREIGN KEY(id_person) REFERENCES production.persons(id_person)
);

CREATE EXTENSION IF NOT EXISTS pgcrypto;

CREATE TABLE production.students(
    id_student serial,
    course CHARACTER varying(40) NOT NULL,
    entry_grade numeric NOT NULL,
    PRIMARY KEY  (id_student)
);

CREATE TABLE production.professors(
    id_professor serial,
    specialization CHARACTER varying(255) NOT NULL ,
    level_of_education CHARACTER varying(30) NOT NULL ,
    alma_matter character varying(255) NOT NULL,
    institutional_website CHARACTER varying(255),
    PRIMARY KEY(id_professor)
);

CREATE TABLE production.researchers(
    id_researcher serial,
    specialization CHARACTER varying(255) NOT NULL,
    is_postgraduate_student BOOLEAN NOT NULL,
    PRIMARY KEY (id_researcher)
);

CREATE TABLE production.employers(
    id_employer serial,
    function CHARACTER VARYING(255) NOT NULL,
    salary INT NOT NULL,
    PRIMARY KEY (id_employer)
);

CREATE TABLE production.courses(
    id_course serial,
    code_course CHARACTER varying(7) NOT NULL,
    name CHARACTER varying(100) NOT NULL,
    description CHARACTER varying(255) NOT NULL,
    menu CHARACTER varying(255) NOT NULL,
    institution CHARACTER varying(255) NOT NULL,
    creation DATE NOT NULL,
    PRIMARY KEY(id_course),
    UNIQUE(code_course)
);
