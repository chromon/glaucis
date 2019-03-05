# Write your MySQL query statement below
select Weather.Id
from Weather
join Weather W on datediff(Weather.Recorddate,W.Recorddate)=1
and Weather.Temperature>W.Temperature;