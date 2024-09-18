# Write your MySQL query statement below
Select if(Count(num)=1,num,null) as num
From MyNumbers
Group By num
-- Having Count(num)=1
Order By num DESC
Limit 1