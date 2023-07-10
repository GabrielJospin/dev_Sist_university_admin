CREATE VIEW dw.available_services_by_profile as(
    select
        s.code_service                  as service_code,
        s.description                   as service_description,
        p.code_profile                  as profile_code,
        p.name                          as profile_name,
        p.description                   as profile_description
    from
        production.profiles p
    left join production.services s on s.id_profile = p.id_profile
    order by p.name);


CREATE VIEW dw.platform_usage_by_profile as(
select
    count(h.id) as qtd_chamadas,
    p.code_profile,
    p.name,
    p.description
from
    production.historical_usage h
    join production.services s on s.id_service = h.id_service
    join production.profiles p on p.id_profile = s.id_profile
group by p.code_profile, p.name, p.description
order by qtd_chamadas);

CREATE VIEW dw.most_offering_course as(
with most_off as (
    select
        count(distinct concat(of.init_date, of.end_date ,of.id_course))  as qtd_oferecimentos,
        of.id_course
    from production.offering of
    group by of.id_course
    order by qtd_oferecimentos
    limit 5),

     people as(
         select
             p.id_person,
             s.id_student as rel_id,
             p.nusp,
             p.name,
             'Student' as type
         from production.students s
                  join production.spec_person sp on s.id_student = sp.id_student
                  join production.persons p on p.id_person = sp.id_person

         UNION ALL

         select
             p.id_person,
             pr.id_professor as rel_id,
             p.nusp,
             p.name,
             'Professor' as type
         from production.professors pr
                  join production.spec_person sp on pr.id_professor = sp.id_professor
                  join production.persons p on p.id_person = sp.id_person
     )

select
    c.code_course as course_code,
    c.name as course_name,
    pp.nusp as professor_nusp,
    pp.name as professor_name,
    ps.nusp as student_nusp,
    ps.name as student_name,
    of.init_date as offering_init_date,
    of.end_date as  offering_end_date,
    of.grade as oferring_grade
from most_off m
         left join production.offering of on m.id_course = of.id_course
         left join production.courses c on c.id_course = m.id_course
         left join production.students s on s.id_student = of.id_student
         left join people ps on ps.rel_id = s.id_student and ps.type = 'Student'
         left join production.professors p on p.id_professor = of.id_professor
         left join people pp on pp.rel_id = p.id_professor and pp.type = 'Professor'
order by qtd_oferecimentos desc, ps.name);


CREATE VIEW dw.professor_with_most_class as(
    with list_prof as (
    select
        count(distinct concat(of.init_date, of.end_date ,of.id_course)) as qtd_of,
        of.id_professor as professor
    from production.offering of
    where
        of.init_date BETWEEN '2020-05-01' AND '2023-05-01'
    group by of.id_professor
    order by qtd_of desc
    limit 5
    )

    select
        p.name as professor_name,
        p.document as professor_document,
        p.nusp as professor_nusp,
        list_prof.qtd_of as offering_quantity
    from list_prof
    join production.spec_person sp on sp.id_professor = list_prof.professor
    join production.persons p on p.id_person = sp.id_person

);

