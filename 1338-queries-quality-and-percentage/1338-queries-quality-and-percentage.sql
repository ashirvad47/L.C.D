# Write your MySQL query statement below
Select query_name,
        Round(Avg(rating/position),2) as quality,
    Round(Avg(if(rating<3, 1,0))*100,2)as poor_query_percentage
From Queries
where query_name is not null
Group By query_name
