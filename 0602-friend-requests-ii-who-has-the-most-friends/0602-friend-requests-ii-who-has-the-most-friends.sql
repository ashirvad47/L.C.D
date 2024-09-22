# Write your MySQL query statement below
SELECT id, count(id) as num
FROM
((SELECT requester_id as id
From RequestAccepted)
Union ALL
(SELECT accepter_id as id
From RequestAccepted)) as t
Group By id
Order By (Count(id)) desc
limit 1;


