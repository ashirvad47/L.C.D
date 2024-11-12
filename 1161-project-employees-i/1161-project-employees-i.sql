# Write your MySQL query statement below
SELECT
    project_id, Round(Avg(experience_years),2) AS average_years
FROM
    Project
JOIN 
    Employee
USING 
    (employee_id)
GROUP BY
    project_id
