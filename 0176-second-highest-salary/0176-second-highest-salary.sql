# Write your MySQL query statement below

-- METHOD 1
SELECT if(Count(Distinct salary)=1, null ,(SELECT Distinct salary FROM Employee
ORDER BY salary DESC
LIMIT 1 OFFSET 1)) AS SecondHighestSalary
FROM Employee

-- -- METHOD 2
-- select
-- (select distinct Salary 
-- from Employee order by salary desc 
-- limit 1 offset 1) 
-- as SecondHighestSalary;
-- -- When a subquery doesn't produce any result, its return value is NULL. This behavior is consistent with SQL standards.


-- -- METHOD3(better one)
-- SELECT max(Salary) AS SecondHighestSalary
-- FROM Employee
-- WHERE Salary < (SELECT max(Salary) FROM Employee)