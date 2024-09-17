# Write your MySQL query statement below
SELECT contest_id, ROUND(COUNT(r.user_id) / (SELECT COUNT(*) FROM Users) * 100, 2) as percentage
FROM Register r
JOIN Users u
USING (user_id)
GROUP BY r.contest_id
ORDER BY percentage DESC, contest_id ASC
