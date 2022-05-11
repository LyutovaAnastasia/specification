--
-- PostgreSQL database dump
--

-- Dumped from database version 14.0
-- Dumped by pg_dump version 14.0

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: stories; Type: TABLE; Schema: specification; Owner: postgres
--

CREATE TABLE specification.stories (
    id bigint NOT NULL,
    brief character varying(255),
    description character varying(255),
    name character varying(255),
    type_id bigint
);


ALTER TABLE specification.stories OWNER TO postgres;

--
-- Name: types; Type: TABLE; Schema: specification; Owner: postgres
--

CREATE TABLE specification.types (
    id bigint NOT NULL,
    color character varying(255),
    name character varying(255)
);


ALTER TABLE specification.types OWNER TO postgres;

--
-- Data for Name: stories; Type: TABLE DATA; Schema: specification; Owner: postgres
--

COPY specification.stories (id, brief, description, name, type_id) FROM stdin;
4	brief4	description4	story4	5
3	brief3	description3	story3	5
5	brief5	description5	story5	4
7	brief7	description7	story7	6
8	brief8	description8	story8	6
9	brief9	description9	story9	6
\.


--
-- Data for Name: types; Type: TABLE DATA; Schema: specification; Owner: postgres
--

COPY specification.types (id, color, name) FROM stdin;
2	color2	type2
4	color4	type4
5	color5	type5
6	color6	type6
7	color7	type7
8	color8	type8
9	color9	type9
10	color10	type10
\.


--
-- Name: stories stories_pkey; Type: CONSTRAINT; Schema: specification; Owner: postgres
--

ALTER TABLE ONLY specification.stories
    ADD CONSTRAINT stories_pkey PRIMARY KEY (id);


--
-- Name: types types_pkey; Type: CONSTRAINT; Schema: specification; Owner: postgres
--

ALTER TABLE ONLY specification.types
    ADD CONSTRAINT types_pkey PRIMARY KEY (id);


--
-- Name: stories fk8i5vmneeoby74v38w8io6fxfd; Type: FK CONSTRAINT; Schema: specification; Owner: postgres
--

ALTER TABLE ONLY specification.stories
    ADD CONSTRAINT fk8i5vmneeoby74v38w8io6fxfd FOREIGN KEY (type_id) REFERENCES specification.types(id);


--
-- PostgreSQL database dump complete
--

