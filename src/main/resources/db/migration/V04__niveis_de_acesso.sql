-- Profiles
INSERT INTO production.profiles(code_profile, description, name) VALUES ('VISIT', 'Qualquer visitante cadastrado em paginas da Universidade', 'Visitante');
INSERT INTO production.profiles(code_profile, description, name) VALUES ('ACAD', 'Alunos da graduação e pós-graduação', 'Acadêmico');
INSERT INTO production.profiles(code_profile, description, name) VALUES ('PROF', 'Doscente da Universidade', 'Professor');
INSERT INTO production.profiles(code_profile, description, name) VALUES ('ADMIN', 'Funcionario Administrativo da universidade', 'Administrador');
INSERT INTO production.profiles(code_profile, description, name) VALUES ('SUPER', 'Superintendentes da Unidade', 'Superintendente');

-- Services
----Persons
INSERT INTO production.services(code_service, description, id_profile) VALUES ('VIS_C_PER', 'criação de Pessoas por Visitante', 1);

INSERT INTO production.services(code_service, description, id_profile) VALUES ('PRO_R_PER', 'Pesquisa de Pessoas por Professor', 3);
INSERT INTO production.services(code_service, description, id_profile) VALUES ('ADM_R_PER', 'Pesquisa de Pessoas por Administrador', 4);
INSERT INTO production.services(code_service, description, id_profile) VALUES ('SUP_R_PER', 'Pesquisa de Pessoas por Superintender', 5);

INSERT INTO production.services(code_service, description, id_profile) VALUES ('ADM_U_PER', 'Atualização de Pessoas por Administrador', 4);
INSERT INTO production.services(code_service, description, id_profile) VALUES ('SUP_U_PER', 'Atualização de Pessoas por Superintender', 5);


---Login
INSERT INTO production.services(code_service, description, id_profile) VALUES ('VIS_C_LOG', 'criação de Login por Visitante', 1);

INSERT INTO production.services(code_service, description, id_profile) VALUES ('ADM_U_LOG', 'Atualização de Login por Administrador', 4);
INSERT INTO production.services(code_service, description, id_profile) VALUES ('SUP_U_LOG', 'Atualização de Login por Superintender',5);

INSERT INTO production.services(code_service, description, id_profile) VALUES ('ADM_D_LOG', 'Deleção de Login por Administrador', 4);
INSERT INTO production.services(code_service, description, id_profile) VALUES ('SUP_D_LOG', 'Deleção de Login por Superintendente', 5);


--Students
INSERT INTO production.services(code_service, description, id_profile) VALUES ('ADM_C_STU', 'criação de Estudante por Administrador', 4);
INSERT INTO production.services(code_service, description, id_profile) VALUES ('SUP_C_STU', 'criação de Estudante por Superintendente', 5);

INSERT INTO production.services(code_service, description, id_profile) VALUES ('PRO_R_STU', 'Pesquisa de Estudante por Professor', 3);
INSERT INTO production.services(code_service, description, id_profile) VALUES ('ADM_R_STU', 'Pesquisa de Estudante por Administrador', 4);
INSERT INTO production.services(code_service, description, id_profile) VALUES ('SUP_R_STU', 'Pesquisa de Estudante por Superintendente', 5);

INSERT INTO production.services(code_service, description, id_profile) VALUES ('ADM_U_STU', 'Atualização de Estudante por Administrador', 4);
INSERT INTO production.services(code_service, description, id_profile) VALUES ('SUP_U_STU', 'Atualização de Estudante por Superintender',5);


--Professor
INSERT INTO production.services(code_service, description, id_profile) VALUES ('ADM_C_PRO', 'criação de Professor por Administrador', 4);
INSERT INTO production.services(code_service, description, id_profile) VALUES ('SUP_C_PRO', 'criação de Professor por Superintendente', 5);

INSERT INTO production.services(code_service, description, id_profile) VALUES ('VIS_R_PRO', 'Pesquisa de Professor por Visitante', 1);

INSERT INTO production.services(code_service, description, id_profile) VALUES ('ADM_U_PRO', 'Atualização de Professor por Administrador', 4);
INSERT INTO production.services(code_service, description, id_profile) VALUES ('SUP_U_PRO', 'Atualização de Professor por Superintender',5);


--Researches
INSERT INTO production.services(code_service, description, id_profile) VALUES ('ADM_C_RES', 'criação de Pesquisador por Administrador', 4);
INSERT INTO production.services(code_service, description, id_profile) VALUES ('SUP_C_RES', 'criação de Pesquisador por Superintendente', 5);

INSERT INTO production.services(code_service, description, id_profile) VALUES ('VIS_R_RES', 'Pesquisa de Pesquisador por Visitante', 1);

INSERT INTO production.services(code_service, description, id_profile) VALUES ('ADM_U_RES', 'Atualização de Pesquisador por Administrador', 4);
INSERT INTO production.services(code_service, description, id_profile) VALUES ('SUP_U_RES', 'Atualização de Pesquisador por Superintender',5);


--Employers
INSERT INTO production.services(code_service, description, id_profile) VALUES ('SUP_C_EMP', 'criação de empregado por Superintendente', 5);

INSERT INTO production.services(code_service, description, id_profile) VALUES ('VIS_R_EMP', 'Pesquisa de empregado por Visitante', 1);

INSERT INTO production.services(code_service, description, id_profile) VALUES ('ADM_U_EMP', 'Atualização de empregado por Administrador', 4);
INSERT INTO production.services(code_service, description, id_profile) VALUES ('SUP_U_EMP', 'Atualização de empregado por Superintender',5);

--Courses
INSERT INTO production.services(code_service, description, id_profile) VALUES ('SUP_C_CUR', 'criação de curso por Superintendente', 5);
INSERT INTO production.services(code_service, description, id_profile) VALUES ('VIS_R_CUR', 'Pesquisa de curso por Visitante', 1);
INSERT INTO production.services(code_service, description, id_profile) VALUES ('SUP_U_CUR', 'Atualização de empregado por Superintender',5);


--Relation Person Profile
INSERT INTO production.services(code_service, description, id_profile) VALUES ('SUP_C_RPP', 'criação de Relação Pessoa Perfil por Superintendente', 5);
INSERT INTO production.services(code_service, description, id_profile) VALUES ('SUP_R_RPP', 'Pesquisa de Relação Pessoa Perfil por Superintendente', 5);
INSERT INTO production.services(code_service, description, id_profile) VALUES ('SUP_U_RPP', 'Atualização de Relação Pessoa Perfil por Superintender',5);


--Historical Usage
INSERT INTO production.services(code_service, description, id_profile) VALUES ('SUP_R_HIS', 'Pesquisa de Historico por Superintendente', 5);

--Specificação
INSERT INTO production.services(code_service, description, id_profile) VALUES ('ADM_C_SPE', 'criação de expecificação de pessoa por Administrador', 4);
INSERT INTO production.services(code_service, description, id_profile) VALUES ('ADM_R_SPE', 'Pesquisa de expecificação de pessoa por Administrador', 4);
INSERT INTO production.services(code_service, description, id_profile) VALUES ('ADM_U_SPE', 'Atualização de expecificação de pessoa por Administrador',4);

