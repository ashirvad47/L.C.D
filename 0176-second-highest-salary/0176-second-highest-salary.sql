# Write your MySQL query statement below
SELECT if(Count(Distinct salary)=1, null ,(SELECT Distinct salary FROM Employee
ORDER BY salary DESC
LIMIT 1 OFFSET 1)) AS SecondHighestSalary
FROM Employee

