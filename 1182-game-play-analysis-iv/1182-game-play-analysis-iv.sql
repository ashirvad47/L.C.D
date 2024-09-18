# Write your MySQL query statement below
Select  round(count(distinct a1.player_id)/(Select count(Distinct player_id) From Activity),2) as fraction
From Activity a1 
Inner Join (Select player_id, min(event_date) as first_login from Activity group by player_id) as a2
On a1.player_id = a2.player_id and a1.event_date = a2.first_login + Interval 1 day