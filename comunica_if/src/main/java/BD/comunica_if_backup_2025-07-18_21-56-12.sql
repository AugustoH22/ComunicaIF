--
-- PostgreSQL database dump
--

-- Dumped from database version 17.5 (Debian 17.5-1.pgdg120+1)
-- Dumped by pg_dump version 17.5 (Debian 17.5-1.pgdg120+1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: notify_isativo_alterado(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.notify_isativo_alterado() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
BEGIN
    PERFORM pg_notify('isativo_alterado', NEW.id::text);
    RETURN NEW;
END;
$$;


ALTER FUNCTION public.notify_isativo_alterado() OWNER TO postgres;

--
-- Name: notify_new_message(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.notify_new_message() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
BEGIN
    PERFORM pg_notify('nova_mensagem', NEW.codigo::text);
    RETURN NEW;
END;
$$;


ALTER FUNCTION public.notify_new_message() OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: aluno; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.aluno (
    codigo integer NOT NULL,
    nome character varying(100) NOT NULL,
    isativo boolean DEFAULT true NOT NULL
);


ALTER TABLE public.aluno OWNER TO postgres;

--
-- Name: aluno_codigo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.aluno_codigo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.aluno_codigo_seq OWNER TO postgres;

--
-- Name: aluno_codigo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.aluno_codigo_seq OWNED BY public.aluno.codigo;


--
-- Name: aluno_necessidades; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.aluno_necessidades (
    aluno_id integer NOT NULL,
    necessidade_id integer NOT NULL
);


ALTER TABLE public.aluno_necessidades OWNER TO postgres;

--
-- Name: curso; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.curso (
    codigo integer NOT NULL,
    nome character varying(100) NOT NULL
);


ALTER TABLE public.curso OWNER TO postgres;

--
-- Name: curso_codigo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.curso_codigo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.curso_codigo_seq OWNER TO postgres;

--
-- Name: curso_codigo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.curso_codigo_seq OWNED BY public.curso.codigo;


--
-- Name: departamento; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.departamento (
    codigo integer NOT NULL,
    nome character varying(100) NOT NULL
);


ALTER TABLE public.departamento OWNER TO postgres;

--
-- Name: departamento_codigo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.departamento_codigo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.departamento_codigo_seq OWNER TO postgres;

--
-- Name: departamento_codigo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.departamento_codigo_seq OWNED BY public.departamento.codigo;


--
-- Name: historicorestrito; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.historicorestrito (
    codigo integer NOT NULL,
    datahora timestamp without time zone NOT NULL,
    ocorrencia character varying(255) NOT NULL,
    anotacao text,
    codaluno integer NOT NULL,
    codservidor integer NOT NULL
);


ALTER TABLE public.historicorestrito OWNER TO postgres;

--
-- Name: historicorestrito_codigo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.historicorestrito_codigo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.historicorestrito_codigo_seq OWNER TO postgres;

--
-- Name: historicorestrito_codigo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.historicorestrito_codigo_seq OWNED BY public.historicorestrito.codigo;


--
-- Name: mensagem; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.mensagem (
    codigo integer NOT NULL,
    assunto character varying(100) NOT NULL,
    texto text NOT NULL,
    codservidorremetente integer NOT NULL,
    datahoracriacao timestamp without time zone NOT NULL
);


ALTER TABLE public.mensagem OWNER TO postgres;

--
-- Name: mensagem_aluno; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.mensagem_aluno (
    codmensagem integer,
    codaluno integer
);


ALTER TABLE public.mensagem_aluno OWNER TO postgres;

--
-- Name: mensagem_codigo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.mensagem_codigo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.mensagem_codigo_seq OWNER TO postgres;

--
-- Name: mensagem_codigo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.mensagem_codigo_seq OWNED BY public.mensagem.codigo;


--
-- Name: mensagem_destinatario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.mensagem_destinatario (
    codmensagem integer,
    codservidordestinatario integer
);


ALTER TABLE public.mensagem_destinatario OWNER TO postgres;

--
-- Name: necessidadeespecial; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.necessidadeespecial (
    codigo integer NOT NULL,
    codigonecessidade character varying(20) NOT NULL,
    descricao character varying(255) NOT NULL
);


ALTER TABLE public.necessidadeespecial OWNER TO postgres;

--
-- Name: necessidadeespecial_codigo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.necessidadeespecial_codigo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.necessidadeespecial_codigo_seq OWNER TO postgres;

--
-- Name: necessidadeespecial_codigo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.necessidadeespecial_codigo_seq OWNED BY public.necessidadeespecial.codigo;


--
-- Name: permissao; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.permissao (
    codigo integer NOT NULL,
    descricao character varying(100) NOT NULL
);


ALTER TABLE public.permissao OWNER TO postgres;

--
-- Name: permissao_codigo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.permissao_codigo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.permissao_codigo_seq OWNER TO postgres;

--
-- Name: permissao_codigo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.permissao_codigo_seq OWNED BY public.permissao.codigo;


--
-- Name: servidor; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.servidor (
    id integer NOT NULL,
    nome character varying(100) NOT NULL,
    departamento_id integer NOT NULL,
    permissao_id integer NOT NULL,
    usuario character varying(50) NOT NULL,
    senha character varying(255) NOT NULL,
    isfirstlogin boolean DEFAULT true NOT NULL,
    isativo boolean DEFAULT true NOT NULL
);


ALTER TABLE public.servidor OWNER TO postgres;

--
-- Name: servidor_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.servidor_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.servidor_id_seq OWNER TO postgres;

--
-- Name: servidor_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.servidor_id_seq OWNED BY public.servidor.id;


--
-- Name: turma; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.turma (
    id integer NOT NULL,
    nome character varying(100) NOT NULL,
    curso_id integer NOT NULL,
    ano character varying(10) NOT NULL
);


ALTER TABLE public.turma OWNER TO postgres;

--
-- Name: turma_aluno; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.turma_aluno (
    codturma integer NOT NULL,
    codaluno integer NOT NULL
);


ALTER TABLE public.turma_aluno OWNER TO postgres;

--
-- Name: turma_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.turma_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.turma_id_seq OWNER TO postgres;

--
-- Name: turma_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.turma_id_seq OWNED BY public.turma.id;


--
-- Name: turma_servidor; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.turma_servidor (
    codturma integer NOT NULL,
    codservidor integer NOT NULL
);


ALTER TABLE public.turma_servidor OWNER TO postgres;

--
-- Name: aluno codigo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.aluno ALTER COLUMN codigo SET DEFAULT nextval('public.aluno_codigo_seq'::regclass);


--
-- Name: curso codigo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.curso ALTER COLUMN codigo SET DEFAULT nextval('public.curso_codigo_seq'::regclass);


--
-- Name: departamento codigo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.departamento ALTER COLUMN codigo SET DEFAULT nextval('public.departamento_codigo_seq'::regclass);


--
-- Name: historicorestrito codigo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.historicorestrito ALTER COLUMN codigo SET DEFAULT nextval('public.historicorestrito_codigo_seq'::regclass);


--
-- Name: mensagem codigo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.mensagem ALTER COLUMN codigo SET DEFAULT nextval('public.mensagem_codigo_seq'::regclass);


--
-- Name: necessidadeespecial codigo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.necessidadeespecial ALTER COLUMN codigo SET DEFAULT nextval('public.necessidadeespecial_codigo_seq'::regclass);


--
-- Name: permissao codigo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.permissao ALTER COLUMN codigo SET DEFAULT nextval('public.permissao_codigo_seq'::regclass);


--
-- Name: servidor id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.servidor ALTER COLUMN id SET DEFAULT nextval('public.servidor_id_seq'::regclass);


--
-- Name: turma id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.turma ALTER COLUMN id SET DEFAULT nextval('public.turma_id_seq'::regclass);


--
-- Data for Name: aluno; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.aluno (codigo, nome, isativo) FROM stdin;
1	Ana Clara Dias	t
3	Carla Menezes	t
5	Eduarda Fontes	t
6	Felipe Amaral	t
7	Gabriela Siqueira	t
8	Henrique Duarte	t
9	Isabela Ramos	t
10	João Pedro Martins	t
11	Karen Silva	t
12	Lucas Oliveira	t
13	Mariana Costa	t
14	Natália Fernandes	t
15	Otávio Mendes	t
16	Patrícia Duarte	t
17	Rafael Gomes	t
18	Sofia Rocha	t
19	Tiago Barbosa	t
20	Vitória Nogueira	t
21	André Moreira	t
22	Bianca Teixeira	t
23	Caio Rezende	t
24	Débora Andrade	t
25	Elisa Cardoso	t
26	Fernando Bastos	t
27	Giovana Lima	t
28	Hugo Castro	t
29	Iara Ferreira	t
30	Juliano Matos	t
31	Keila Moreira	t
32	Leandro Sampaio	t
33	Michele Freitas	t
34	Nicolas Torres	t
35	Olívia Braga	t
36	Paulo Henrique	t
37	Queila Dias	t
38	Rodrigo Martins	t
39	Sara Moura	t
40	Túlio Costa	t
41	Ursula Mendes	t
42	Vinícius Rocha	t
43	Wesley Amaral	t
44	Yasmin Andrade	t
45	Zé Ricardo	t
46	Alana Bezerra	t
47	Bruna Dias	t
48	Carlos Eduardo	t
49	Daniela Ramos	t
50	Eduardo Rocha	t
51	Fernanda Lins	t
52	Gustavo Fernandes	t
53	Helena Souza	t
54	Ian Melo	t
55	Júlia Pires	t
56	Kleber Silva	t
57	Larissa Carvalho	t
58	Marcos Paulo	t
59	Nicole Ribeiro	t
60	Otávia Soares	t
61	Pedro Lucas	t
62	Quésia Lima	t
63	Ruan Santos	t
64	Samara Duarte	t
65	Tatiane Nogueira	t
66	Ulisses Lima	t
67	Vanessa Martins	t
68	William Reis	t
69	Xuxa Alves	t
70	Yuri Ferreira	t
71	Zilda Monteiro	t
72	Arthur Lopes	t
73	Beatriz Martins	t
74	Cláudio Silva	t
75	Daniele Souza	t
76	Erick Almeida	t
77	Fabiana Castro	t
78	Guilherme Lacerda	t
79	Helô Campelo	t
80	Igor Cardoso	t
81	Joana Prado	t
82	Kamila Duarte	t
83	Leonardo Nunes	t
84	Monique Ramos	t
85	Nelson Pinto	t
86	Oscar Meira	t
87	Priscila Gomes	t
88	Renan Torres	t
89	Silvana Medeiros	t
90	Thales Barreto	t
91	Ubirajara Cruz	t
92	Valentina Silva	t
93	Wellington Braga	t
94	Yanca Souza	t
95	Zeca Barreto	t
96	Amanda Morais	t
97	Bráulio Silva	t
98	Celina Torres	t
99	Diego Neves	t
100	Evelyn Rocha	t
101	Fabio Oliveira	t
102	Giselle Fontes	t
103	Heitor Mendes	t
4	Daniel Castro	t
104	Ana	f
2	Augusto Henrique	f
\.


--
-- Data for Name: aluno_necessidades; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.aluno_necessidades (aluno_id, necessidade_id) FROM stdin;
1	4
1	16
7	11
7	12
8	10
9	16
10	12
10	4
10	3
11	9
12	15
12	12
12	3
13	5
13	16
13	14
14	10
14	17
14	12
16	16
16	10
17	9
18	15
20	20
21	13
22	20
22	14
23	18
24	13
24	14
25	2
25	16
26	14
26	4
26	20
27	18
27	14
30	12
31	3
31	10
31	17
32	3
32	4
33	9
34	15
36	2
37	20
37	18
38	18
38	2
40	8
40	6
41	4
41	10
41	16
43	18
45	6
46	16
46	14
47	12
48	9
48	10
48	18
50	10
50	8
50	9
51	11
52	6
52	13
52	11
53	11
55	8
55	12
55	19
56	19
57	14
57	19
57	10
58	16
58	18
59	14
59	10
60	20
60	10
60	16
61	8
63	8
63	5
63	12
65	2
65	6
70	10
70	20
71	3
73	5
73	20
73	16
74	14
74	2
76	13
76	12
76	18
77	16
77	14
77	9
78	14
79	19
81	5
82	10
82	17
83	19
85	18
86	3
86	13
86	14
87	16
87	6
88	11
88	2
89	18
89	17
90	10
91	9
91	3
91	10
92	9
92	2
93	16
94	3
95	6
97	9
98	9
98	11
99	11
101	15
102	4
102	19
4	8
\.


--
-- Data for Name: curso; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.curso (codigo, nome) FROM stdin;
1	Analise e Desenvolvimento de Sistemas
2	Administração
3	Matemática
4	Engenharia Elétrica
\.


--
-- Data for Name: departamento; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.departamento (codigo, nome) FROM stdin;
1	Docente
2	Tecnologia de Informação (TI)
3	Coordenação
\.


--
-- Data for Name: historicorestrito; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.historicorestrito (codigo, datahora, ocorrencia, anotacao, codaluno, codservidor) FROM stdin;
3	2025-07-17 18:30:34.402024	Assunto	Ocorre^ncia	2	13
4	2025-07-17 18:47:01.599508	Aprovação em Programação Visual	Espero que os alunos Augusto Henrique e Pedro Henrique sejam aprovados na disciplina de Programação Visual.\n	2	15
5	2025-07-17 18:47:01.599508	Aprovação em Programação Visual	Espero que os alunos Augusto Henrique e Pedro Henrique sejam aprovados na disciplina de Programação Visual.\n	61	15
6	2025-07-17 18:48:07.734505	Aprovação em Programação Visual	Resposta a mensagem enviada	2	16
7	2025-07-17 18:48:07.734505	Aprovação em Programação Visual	Resposta a mensagem enviada	61	16
8	2025-07-17 18:48:29.293479	Aprovação em Programação Visual	Terceira Resposta	2	15
9	2025-07-17 18:48:29.293479	Aprovação em Programação Visual	Terceira Resposta	61	15
10	2025-07-17 18:55:03.797103	Assunto	Teste exclusão	2	13
11	2025-07-17 18:55:03.797103	Assunto	Teste exclusão	61	13
12	2025-07-17 19:05:51.809082	fgdgf	Teste 	8	9
\.


--
-- Data for Name: mensagem; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.mensagem (codigo, assunto, texto, codservidorremetente, datahoracriacao) FROM stdin;
10	Assunto	Ocorre^ncia	13	2025-07-17 18:30:34.402024
11	Aprovação em Programação Visual	Espero que os alunos Augusto Henrique e Pedro Henrique sejam aprovados na disciplina de Programação Visual.\n	15	2025-07-17 18:47:01.599508
12	Aprovação em Programação Visual	Resposta a mensagem enviada	16	2025-07-17 18:48:07.734476
13	Aprovação em Programação Visual	Terceira Resposta	15	2025-07-17 18:48:29.293479
14	Assunto	Teste exclusão	13	2025-07-17 18:55:03.797103
15	fgdgf	Teste 	9	2025-07-17 19:05:51.809052
\.


--
-- Data for Name: mensagem_aluno; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.mensagem_aluno (codmensagem, codaluno) FROM stdin;
11	61
12	61
13	61
14	61
15	8
\.


--
-- Data for Name: mensagem_destinatario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.mensagem_destinatario (codmensagem, codservidordestinatario) FROM stdin;
10	9
11	16
12	15
13	16
14	9
15	13
\.


--
-- Data for Name: necessidadeespecial; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.necessidadeespecial (codigo, codigonecessidade, descricao) FROM stdin;
2	NEC002	Deficiência auditiva
3	NEC003	Deficiência física
4	NEC004	Transtorno do espectro autista
5	NEC005	Dislexia
6	NEC006	Déficit de atenção
8	NEC008	Doença crônica
9	NEC009	Mobilidade reduzida
10	NEC010	Alergia severa
11	NEC011	Transtorno de ansiedade
12	NEC012	Epilepsia
13	NEC013	Síndrome de Down
14	NEC014	Problema de fala
15	NEC015	Problema de locomoção
16	NEC016	Baixa visão
17	NEC017	Problema auditivo leve
18	NEC018	Transtorno de aprendizagem
19	NEC019	Dependência medicamentosa
20	NEC020	Necessidade temporária
\.


--
-- Data for Name: permissao; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.permissao (codigo, descricao) FROM stdin;
1	Administrador
2	Servidor
\.


--
-- Data for Name: servidor; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.servidor (id, nome, departamento_id, permissao_id, usuario, senha, isfirstlogin, isativo) FROM stdin;
9	Administrador	3	1	admin	8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92	f	t
13	Pedro Henrique	2	1	pedro@gmail.com	8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92	f	t
14	Teste	1	2	teste88@gmail.com	8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92	f	f
16	Augusto	2	2	augusto@gmail.com	a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3	f	f
15	teste89	1	2	teste89@gmail.com	8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92	f	f
17	teste9999	1	2	teste999	8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92	t	f
19	asdf	1	2	asdfasdf	8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92	t	f
20	asdfg	1	2	asdfg	8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92	t	f
21	aasdf	1	2	aasdf	8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92	t	f
18	teste856	1	2	teste856	8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92	t	t
\.


--
-- Data for Name: turma; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.turma (id, nome, curso_id, ano) FROM stdin;
6	Turma	1	1° Ano
7	TURMA 2	2	2° Ano
\.


--
-- Data for Name: turma_aluno; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.turma_aluno (codturma, codaluno) FROM stdin;
6	46
6	96
6	21
6	72
6	73
6	22
6	47
6	97
6	23
\.


--
-- Data for Name: turma_servidor; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.turma_servidor (codturma, codservidor) FROM stdin;
6	9
6	13
\.


--
-- Name: aluno_codigo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.aluno_codigo_seq', 104, true);


--
-- Name: curso_codigo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.curso_codigo_seq', 4, true);


--
-- Name: departamento_codigo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.departamento_codigo_seq', 3, true);


--
-- Name: historicorestrito_codigo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.historicorestrito_codigo_seq', 12, true);


--
-- Name: mensagem_codigo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.mensagem_codigo_seq', 15, true);


--
-- Name: necessidadeespecial_codigo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.necessidadeespecial_codigo_seq', 20, true);


--
-- Name: permissao_codigo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.permissao_codigo_seq', 2, true);


--
-- Name: servidor_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.servidor_id_seq', 21, true);


--
-- Name: turma_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.turma_id_seq', 7, true);


--
-- Name: aluno_necessidades aluno_necessidades_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.aluno_necessidades
    ADD CONSTRAINT aluno_necessidades_pkey PRIMARY KEY (aluno_id, necessidade_id);


--
-- Name: aluno aluno_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.aluno
    ADD CONSTRAINT aluno_pkey PRIMARY KEY (codigo);


--
-- Name: curso curso_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.curso
    ADD CONSTRAINT curso_pkey PRIMARY KEY (codigo);


--
-- Name: departamento departamento_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.departamento
    ADD CONSTRAINT departamento_pkey PRIMARY KEY (codigo);


--
-- Name: historicorestrito historicorestrito_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.historicorestrito
    ADD CONSTRAINT historicorestrito_pkey PRIMARY KEY (codigo);


--
-- Name: mensagem mensagem_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.mensagem
    ADD CONSTRAINT mensagem_pkey PRIMARY KEY (codigo);


--
-- Name: necessidadeespecial necessidadeespecial_codigonecessidade_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.necessidadeespecial
    ADD CONSTRAINT necessidadeespecial_codigonecessidade_key UNIQUE (codigonecessidade);


--
-- Name: necessidadeespecial necessidadeespecial_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.necessidadeespecial
    ADD CONSTRAINT necessidadeespecial_pkey PRIMARY KEY (codigo);


--
-- Name: permissao permissao_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.permissao
    ADD CONSTRAINT permissao_pkey PRIMARY KEY (codigo);


--
-- Name: servidor servidor_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.servidor
    ADD CONSTRAINT servidor_pkey PRIMARY KEY (id);


--
-- Name: servidor servidor_usuario_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.servidor
    ADD CONSTRAINT servidor_usuario_key UNIQUE (usuario);


--
-- Name: turma_aluno turma_aluno_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.turma_aluno
    ADD CONSTRAINT turma_aluno_pkey PRIMARY KEY (codturma, codaluno);


--
-- Name: turma turma_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.turma
    ADD CONSTRAINT turma_pkey PRIMARY KEY (id);


--
-- Name: turma_servidor turma_servidor_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.turma_servidor
    ADD CONSTRAINT turma_servidor_pkey PRIMARY KEY (codturma, codservidor);


--
-- Name: servidor trigger_isativo_update; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER trigger_isativo_update AFTER UPDATE ON public.servidor FOR EACH ROW WHEN ((old.isativo IS DISTINCT FROM new.isativo)) EXECUTE FUNCTION public.notify_isativo_alterado();


--
-- Name: mensagem trigger_nova_mensagem; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER trigger_nova_mensagem AFTER INSERT ON public.mensagem FOR EACH ROW EXECUTE FUNCTION public.notify_new_message();


--
-- Name: aluno_necessidades aluno_necessidades_aluno_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.aluno_necessidades
    ADD CONSTRAINT aluno_necessidades_aluno_id_fkey FOREIGN KEY (aluno_id) REFERENCES public.aluno(codigo) ON DELETE CASCADE;


--
-- Name: aluno_necessidades aluno_necessidades_necessidade_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.aluno_necessidades
    ADD CONSTRAINT aluno_necessidades_necessidade_id_fkey FOREIGN KEY (necessidade_id) REFERENCES public.necessidadeespecial(codigo) ON DELETE CASCADE;


--
-- Name: historicorestrito historicorestrito_codaluno_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.historicorestrito
    ADD CONSTRAINT historicorestrito_codaluno_fkey FOREIGN KEY (codaluno) REFERENCES public.aluno(codigo) ON DELETE CASCADE;


--
-- Name: historicorestrito historicorestrito_codservidor_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.historicorestrito
    ADD CONSTRAINT historicorestrito_codservidor_fkey FOREIGN KEY (codservidor) REFERENCES public.servidor(id) ON DELETE CASCADE;


--
-- Name: mensagem_aluno mensagem_aluno_codaluno_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.mensagem_aluno
    ADD CONSTRAINT mensagem_aluno_codaluno_fkey FOREIGN KEY (codaluno) REFERENCES public.aluno(codigo);


--
-- Name: mensagem_aluno mensagem_aluno_codmensagem_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.mensagem_aluno
    ADD CONSTRAINT mensagem_aluno_codmensagem_fkey FOREIGN KEY (codmensagem) REFERENCES public.mensagem(codigo);


--
-- Name: mensagem mensagem_codservidorremetente_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.mensagem
    ADD CONSTRAINT mensagem_codservidorremetente_fkey FOREIGN KEY (codservidorremetente) REFERENCES public.servidor(id) ON DELETE CASCADE;


--
-- Name: mensagem_destinatario mensagem_destinatario_codmensagem_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.mensagem_destinatario
    ADD CONSTRAINT mensagem_destinatario_codmensagem_fkey FOREIGN KEY (codmensagem) REFERENCES public.mensagem(codigo);


--
-- Name: mensagem_destinatario mensagem_destinatario_codservidordestinatario_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.mensagem_destinatario
    ADD CONSTRAINT mensagem_destinatario_codservidordestinatario_fkey FOREIGN KEY (codservidordestinatario) REFERENCES public.servidor(id);


--
-- Name: servidor servidor_departamento_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.servidor
    ADD CONSTRAINT servidor_departamento_id_fkey FOREIGN KEY (departamento_id) REFERENCES public.departamento(codigo) ON DELETE CASCADE;


--
-- Name: servidor servidor_permissao_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.servidor
    ADD CONSTRAINT servidor_permissao_id_fkey FOREIGN KEY (permissao_id) REFERENCES public.permissao(codigo) ON DELETE CASCADE;


--
-- Name: turma_aluno turma_aluno_codaluno_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.turma_aluno
    ADD CONSTRAINT turma_aluno_codaluno_fkey FOREIGN KEY (codaluno) REFERENCES public.aluno(codigo) ON DELETE CASCADE;


--
-- Name: turma_aluno turma_aluno_codturma_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.turma_aluno
    ADD CONSTRAINT turma_aluno_codturma_fkey FOREIGN KEY (codturma) REFERENCES public.turma(id) ON DELETE CASCADE;


--
-- Name: turma turma_curso_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.turma
    ADD CONSTRAINT turma_curso_id_fkey FOREIGN KEY (curso_id) REFERENCES public.curso(codigo) ON DELETE CASCADE;


--
-- Name: turma_servidor turma_servidor_codservidor_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.turma_servidor
    ADD CONSTRAINT turma_servidor_codservidor_fkey FOREIGN KEY (codservidor) REFERENCES public.servidor(id) ON DELETE CASCADE;


--
-- Name: turma_servidor turma_servidor_codturma_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.turma_servidor
    ADD CONSTRAINT turma_servidor_codturma_fkey FOREIGN KEY (codturma) REFERENCES public.turma(id) ON DELETE CASCADE;


--
-- PostgreSQL database dump complete
--

