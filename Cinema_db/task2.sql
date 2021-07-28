SELECT 
    m.title, time_start, time, time_end, session_time
FROM
    schedule AS s
        JOIN
    movie AS m ON s.movie_id = m.id
        JOIN
    session AS ss ON s.session_id = ss.id
WHERE
    time < session_time
        AND MINUTE(session_time - time) > MINUTE('00:30:00')
ORDER BY time DESC;