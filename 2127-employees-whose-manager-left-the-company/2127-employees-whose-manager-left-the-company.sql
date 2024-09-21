# Write your MySQL query statement below
SELECT e1.employee_id
FROM Employees e1
LEFT JOIN Employees e2
ON e1.manager_id = e2.employee_id
WHERE e1.salary < 30000 AND e2.employee_id IS NULL AND e1.manager_id IS NOT NULL
ORDER BY e1.employee_id;


-- Select employee_id
-- From Employees
-- Where salary<30000 AND manager_id NOT IN (Select employee_id From Employees)
-- Order By employee_id
