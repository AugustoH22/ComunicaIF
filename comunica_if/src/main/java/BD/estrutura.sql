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
    nome character varying(100) NOT NULL
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
    datahora character varying(20) NOT NULL,
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
    datahoracriacao date NOT NULL
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
    senha character varying(255) NOT NULL
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

