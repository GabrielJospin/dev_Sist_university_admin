CREATE TABLE production.rel_person_profile(
    id serial,
    id_person integer not null,
    id_profile integer not null,
    init_date timestamp with time zone not null,
    end_date timestamp with time zone not null,
    PRIMARY KEY(id),
    UNIQUE (id_person, id_profile, init_date, end_date),
    FOREIGN KEY (id_person) REFERENCES production.persons(id_person),
    FOREIGN KEY (id_profile) references production.profiles(id_profile)
);

CREATE TABLE production.historical_usage(
    id serial,
    id_person integer not null,
    id_service integer not null,
    datetime timestamp with time zone not null,
    PRIMARY KEY(id),
    UNIQUE(id_person, id_service, datetime),
    FOREIGN KEY (id_person) REFERENCES production.persons (id_person),
    FOREIGN KEY (id_service) REFERENCES production.services (id_service)
);

CREATE TABLE production.spec_person(
    id serial,
    id_person integer,
    id_student integer,
    id_professor integer,
    id_researcher integer,
    id_employer integer,
    PRIMARY KEY(id),
    UNIQUE(id_person),
    UNIQUE(id_student),
    UNIQUE(id_professor),
    UNIQUE(id_researcher),
    UNIQUE(id_employer),
    FOREIGN KEY (id_person) REFERENCES production.persons (id_person),
    FOREIGN KEY (id_student) REFERENCES production.students (id_student),
    FOREIGN KEY (id_professor) REFERENCES production.professors (id_professor),
    FOREIGN KEY (id_researcher) REFERENCES production.researchers (id_researcher),
    FOREIGN KEY (id_employer) REFERENCES production.employers (id_employer)

);

CREATE TABLE production.offering(
    id serial,
    id_student integer not null,
    id_professor integer not null,
    id_course integer not null,
    init_date timestamp with time zone not null,
    end_date timestamp with time zone not null,
    grade int,
    classroom VARCHAR(30),
    institution CHARACTER varying(255) NOT NULL,
    primary key (id),
    UNIQUE(id_student, id_professor, id_course, init_date, end_date),
    FOREIGN KEY (id_student) REFERENCES production.students(id_student),
    FOREIGN KEY (id_professor) REFERENCES production.professors(id_professor),
    FOREIGN KEY (id_course) REFERENCES production.courses(id_course)
);