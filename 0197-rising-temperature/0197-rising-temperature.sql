# Write your MySQL query statement below
Select w1.id 
from weather w1 Inner Join weather w2 
on datediff(w1.recordDate, w2.recordDate)= 1
where w1.temperature>w2.temperature