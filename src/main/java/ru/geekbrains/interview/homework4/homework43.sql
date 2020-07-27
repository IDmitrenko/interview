/* Список фильмов, для каждого — с указанием общего числа посетителей
    за все время, среднего числа зрителей за сеанс и
    общей суммы сборов по каждому фильму (отсортировать по убыванию прибыли).
   Внизу таблицы должна быть строчка «итого»,
   содержащая данные по всем фильмам сразу;
*/
(select f.name as "Название фильма",
        (select count(b.session_id)
         from public.bilet b
                  left join public.session s on s.film_id = f.id
         where b.session_id = s.id) as "Общее число посетителей",
        (select (round(cast((select count(b.session_id)
                             from public.bilet b
                             left join public.session s on s.film_id = f.id
                             where b.session_id = s.id) as numeric) /
                       cast((select count(s.film_id)
                       from public.session s
                       where s.film_id = f.id) as numeric), 2))) as "Среднее число зрителей за сеанс",
        (select sum(s.price)
         from public.session s
         left join public.bilet b on b.session_id = s.id
         where s.film_id = f.id ) as "Общая сумма сборов"
from public.film f
order by "Общая сумма сборов" desc)
UNION all
(select 'Итого:' as "Название фильма",
        cv.count_visitors as "Общее число посетителей",
        (select (round(cast(cv.count_visitors as numeric) /
                       cast(cs.count_session as numeric), 2))) as "Среднее число зрителей за сеанс",
        ta.total_amount as "Общая сумма сборов"
 from (select count(b.id) as count_visitors
       from public.bilet b) cv,
      (select count(s.id) as count_session
       from public.session s) cs,
      (select sum(s.price) as total_amount
       from public.session s
       left join public.bilet b on b.session_id = s.id) ta);