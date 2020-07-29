CREATE SCHEMA IF NOT EXISTS public;

DROP TABLE IF EXISTS public.film;

CREATE TABLE public.film
(
    id integer,
    name character varying(128) NOT NULL,
    duration integer NOT NULL,
    PRIMARY KEY (id)
)
    WITH (
        OIDS = FALSE
    )
    TABLESPACE pg_default;

ALTER TABLE public.film
    OWNER to postgres;
COMMENT ON TABLE public.film
    IS 'Название фильмов';

DROP TABLE IF EXISTS public.session;

CREATE TABLE public.session
(
    id integer,
    film_id integer NOT NULL,
    start_time time(6) without time zone NOT NULL,
    price integer NOT NULL,
    PRIMARY KEY (id)
)
    WITH (
        OIDS = FALSE
    )
    TABLESPACE pg_default;

ALTER TABLE public.session
    OWNER to postgres;
COMMENT ON TABLE public.session
    IS 'Расписание сенансов';

ALTER TABLE public.session
    ADD CONSTRAINT fk_session_film FOREIGN KEY (film_id)
        REFERENCES public.film (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID;

COMMENT ON CONSTRAINT fk_session_film ON public.session
    IS 'ссылка на фильм';

DROP TABLE IF EXISTS public.bilet;

CREATE TABLE public.bilet
(
    id integer,
    "number" integer NOT NULL,
    session_id integer NOT NULL,
    PRIMARY KEY (id)
)
    WITH (
        OIDS = FALSE
    );

ALTER TABLE public.bilet
    OWNER to postgres;
COMMENT ON TABLE public.bilet
    IS 'Проданные билеты на сеанс';

ALTER TABLE public.bilet
    ADD CONSTRAINT fk_bilet_session FOREIGN KEY (session_id)
        REFERENCES public.session (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID;

COMMENT ON CONSTRAINT fk_bilet_session ON public.bilet
    IS 'Сссылка на сеанс';

BEGIN;
INSERT INTO public.film (id, name, duration)
       VALUES ('1'::integer, 'Унесенные ветром'::character varying, '120'::integer)
returning id;
INSERT INTO public.film (id, name, duration)
       VALUES ('2'::integer, 'Неуловимые мстители'::character varying, '90'::integer)
returning id;
INSERT INTO public.film (id, name, duration)
       VALUES ('3'::integer, 'Zorro'::character varying, '60'::integer)
returning id;
INSERT INTO public.film (id, name, duration)
       VALUES ('4'::integer, 'Любовь и голуби'::character varying, '120'::integer)
returning id;
INSERT INTO public.film (id, name, duration)
       VALUES ('5'::integer, 'Офицеры'::character varying, '90'::integer)
returning id;
COMMIT;

BEGIN;
INSERT INTO public.session (id, film_id, start_time, price)
       VALUES ('1'::integer, '1'::integer, '09:00'::time without time zone, '120'::integer)
returning id;
INSERT INTO public.session (id, film_id, start_time, price)
       VALUES ('2'::integer, '2'::integer, '10:30'::time without time zone, '80'::integer)
returning id;
INSERT INTO public.session (id, film_id, start_time, price)
       VALUES ('3'::integer, '3'::integer, '13:00'::time without time zone, '50'::integer)
returning id;
INSERT INTO public.session (id, film_id, start_time, price)
       VALUES ('4'::integer, '4'::integer, '15:00'::time without time zone, '150'::integer)
returning id;
INSERT INTO public.session (id, film_id, start_time, price)
       VALUES ('5'::integer, '5'::integer, '17:10'::time without time zone, '110'::integer)
returning id;
INSERT INTO public.session (id, film_id, start_time, price)
       VALUES ('6'::integer, '3'::integer, '19:00'::time without time zone, '75'::integer)
returning id;
INSERT INTO public.session (id, film_id, start_time, price)
       VALUES ('7'::integer, '2'::integer, '19:30'::time without time zone, '100'::integer)
returning id;
INSERT INTO public.session (id, film_id, start_time, price)
       VALUES ('8'::integer, '1'::integer, '21:10'::time without time zone, '160'::integer)
returning id;
INSERT INTO public.session (id, film_id, start_time, price)
       VALUES ('9'::integer, '2'::integer, '23:30'::time without time zone, '200'::integer)
returning id;
COMMIT;

BEGIN;
INSERT INTO public.bilet (id, "number", session_id)
       VALUES ('1'::integer, '100'::integer, '1'::integer)
returning id;
INSERT INTO public.bilet (id, "number", session_id)
       VALUES ('2'::integer, '101'::integer, '1'::integer)
returning id;
INSERT INTO public.bilet (id, "number", session_id)
       VALUES ('3'::integer, '102'::integer, '2'::integer)
returning id;
INSERT INTO public.bilet (id, "number", session_id)
       VALUES ('4'::integer, '103'::integer, '2'::integer)
returning id;
INSERT INTO public.bilet (id, "number", session_id)
       VALUES ('5'::integer, '104'::integer, '2'::integer)
returning id;
INSERT INTO public.bilet (id, "number", session_id)
       VALUES ('6'::integer, '105'::integer, '3'::integer)
returning id;
INSERT INTO public.bilet (id, "number", session_id)
       VALUES ('7'::integer, '106'::integer, '4'::integer)
returning id;
INSERT INTO public.bilet (id, "number", session_id)
       VALUES ('8'::integer, '107'::integer, '4'::integer)
returning id;
INSERT INTO public.bilet (id, "number", session_id)
       VALUES ('9'::integer, '108'::integer, '4'::integer)
returning id;
INSERT INTO public.bilet (id, "number", session_id)
       VALUES ('10'::integer, '109'::integer, '4'::integer)
returning id;
INSERT INTO public.bilet (id, "number", session_id)
       VALUES ('11'::integer, '110'::integer, '5'::integer)
returning id;
INSERT INTO public.bilet (id, "number", session_id)
       VALUES ('12'::integer, '111'::integer, '5'::integer)
returning id;
INSERT INTO public.bilet (id, "number", session_id)
       VALUES ('13'::integer, '112'::integer, '6'::integer)
returning id;
INSERT INTO public.bilet (id, "number", session_id)
       VALUES ('14'::integer, '113'::integer, '6'::integer)
returning id;
INSERT INTO public.bilet (id, "number", session_id)
       VALUES ('15'::integer, '114'::integer, '6'::integer)
returning id;
INSERT INTO public.bilet (id, "number", session_id)
       VALUES ('16'::integer, '115'::integer, '7'::integer)
returning id;
INSERT INTO public.bilet (id, "number", session_id)
       VALUES ('17'::integer, '116'::integer, '8'::integer)
returning id;
INSERT INTO public.bilet (id, "number", session_id)
       VALUES ('18'::integer, '117'::integer, '8'::integer)
returning id;
INSERT INTO public.bilet (id, "number", session_id)
       VALUES ('19'::integer, '118'::integer, '9'::integer)
returning id;
INSERT INTO public.bilet (id, "number", session_id)
       VALUES ('20'::integer, '119'::integer, '9'::integer)
returning id;
COMMIT;