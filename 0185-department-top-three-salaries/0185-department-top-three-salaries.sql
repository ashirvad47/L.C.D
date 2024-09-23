# Write your MySQL query statement below
Select d.name as Department, e.name as Employee, e.salary as Salary
From (
    Select name, salary, departmentId, Dense_Rank() Over (Partition by departmentId Order by Salary DESC) as denseRank
    From Employee
) AS e
Join Department d
On e.departmentId = d.id
Where e.denseRank <=3


-- go through the belowclever solution while revising 

-- select d.Name Department, e1.Name Employee, e1.Salary
-- from Employee e1 
-- join Department d
-- on e1.DepartmentId = d.Id
-- where 3 > (select count(distinct(e2.Salary)) 
--                   from Employee e2 
--                   where e2.Salary > e1.Salary 
--                   and e1.DepartmentId = e2.DepartmentId
--                   );