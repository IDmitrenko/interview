/* Ошибки в расписании (фильмы накладываются друг на друга),
    отсортированные по возрастанию времени.
   Выводить надо колонки «фильм 1», «время начала», «длительность»,
    «фильм 2», «время начала», «длительность»;
*/

select a.film_name as "Фильм 1", a.start_time as "Время начала",
       a.duration as "Длительность", a.end_time as "Время окончания",
       b.film_name as "Фильм 2", b.start_time as "Время начала",
       b.duration as "Длительность", b.end_time as "Время окончания"
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
where a.start_time < b.end_time and a.end_time > b.start_time and
      a.start_time < b.start_time and a.film_name != b.film_name
order by a.start_time;