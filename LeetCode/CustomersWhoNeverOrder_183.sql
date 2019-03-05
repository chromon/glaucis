# Write your MySQL query statement below
select Name Customers 
    from Customers c 
    where c.id not in (
        select CustomerId from Orders
    )