# Write your MySQL query statement below
SELECT
    project_id, Round(SUM(experience_years)/Count(*),2) as average_years
FROM
    Project
JOIN 
    Employee
USING 
    (employee_id)
GROUP BY
    project_id
