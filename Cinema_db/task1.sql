SELECT 
    m.title, time_start, time
FROM
    schedule AS s
        JOIN
    movie AS m ON s.movie_id = m.id
        JOIN
    session AS ss ON s.session_id = ss.id
WHERE
    m.time > ss.session_time
ORDER BY time;