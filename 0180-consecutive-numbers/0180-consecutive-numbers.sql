# Write your MySQL query statement below
Select Distinct i1.num as ConsecutiveNums
From Logs i1, Logs i2, Logs i3
Where i1.id = i2.id + 1 AND i2.id = i3.id + 1
  AND i1.num= i2.num AND i2.num = i3.num