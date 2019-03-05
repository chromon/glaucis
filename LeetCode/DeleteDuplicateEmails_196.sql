# Write your MySQL query statement below

#delete p1 from Person p1, Person p2 where p1.Email = p2.Email and p1.Id > p2.id;

delete p1 from person p1 inner join person p2 on p1.email = p2.email where p1.id>p2.id