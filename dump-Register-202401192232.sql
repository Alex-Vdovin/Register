--
-- PostgreSQL database dump
--

-- Dumped from database version 8.4.22
-- Dumped by pg_dump version 14.2

-- Started on 2024-01-19 22:32:56

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = off;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET escape_string_warning = off;
SET row_security = off;

DROP DATABASE "Register";
--
-- TOC entry 1831 (class 1262 OID 82953)
-- Name: Register; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE "Register" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Russian_Russia.1251';


ALTER DATABASE "Register" OWNER TO postgres;

\connect "Register"

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = off;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET escape_string_warning = off;
SET row_security = off;

--
-- TOC entry 3 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO postgres;

--
-- TOC entry 1832 (class 0 OID 0)
-- Dependencies: 3
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA public IS 'standard public schema';


SET default_tablespace = '';

--
-- TOC entry 145 (class 1259 OID 83021)
-- Name: fridge_models; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.fridge_models (
    fridge_id bigint,
    model character varying
);


ALTER TABLE public.fridge_models OWNER TO postgres;

--
-- TOC entry 140 (class 1259 OID 82984)
-- Name: fridges; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.fridges (
    id bigint NOT NULL,
    name character varying NOT NULL,
    country character varying NOT NULL,
    manufacturer character varying NOT NULL,
    serial_number bigint NOT NULL,
    colour character varying NOT NULL,
    size bigint NOT NULL,
    price bigint NOT NULL,
    doors_amount bigint NOT NULL,
    compressor_type character varying NOT NULL,
    online_order_available boolean,
    installment_available boolean,
    gadget_available boolean
);


ALTER TABLE public.fridges OWNER TO postgres;

--
-- TOC entry 141 (class 1259 OID 82990)
-- Name: pc; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pc (
    id bigint NOT NULL,
    name character varying NOT NULL,
    country character varying NOT NULL,
    manufacturer character varying NOT NULL,
    serial_number bigint NOT NULL,
    colour character varying NOT NULL,
    size bigint NOT NULL,
    price bigint NOT NULL,
    category character varying NOT NULL,
    process_type character varying NOT NULL,
    online_order_available boolean,
    installment_available boolean,
    gadget_available boolean
);


ALTER TABLE public.pc OWNER TO postgres;

--
-- TOC entry 146 (class 1259 OID 83027)
-- Name: pc_models; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pc_models (
    pc_id bigint,
    model character varying
);


ALTER TABLE public.pc_models OWNER TO postgres;

--
-- TOC entry 147 (class 1259 OID 83033)
-- Name: smartphone_models; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.smartphone_models (
    smartphone_id bigint,
    model character varying
);


ALTER TABLE public.smartphone_models OWNER TO postgres;

--
-- TOC entry 142 (class 1259 OID 82996)
-- Name: smartphones; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.smartphones (
    id bigint NOT NULL,
    name character varying NOT NULL,
    country character varying NOT NULL,
    manufacturer character varying NOT NULL,
    serial_number bigint NOT NULL,
    colour character varying NOT NULL,
    size bigint NOT NULL,
    price bigint NOT NULL,
    memory_capacity bigint NOT NULL,
    cameras_amount bigint NOT NULL,
    online_order_available boolean,
    installment_available boolean,
    gadget_available boolean
);


ALTER TABLE public.smartphones OWNER TO postgres;

--
-- TOC entry 148 (class 1259 OID 83039)
-- Name: tvset_models; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tvset_models (
    tvset_id bigint,
    model character varying
);


ALTER TABLE public.tvset_models OWNER TO postgres;

--
-- TOC entry 143 (class 1259 OID 83002)
-- Name: tvsets; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tvsets (
    id bigint NOT NULL,
    name character varying NOT NULL,
    country character varying NOT NULL,
    manufacturer character varying NOT NULL,
    serial_number bigint NOT NULL,
    colour character varying NOT NULL,
    size bigint NOT NULL,
    price bigint NOT NULL,
    category character varying NOT NULL,
    technology character varying NOT NULL,
    online_order_available boolean,
    installment_available boolean,
    gadget_available boolean
);


ALTER TABLE public.tvsets OWNER TO postgres;

--
-- TOC entry 149 (class 1259 OID 83045)
-- Name: vacuum_cleaner_models; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.vacuum_cleaner_models (
    vacuum_cleaner_id bigint,
    model character varying
);


ALTER TABLE public.vacuum_cleaner_models OWNER TO postgres;

--
-- TOC entry 144 (class 1259 OID 83008)
-- Name: vacuum_cleaners; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.vacuum_cleaners (
    id bigint NOT NULL,
    name character varying NOT NULL,
    country character varying NOT NULL,
    manufacturer character varying NOT NULL,
    serial_number bigint NOT NULL,
    colour character varying NOT NULL,
    size bigint NOT NULL,
    price bigint NOT NULL,
    dust_box_capacity bigint NOT NULL,
    modes_amount bigint NOT NULL,
    online_order_available boolean,
    installment_available boolean,
    gadget_available boolean
);


ALTER TABLE public.vacuum_cleaners OWNER TO postgres;

--
-- TOC entry 1821 (class 0 OID 83021)
-- Dependencies: 145
-- Data for Name: fridge_models; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.fridge_models (fridge_id, model) FROM stdin;
1	model1
1	model2
1	model3
2	model4
2	model5
1	abstractModel
\.


--
-- TOC entry 1816 (class 0 OID 82984)
-- Dependencies: 140
-- Data for Name: fridges; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.fridges (id, name, country, manufacturer, serial_number, colour, size, price, doors_amount, compressor_type, online_order_available, installment_available, gadget_available) FROM stdin;
1	Birusa	Russia	BirusaCo	12345	white	100	1000	2	pomp	t	t	t
2	Bork	Germany	BorkCo	54321	black	150	3000	1	pomp	t	t	t
3	hz	Russia	HZaCo	678	blue	120	2000	2	pomp	t	t	t
\.


--
-- TOC entry 1817 (class 0 OID 82990)
-- Dependencies: 141
-- Data for Name: pc; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.pc (id, name, country, manufacturer, serial_number, colour, size, price, category, process_type, online_order_available, installment_available, gadget_available) FROM stdin;
1	TUF12345	China	ASUS	12345	silver	15	1000	Игровой	Intel	t	t	t
2	GL639SDK	China	MSI	54321	black	14	1200	Игровой	Intel	t	t	t
3	MacBook	USA	Apple	123	gold	13	2000	Slim	M3	t	t	t
1	14 PRO	China	Xiaomi	12345	white	6	600	12	4	t	t	t
\.


--
-- TOC entry 1822 (class 0 OID 83027)
-- Dependencies: 146
-- Data for Name: pc_models; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.pc_models (pc_id, model) FROM stdin;
\.


--
-- TOC entry 1823 (class 0 OID 83033)
-- Dependencies: 147
-- Data for Name: smartphone_models; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.smartphone_models (smartphone_id, model) FROM stdin;
\.


--
-- TOC entry 1818 (class 0 OID 82996)
-- Dependencies: 142
-- Data for Name: smartphones; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.smartphones (id, name, country, manufacturer, serial_number, colour, size, price, memory_capacity, cameras_amount, online_order_available, installment_available, gadget_available) FROM stdin;
1	14 PRO	China	Xiaomi	12345	white	6	600	12	4	t	t	t
2	15	USA	Apple	123	titan	7	1200	6	3	t	t	t
3	11	China	OnePlus	3572	green	7	800	12	4	t	t	t
\.


--
-- TOC entry 1824 (class 0 OID 83039)
-- Dependencies: 148
-- Data for Name: tvset_models; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tvset_models (tvset_id, model) FROM stdin;
\.


--
-- TOC entry 1819 (class 0 OID 83002)
-- Dependencies: 143
-- Data for Name: tvsets; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tvsets (id, name, country, manufacturer, serial_number, colour, size, price, category, technology, online_order_available, installment_available, gadget_available) FROM stdin;
1	S123	South Korea	Samsung	12345	black	60	2000	FULL HD	OLED	t	t	t
2	145464	China	LG	5432	black	100	3000	2K	QOLED	t	t	t
3	11	Валдай	Россия	3572	black	70	800	2K	OLED	t	t	t
\.


--
-- TOC entry 1825 (class 0 OID 83045)
-- Dependencies: 149
-- Data for Name: vacuum_cleaner_models; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.vacuum_cleaner_models (vacuum_cleaner_id, model) FROM stdin;
\.


--
-- TOC entry 1820 (class 0 OID 83008)
-- Dependencies: 144
-- Data for Name: vacuum_cleaners; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.vacuum_cleaners (id, name, country, manufacturer, serial_number, colour, size, price, dust_box_capacity, modes_amount, online_order_available, installment_available, gadget_available) FROM stdin;
1	Home and Pets	Germany	ThomasCo	12345	orange	100	30000	10	5	t	t	t
1	K300	Germany	Bork	12345	Red	100	300	20	1	t	t	t
2	K3300	Germany	Karcher	5432	yellow	100	500	30	3	t	t	t
3	Pet And Family	Germany	Thomas	3572	orange	100	450	30	5	t	t	t
\.


--
-- TOC entry 1833 (class 0 OID 0)
-- Dependencies: 3
-- Name: SCHEMA public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2024-01-19 22:32:57

--
-- PostgreSQL database dump complete
--

