/* Перерывы 30 минут и более между фильмами —
    выводить по уменьшению длительности перерыва.
   Колонки «фильм 1», «время начала», «длительность»,
   «время начала второго фильма», «длительность перерыва»;
*/
select a.film_name as "Фильм 1", a.start_time as "Время начала",
       a.duration as "Длительность",
       b.film_name as "Фильм 2", b.start_time as "Время начала",
       b.start_time - a.end_time as "Длительность перерыва"
from (select f.name as film_name,
             s.start_time as start_time,
             f.duration as duration,
             s.start_time + (f.duration * interval '1 minute') as end_time
      from public.session s
      left join public.film f on f.id = s.film_id) a,
     (select f.name as film_name,
             s.start_time as start_time,
             f.duration as duration,
             s.start_time + (f.duration * interval '1 minute') as end_time
      from public.session s
      left join public.film f on f.id = s.film_id) b
where a.end_time < b.start_time and
      (b.start_time - a.end_time) >= (30 * interval '1 minute') and
      a.start_time < b.start_time and a.film_name != b.film_name and
      (b.start_time - a.end_time) = (select min(bb.start_time - a.end_time)
                                     from (select f.name as film_name,
                                                  s.start_time as start_time,
                                                  f.duration as duration,
                                                  s.start_time + (f.duration * interval '1 minute') as end_time
                                           from public.session s
                                           left join public.film f on f.id = s.film_id) bb
                                     where bb.film_name != a.film_name and a.end_time < bb.start_time)
order by "Длительность перерыва" desc;