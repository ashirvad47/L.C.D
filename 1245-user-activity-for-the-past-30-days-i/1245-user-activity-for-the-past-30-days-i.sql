# Write your MySQL query statement below
Select activity_date as day, count(distinct user_id) as active_users
From Activity
WHERE activity_date BETWEEN '2019-06-28' AND '2019-07-27'
Group By activity_date