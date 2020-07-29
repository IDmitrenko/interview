/* Число посетителей и кассовые сборы, сгруппированные
    по времени начала фильма:
     с 9 до 15, с 15 до 18,
     с 18 до 21,
     с 21 до 00:00
   (сколько посетителей пришло с 9 до 15 часов и т.д.)
 */
select ' с 9-00 до 15-00' as "Время начала фильма",
       cv.count_visitors as "Число посетителей",
       pa.period_amount as "Кассовые сборы"
from (select count(b.id) as count_visitors
      from public.bilet b
      left join public.session s on s.id = b.session_id
      where s.start_time between '09:00'::time without time zone and '14:59'::time without time zone) cv,
     (select sum(s.price) as period_amount
      from public.session s
      left join public.bilet b on b.session_id = s.id
      where s.start_time between '09:00'::time without time zone and '14:59'::time without time zone) pa
UNION ALL
select ' с 15-00 до 18-00' as "Время начала фильма",
       cv.count_visitors as "Число посетителей",
       pa.period_amount as "Кассовые сборы"
from (select count(b.id) as count_visitors
      from public.bilet b
      left join public.session s on s.id = b.session_id
      where s.start_time between '15:00'::time without time zone and '17:59'::time without time zone) cv,
     (select sum(s.price) as period_amount
      from public.session s
      left join public.bilet b on b.session_id = s.id
      where s.start_time between '15:00'::time without time zone and '17:59'::time without time zone) pa
UNION ALL
select ' с 18-00 до 21-00' as "Время начала фильма",
       cv.count_visitors as "Число посетителей",
       pa.period_amount as "Кассовые сборы"
from (select count(b.id) as count_visitors
      from public.bilet b
      left join public.session s on s.id = b.session_id
      where s.start_time between '18:00'::time without time zone and '20:59'::time without time zone) cv,
     (select sum(s.price) as period_amount
      from public.session s
      left join public.bilet b on b.session_id = s.id
      where s.start_time between '18:00'::time without time zone and '20:59'::time without time zone) pa
UNION ALL
select ' с 21-00 до 00-00' as "Время начала фильма",
       cv.count_visitors as "Число посетителей",
       pa.period_amount as "Кассовые сборы"
from (select count(b.id) as count_visitors
      from public.bilet b
      left join public.session s on s.id = b.session_id
      where s.start_time between '21:00'::time without time zone and '23:59'::time without time zone) cv,
     (select sum(s.price) as period_amount
      from public.session s
      left join public.bilet b on b.session_id = s.id
      where s.start_time between '21:00'::time without time zone and '23:59'::time without time zone) pa