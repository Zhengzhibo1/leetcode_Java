/*方法1 使用GROUP BY + 临时表*/
SELECT Email
FROM (SELECT Email, count(Email) as num
    FROM Person
    GROUP BY Email
    )as statistic
where num > 1;

/*方法2 使用GROUP BY + HAVING*/
SELECT Email 
FROM Person
GROUP BY Email HAVING count(Email) > 1;
