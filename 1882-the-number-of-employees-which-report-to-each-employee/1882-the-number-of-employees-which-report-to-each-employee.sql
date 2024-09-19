-- SELECT 
--   reports_to as employee_id, 
--   (SELECT name FROM Employees WHERE employee_id = e.reports_to) as name, 
--   Count(e.employee_id) as reports_count, 
--   Round(Avg(e.age),0) as average_age
-- FROM 
--   Employees e
-- WHERE 
--   e.reports_to IS NOT NULL
-- GROUP BY 
--   e.reports_to
-- HAVING 
--   Count(e.employee_id) > 0
-- ORDER BY 
--   reports_to;


Select mgr.employee_id ,mgr.name, Count(emp.employee_id) as reports_count,Round(Avg(emp.age),0) as average_age
From Employees emp
Join Employees mgr
On emp.reports_to = mgr.employee_id
Group By mgr.employee_id
Order By mgr.employee_id