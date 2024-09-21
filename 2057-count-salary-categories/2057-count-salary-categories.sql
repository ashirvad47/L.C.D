# Write your MySQL query statement belows
SELECT 
    'Low Salary' AS category,
    SUM(income < 20000) AS accounts_count
FROM 
    Accounts

UNION 

    SELECT 
        'Average Salary' AS category,
        SUM(income BETWEEN 20000 AND 50000 ) AS accounts_count
    FROM 
        Accounts

UNION

    SELECT 
        'High Salary' AS category,
        SUM(income > 50000) AS accounts_count
    FROM 
        Accounts;

-- Smart Solution
-- sum(income < 20000)
-- Actually income < 2000 is bool , that return 1 or 0, when u do sum(income < 20000) it's the sum of 1 or sum of 0 or both, so it count how much category is less than 20000
