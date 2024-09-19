# Write your MySQL query statement below

-- Method1

-- SELECT employee_id, department_id
-- FROM Employee 
-- WHERE primary_flag = 'Y'
-- UNION
-- SELECT employee_id, department_id
-- FROM Employee 
-- GROUP BY employee_id
-- HAVING COUNT(employee_id) = 1
-- ORDER BY employee_id;

-- Method2

SELECT employee_id, department_id
FROM Employee
WHERE primary_flag = 'Y'
   OR employee_id IN (
       SELECT employee_id
       FROM Employee
       GROUP BY employee_id
       HAVING COUNT(employee_id) = 1
   );



