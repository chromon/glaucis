# Write your MySQL query statement below
select a.Score, sum(case when b.Score>=a.Score then 1 end) as Rank from Scores a, (select distinct Score from Scores ) b group by a.id order by a.Score desc; 