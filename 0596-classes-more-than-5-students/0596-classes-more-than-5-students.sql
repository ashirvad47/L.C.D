# Write your MySQL query statement below
Select class 
From Courses
Group By class
Having Count(class) > 4