# Write your MySQL query statement below
-- SELECT contest_id, ROUND(COUNT(r.user_id) / (SELECT COUNT(*) FROM Users) * 100, 2) as percentage
-- FROM Register r
-- JOIN Users u
-- USING (user_id)
-- GROUP BY r.contest_id
-- ORDER BY percentage DESC, contest_id ASC


select contest_id, 
round(count(user_id) * 100.0 / (select count(user_id) from Users), 2) as percentage
from Register
group by contest_id
order by percentage desc, contest_id;