# Write your MySQL query statement below
-- Select user_id, CONCAT(UPPER(LEFT(name,1)), LOWER(RIGHT(name,LENGTH(name)-1))) as name
-- From Users
-- Order By user_id

SELECT user_id,CONCAT(UPPER(SUBSTR(name,1,1)),LOWER(SUBSTR(name,2))) AS name
FROM Users ORDER BY user_id;