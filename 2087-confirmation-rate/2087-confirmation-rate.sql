# Write your MySQL query statement below
Select user_id, round(avg(if(c.action="confirmed",1,0)),2) as confirmation_rate
From Signups s
Left Join Confirmations c
Using (user_id)
Group By user_id

