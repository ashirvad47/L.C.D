# Write your MySQL query statement below
-- SELECT  Round(Sum(tiv_2016),2) as tiv_2016
-- FROM Insurance
-- WHERE tiv_2015 IN (
--   Select i1.tiv_2015 
--   From Insurance i1
--   Join Insurance i2
--   On i1.tiv_2015 = i2.tiv_2015 and i1.pid != i2.pid
-- ) AND (lat, lon ) not in (
--   Select i1.lat, i1.lon 
--   From Insurance i1
--   Join Insurance i2
--   On i1.pid != i2.pid and (i1.lat = i2.lat and i1.lon = i2.lon)
-- )

SELECT ROUND(SUM(tiv_2016), 2) AS tiv_2016
FROM Insurance
WHERE (lat, lon) IN (
    SELECT lat, lon 
    FROM Insurance 
    GROUP BY lat, lon 
    HAVING COUNT(*) = 1
)
AND tiv_2015 IN (
    SELECT tiv_2015 
    FROM Insurance 
    GROUP BY tiv_2015 
    HAVING COUNT(tiv_2015) > 1
);