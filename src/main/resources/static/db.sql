--
-- PostgreSQL database dump
--

-- Dumped from database version 13.4 (Ubuntu 13.4-0ubuntu0.21.04.1)
-- Dumped by pg_dump version 13.4 (Ubuntu 13.4-0ubuntu0.21.04.1)

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
-- Name: orders; Type: TABLE; Schema: public; Owner: alexx
--

CREATE TABLE public.orders (
    order_number integer,
    consumer_email character varying(50),
    create_date date,
    id integer NOT NULL
);


ALTER TABLE public.orders OWNER TO alexx;

--
-- Name: orders_id_seq; Type: SEQUENCE; Schema: public; Owner: alexx
--

CREATE SEQUENCE public.orders_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.orders_id_seq OWNER TO alexx;

--
-- Name: orders_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: alexx
--

ALTER SEQUENCE public.orders_id_seq OWNED BY public.orders.id;


--
-- Name: product; Type: TABLE; Schema: public; Owner: alexx
--

CREATE TABLE public.product (
    price numeric,
    delete boolean DEFAULT false,
    article integer NOT NULL,
    title character varying(50),
    id integer NOT NULL
);


ALTER TABLE public.product OWNER TO alexx;

--
-- Name: TABLE product; Type: COMMENT; Schema: public; Owner: alexx
--

COMMENT ON TABLE public.product IS 'order_id';


--
-- Name: product_id_seq; Type: SEQUENCE; Schema: public; Owner: alexx
--

CREATE SEQUENCE public.product_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.product_id_seq OWNER TO alexx;

--
-- Name: product_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: alexx
--

ALTER SEQUENCE public.product_id_seq OWNED BY public.product.id;


--
-- Name: product_orders; Type: TABLE; Schema: public; Owner: alexx
--

CREATE TABLE public.product_orders (
    order_id integer NOT NULL,
    product_id integer NOT NULL,
    id integer NOT NULL
);


ALTER TABLE public.product_orders OWNER TO alexx;

--
-- Name: product_orders_id_seq; Type: SEQUENCE; Schema: public; Owner: alexx
--

CREATE SEQUENCE public.product_orders_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.product_orders_id_seq OWNER TO alexx;

--
-- Name: product_orders_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: alexx
--

ALTER SEQUENCE public.product_orders_id_seq OWNED BY public.product_orders.id;


--
-- Name: orders id; Type: DEFAULT; Schema: public; Owner: alexx
--

ALTER TABLE ONLY public.orders ALTER COLUMN id SET DEFAULT nextval('public.orders_id_seq'::regclass);


--
-- Name: product id; Type: DEFAULT; Schema: public; Owner: alexx
--

ALTER TABLE ONLY public.product ALTER COLUMN id SET DEFAULT nextval('public.product_id_seq'::regclass);


--
-- Name: product_orders id; Type: DEFAULT; Schema: public; Owner: alexx
--

ALTER TABLE ONLY public.product_orders ALTER COLUMN id SET DEFAULT nextval('public.product_orders_id_seq'::regclass);


--
-- Data for Name: orders; Type: TABLE DATA; Schema: public; Owner: alexx
--

COPY public.orders (order_number, consumer_email, create_date, id) FROM stdin;
1303010650	aleksej@mail.com	2021-09-04	1
1252344784	mutko@email.email	2021-09-05	13
1252368229	volodya@email.email	2021-09-05	8
1252394975	89991574178@email.email	2021-09-05	6
1252304398	samsung@email.email	2021-09-05	17
1252492788	8998324@email.email	2021-09-05	2
1252338076	kitill@email.email	2021-09-05	14
1252461826	asdqe12@email.email	2021-09-05	4
1252400439	89991574178@email.email	2021-09-05	5
1252377950	putin@email.email	2021-09-05	7
1252318838	kitill@email.email	2021-09-05	16
1252484547	alafaasd@email.email	2021-09-05	3
1252353006	mutko@email.email	2021-09-05	12
1252301095	samsung@email.email	2021-09-05	18
1252364168	volodya@email.email	2021-09-05	10
1252332911	kitill@email.email	2021-09-05	15
1252367637	volodya@email.email	2021-09-05	9
1252363707	volodya@email.email	2021-09-05	11
1231471246	aleksej@mail.ru	2021-09-05	19
1231469046	aleksej@mail.ru	2021-09-05	20
1231468386	aleksej@mail.ru	2021-09-05	21
1231467880	aleksej@mail.ru	2021-09-05	22
1231467441	aleksej@mail.ru	2021-09-05	23
1231467033	aleksej@mail.ru	2021-09-05	24
1219680072	zidan@mail.ru	2021-09-05	25
1219679011	zidan@mail.ru	2021-09-05	26
1219678337	zidan@mail.ru	2021-09-05	27
1219677757	zidan@mail.ru	2021-09-05	28
1219656755	murmurmur@mail.ru	2021-09-05	29
1219654619	murmurmur@mail.ru	2021-09-05	30
1219652900	murmurmur@mail.ru	2021-09-05	31
1219644781	vasiliy@mail.ru	2021-09-05	32
1219640871	vasiliy@mail.ru	2021-09-05	33
1219633936	putin@mail.ru	2021-09-05	34
1219632311	putin@mail.ru	2021-09-05	35
1219582530	79999@mail.ru	2021-09-05	36
\.


--
-- Data for Name: product; Type: TABLE DATA; Schema: public; Owner: alexx
--

COPY public.product (price, delete, article, title, id) FROM stdin;
21999	f	210002116	Asus Laptop11 11.6, black	1
21999	f	210003156	Asus laptop 15 15.6, black	2
21999	f	210004156	Lenovo IdeaPad S145 15.6, gray	3
22899	f	220005116	Lenovo IdeaPad 1 11.6, blue	4
22999	f	220006116	LenovoIdeaPad 1 11.6, blue	5
22999	f	220007140	Acer Aspire 1 11.6, blue	6
22999	f	220008156	Irbis NB261 15.6, gray	7
22999	f	220009156	Irbis NB262 15.6, gray	8
23999	f	230010156	Acer Aspire 3 15.6, black	9
23999	f	230011156	HP Laptop 15s 15.6, black	10
23999	f	230012156	Lenovo IdeaPad S145 15.6 gray	11
24999	f	230013140	Acer Swift 1, 14.0, gold	12
24999	f	240014140	Acer Swift 1 14.0, gray	13
24999	f	240015140	Acer Swift 1 14.0, bronze	14
24999	f	240016140	HP laptop 14s 14.0, black	15
25099	f	250016140	Lenovo V14 ADA 14.0, black	16
25499	f	250017156	Lenovo HP 250 G7 15.6, black	17
17999	f	170007141	DigmaEVE C411 14.1, gray	18
17999	f	170006133	Irbis NB279 13.3, blue	19
17099	f	170005156	Irbis NB260 15.6, black	20
19999	f	190012141	Prestigio SmartBook 13.3, gray	21
13999	f	130002116	Digma Eve 11 11.6, black	22
19999	f	190011140	Lenovo IdeaPad Slim 14.0, blue	23
18999	f	180008116	Asus Laptop E210 11.6, blue	24
18999	f	180010141	Irbis NB144 14.1, gray	25
17099	f	170004141	Irbis NB248 14.1, black	26
19999	f	190013156	Digma C413 15.6, gray	27
15999	f	150003140	Irbis NB257 14.0, gray	28
13000	f	13001116	acer travelMate 11.6, black	29
19999	f	190012140	Lenovo IdeaPad Slim 14.0, gray	30
18999	f	180009116	Asus Laptop E210 11.6, gray	31
20999	f	200001156	Digma EVE15 15.6, gray	32
\.


--
-- Data for Name: product_orders; Type: TABLE DATA; Schema: public; Owner: alexx
--

COPY public.product_orders (order_id, product_id, id) FROM stdin;
19	26	67
19	4	68
19	30	69
20	26	70
20	4	71
20	30	72
21	26	73
21	4	74
21	30	75
22	26	76
22	4	77
22	30	78
23	26	79
23	4	80
23	30	81
24	26	82
24	4	83
24	30	84
25	29	85
25	31	86
25	32	87
26	29	88
26	31	89
26	32	90
27	29	91
27	31	92
27	32	93
28	29	94
28	31	95
28	32	96
29	17	97
29	14	98
29	6	99
30	17	100
30	6	101
31	17	102
32	17	103
32	6	104
32	24	105
33	24	106
34	29	107
34	24	108
35	29	109
35	31	110
35	24	111
36	29	112
36	31	113
36	6	114
36	24	115
\.


--
-- Name: orders_id_seq; Type: SEQUENCE SET; Schema: public; Owner: alexx
--

SELECT pg_catalog.setval('public.orders_id_seq', 36, true);


--
-- Name: product_id_seq; Type: SEQUENCE SET; Schema: public; Owner: alexx
--

SELECT pg_catalog.setval('public.product_id_seq', 32, true);


--
-- Name: product_orders_id_seq; Type: SEQUENCE SET; Schema: public; Owner: alexx
--

SELECT pg_catalog.setval('public.product_orders_id_seq', 115, true);


--
-- Name: orders orders_pk; Type: CONSTRAINT; Schema: public; Owner: alexx
--

ALTER TABLE ONLY public.orders
    ADD CONSTRAINT orders_pk PRIMARY KEY (id);


--
-- Name: product_orders orders_products_pkey; Type: CONSTRAINT; Schema: public; Owner: alexx
--

ALTER TABLE ONLY public.product_orders
    ADD CONSTRAINT orders_products_pkey PRIMARY KEY (order_id, product_id);


--
-- Name: product product_pk; Type: CONSTRAINT; Schema: public; Owner: alexx
--

ALTER TABLE ONLY public.product
    ADD CONSTRAINT product_pk PRIMARY KEY (id);


--
-- Name: product_orders orders_products_product_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: alexx
--

ALTER TABLE ONLY public.product_orders
    ADD CONSTRAINT orders_products_product_id_fkey FOREIGN KEY (product_id) REFERENCES public.product(id);


--
-- PostgreSQL database dump complete
--

