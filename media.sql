--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.4
-- Dumped by pg_dump version 9.5.4

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: clients; Type: TABLE; Schema: public; Owner: joannaanderson
--

CREATE TABLE clients (
    id integer NOT NULL,
    name character varying,
    phone character varying,
    email character varying,
    next_appt timestamp without time zone,
    img_url character varying,
    stylistid integer
);


ALTER TABLE clients OWNER TO joannaanderson;

--
-- Name: clients_id_seq; Type: SEQUENCE; Schema: public; Owner: joannaanderson
--

CREATE SEQUENCE clients_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE clients_id_seq OWNER TO joannaanderson;

--
-- Name: clients_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: joannaanderson
--

ALTER SEQUENCE clients_id_seq OWNED BY clients.id;


--
-- Name: stylists; Type: TABLE; Schema: public; Owner: joannaanderson
--

CREATE TABLE stylists (
    id integer NOT NULL,
    name character varying,
    phone character varying,
    img_url character varying,
    email character varying,
    bio character varying,
    instagram character varying,
    specialty character varying,
    days character varying
);


ALTER TABLE stylists OWNER TO joannaanderson;

--
-- Name: stylists_id_seq; Type: SEQUENCE; Schema: public; Owner: joannaanderson
--

CREATE SEQUENCE stylists_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE stylists_id_seq OWNER TO joannaanderson;

--
-- Name: stylists_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: joannaanderson
--

ALTER SEQUENCE stylists_id_seq OWNED BY stylists.id;


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: joannaanderson
--

ALTER TABLE ONLY clients ALTER COLUMN id SET DEFAULT nextval('clients_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: joannaanderson
--

ALTER TABLE ONLY stylists ALTER COLUMN id SET DEFAULT nextval('stylists_id_seq'::regclass);


--
-- Data for Name: clients; Type: TABLE DATA; Schema: public; Owner: joannaanderson
--

COPY clients (id, name, phone, email, next_appt, img_url, stylistid) FROM stdin;
3	Emily	123-456-7895	me@me.com	2016-09-27 00:00:00	img.com	3
10	Kerrie Shaw	(412)128-1284	example@example.com	2016-09-30 00:00:00	https://media1.popsugar-assets.com/files/thumbor/JstXk1MuzBQJkSQhYAUtMLRlz6o/fit-in/1024x1024/filters:format_auto-!!-:strip_icc-!!-/2016/08/01/960/n/1922153/c39fdbb3_edit_img_image_36107483_1461157200_instagramworthyhairsquare/i/Instagram-Hair-Tips.jpg	10
9	Rebecca Kim	(123)413-1438	example@example.com	2016-10-26 00:00:00	http://stayglam.com/wp-content/uploads/2015/11/salsalhair6-soft-textured-bob.jpg	10
11	Lilly Malkin	(421)182-1482	example@example.com	2016-10-27 00:00:00	http://static1.magazine.lorealprofessionnel.com/articles/5/38/5/@/882-the-most-enchanting-color-opal-hair-600x845-2.jpg	10
12	Tracy Baum	(235)123-5328	example@example.com	2016-11-17 00:00:00	http://s5.favim.com/610/141028/beautiful-beauty-girl-hair-Favim.com-2187315.jpg	10
\.


--
-- Name: clients_id_seq; Type: SEQUENCE SET; Schema: public; Owner: joannaanderson
--

SELECT pg_catalog.setval('clients_id_seq', 12, true);


--
-- Data for Name: stylists; Type: TABLE DATA; Schema: public; Owner: joannaanderson
--

COPY stylists (id, name, phone, img_url, email, bio, instagram, specialty, days) FROM stdin;
10	Joanne Chung	(703) 556-3303	http://static.boredpanda.com/blog/wp-content/uploads/2015/03/gray-granny-hair-trend-81__605.jpg	hairxjojo@gmail.com	Joanne can offer her guests a fresh start if they ever feel like they’re at a slump and need an extra boost of confidence! Of her many talents as a hairstylist, she especially enjoys using ombre and free-hand balayage techniques to create gorgeous and flattering highlights. When it comes to her cuts, she is equally innovative, and creates different shapes to fit each of her guests’ facial features.	hairxjojo	Balayage	M-F
\.


--
-- Name: stylists_id_seq; Type: SEQUENCE SET; Schema: public; Owner: joannaanderson
--

SELECT pg_catalog.setval('stylists_id_seq', 12, true);


--
-- Name: clients_pkey; Type: CONSTRAINT; Schema: public; Owner: joannaanderson
--

ALTER TABLE ONLY clients
    ADD CONSTRAINT clients_pkey PRIMARY KEY (id);


--
-- Name: stylists_pkey; Type: CONSTRAINT; Schema: public; Owner: joannaanderson
--

ALTER TABLE ONLY stylists
    ADD CONSTRAINT stylists_pkey PRIMARY KEY (id);


--
-- Name: public; Type: ACL; Schema: -; Owner: joannaanderson
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM joannaanderson;
GRANT ALL ON SCHEMA public TO joannaanderson;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

