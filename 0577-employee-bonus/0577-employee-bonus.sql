# Write your MySQL query statement below
select name, bonus 
from Employee
Left Join Bonus
on Employee.empId = Bonus.empId
where bonus < 1000 OR Bonus is null