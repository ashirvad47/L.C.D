Select mgr.employee_id ,mgr.name, Count(emp.employee_id) as reports_count,Round(Avg(emp.age),0) as average_age
From Employees emp
Join Employees mgr
On emp.reports_to = mgr.employee_id
Group By mgr.employee_id
Order By mgr.employee_id