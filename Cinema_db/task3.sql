SELECT 
    m.title, sal.people_traffic, sal.sale
FROM
    movie_sales AS sal
        JOIN
    movie AS m ON sal.movie_id = m.id 
UNION ALL SELECT 
    'TOTAL', sum(sal.people_traffic), SUM(sal.sale)
FROM
    movie_sales AS sal
        JOIN
    movie AS m ON sal.movie_id = m.id
ORDER BY sale DESC;